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
    private ArrayList<String[]> cart = new ArrayList<>();

    public void addToCart(String[] selectedMenu) {
        cart.add(selectedMenu);
    }

    // 가격을 더하는 메서드
    float priceSum() {
        float priceSum = 0.0f;

        for (String[] selectedMenu : cart) {
            float price = Float.parseFloat(selectedMenu[1]);
            priceSum += price;
        }

        // 반올림하여 소수점 첫째 자리까지 표시
        priceSum = Math.round(priceSum * 10.0f) / 10.0f;

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
            for (String[] item : cart) {
                System.out.println(Arrays.toString(item));
            }
            System.out.println();
            System.out.println("[ Total ]");
            System.out.println("W " + priceSum());
            System.out.println("\n1. 주문\n2. 메뉴판");
            int choice = scanner.nextInt();
            if (choice == 1) {
                cart.clear();
                System.out.println("주문이 완료되었습니다!");
                System.out.println();
                System.out.println("대기번호는 입니다.");
                System.out.println("3초 후 메뉴판으로 돌아갑니다.");
            }
        }
    }
        public void cancel () {
            System.out.println("진행하던 주문을 취소하시겠습니까?\n1. 확인\n2. 취소");
            int choice = scanner.nextInt();
            if (choice == 1) {
                cart.clear();
                System.out.println("진행하던 주문이 취소되었습니다.");
            }
        }
    }
