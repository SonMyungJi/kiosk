package homework.kiosk;


import java.util.*;

class Order {
    static Scanner scanner = new Scanner(System.in);

    // 메뉴판 5번, 6번
    String[][] orderArray = {
            {"Order", "장바구니를 확인 후 주문합니다."},
            {"Cancel", "진행 중인 주문을 취소합니다."},
    };

    public void displayOrder() {
        System.out.println("[ ORDER MENU ]");
        for (int i = 0; i < orderArray.length; i++) {
            String[] order = orderArray[i];
            System.out.println((i + 5) + ". " + (order[0]) + ": " + order[1]);
        }
    }

    // 장바구니에 객체 추가
    // 주문 개수 기능 추가
    private float totalSum;
    private HashMap<String[], Integer> cart = new HashMap<>();
    private HashMap<String, Integer> soldProducts = new HashMap<String, Integer>();

    public void addToCart(String[] selectedMenu) {
        // 이미 선택된 메뉴인지 확인
        if (cart.containsKey(selectedMenu)) {    // 이미 선택된 경우, 등장 횟수를 1 증가시킴
            int count = cart.get(selectedMenu);
            cart.put(selectedMenu, count+1);
        } else {                                 // 최초 선택된 경우, 등장 횟수를 1로 설정
            cart.put(selectedMenu, 1);
        }
    }

    // 가격을 더하는 메서드
    float priceSum() {
        float priceSum = 0.0f;

        for (Map.Entry<String[], Integer> entry : cart.entrySet()) {
            String[] selectedMenu = entry.getKey();
            int count = entry.getValue();

            float price = Float.parseFloat(selectedMenu[1]);
            priceSum += price * count;
        }

        // 반올림하여 소수점 첫째 자리까지 표시
        priceSum = Math.round(priceSum * 10.0f) / 10.0f;

        return priceSum;
    }


    public void show() {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        if (cart.isEmpty()){
            System.out.println("장바구니가 비어 있습니다.");
            return;
        } else {
            for (Map.Entry<String[], Integer> entry : cart.entrySet()) {
                String[] item = entry.getKey();
                int count = entry.getValue();
                System.out.printf("%-15s W %2s %2s개 %2s\n", item[0], item[1], count, item[2] );
            }
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W "+ priceSum());
        System.out.println("\n1. 주문\n2. 메뉴판");
        int choice = scanner.nextInt();
        if (choice==1) {
            float priceSum = priceSum();
            totalSum += priceSum();

            // 주문이 완료되면 해당 주문의 상품들을 판매된 상품 목록에 추가
            for (Map.Entry<String[], Integer> entry : cart.entrySet()) {
                String[] item = entry.getKey();
                int count = entry.getValue();
                String productKey = Arrays.toString(item);
                int soldCount = soldProducts.getOrDefault(productKey, 0);
                soldProducts.put(productKey, soldCount + count);
            }

            cart.clear();
            System.out.println("주문이 완료되었습니다!");
            System.out.println();
            System.out.println("대기번호는 입니다.");
            System.out.println("3초 후 메뉴판으로 돌아갑니다.");
        }
    }

    public void cancel() {
        System.out.println("진행하던 주문을 취소하시겠습니까?\n1. 확인\n2. 취소");
        int choice = scanner.nextInt();
        if (choice==1){
            cart.clear();
            System.out.println("진행하던 주문이 취소되었습니다.");
        }
    }

    // 총 판매금액을 더하는 메서드
    float totalSum() {
        return totalSum;
    }

    // 총 판매상품 목록 조회 기능 메서드
    public void showSoldProducts() {
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();
        for (Map.Entry<String, Integer> entry : soldProducts.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            System.out.printf(item + "%2d개\n", count);
        }
        System.out.println();
        System.out.println("1. 돌아가기");
    }


    public void hidden() {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W "+totalSum()+" ] 입니다.");
        System.out.println();
        showSoldProducts();
        int choice = scanner.nextInt();
    }
}