package homework.kiosk;


import java.util.*;

class Order {

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

    // 장바구니에 객체 넣기 Arraylist
    // 주문 시 중복은 없애되 몇 번 선택되었는지 확인할 수 있는 HashMap
    // 판매 완료시 팔린 메뉴들을 순서대로 출력할 수 있는 LinkedHashMap
    private double totalSum; // 총 팔린 금액
    private final HashMap<String[], Integer> cart = new HashMap<>();
    private final LinkedHashMap<String[], Integer> soldProducts = new LinkedHashMap<>();

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
    double priceSum() {
        double priceSum = 0.0;

        for (Map.Entry<String[], Integer> entry : cart.entrySet()) {
            String[] selectedMenu = entry.getKey();
            int count = entry.getValue();

            double price = Double.valueOf(selectedMenu[1]);
            priceSum += price * count;
        }

        return priceSum;
    }


    public void show() {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        } else {
            for (Map.Entry<String[], Integer> entry : cart.entrySet()) {
                String[] item = entry.getKey();
                int count = entry.getValue();
                System.out.printf("%-15s W %2s %2s개 %2s\n", item[0], item[1], count, item[2]);
            }
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + priceSum());
    }

    public void sell(Scanner scanner) {
        System.out.println("\n1. 주문\n2. 메뉴판");
        int choice = scanner.nextInt();
        if (choice==1) {
            totalSum += priceSum();

            // 주문이 완료되면 해당 주문의 상품들을 판매된 상품 목록에 추가
            for (Map.Entry<String[], Integer> entry : cart.entrySet()) {
                String[] item = entry.getKey();
                int count = entry.getValue();
                String[] productKey = new String[]{item[0], "W "+item[1]};
                soldProducts.put(productKey, count);
            }

            cart.clear();
            System.out.println("주문이 완료되었습니다!");
            System.out.println();
            System.out.println("대기번호는 입니다.");
            System.out.println("3초 후 메뉴판으로 돌아갑니다.");
        }
    };

    public void cancel(Scanner scanner) {
        System.out.println("진행하던 주문을 취소하시겠습니까?\n1. 확인\n2. 취소");
        int choice = scanner.nextInt();
        if (choice==1){
            cart.clear();
            System.out.println("진행하던 주문이 취소되었습니다.");
        }
    }


    // 0번 기능
    public void hidden(Scanner scanner) {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W "+totalSum+" ] 입니다.");
        System.out.println();
        showSoldProducts();
        int choice = scanner.nextInt(); // 숫자를 입력한 뒤에 메인메뉴로 돌아감
    }


    // 총 판매상품 목록 조회 기능 메서드
    public void showSoldProducts() {
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();
        for (Map.Entry<String[], Integer> entry : soldProducts.entrySet()) {
            String[] productKey = entry.getKey();
//            int count = entry.getValue();
            System.out.println(Arrays.toString(productKey));
        }
        System.out.println();
        System.out.println("1. 돌아가기");
    }
}