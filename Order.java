package homework.kiosk;

import java.util.*;

class Order {
    private final String[][] orderArray = {
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

    private double totalSum; // 총 팔린 금액
    private final HashMap<List<String>, Integer> cart = new HashMap<>();
    private final Stack<List<String>> soldProducts = new Stack<>();

    public void addToCart(List<String> selectedMenu) {
        if (cart.containsKey(selectedMenu)) {
            int count = cart.get(selectedMenu);
            cart.put(selectedMenu, count + 1);
        } else {
            cart.put(selectedMenu, 1);
        }
    }

    private double priceSum() {
        double priceSum = 0.0;

        for (Map.Entry<List<String>, Integer> entry : cart.entrySet()) {
            List<String> selectedMenu = entry.getKey();
            int count = entry.getValue();

            double price = Double.parseDouble(selectedMenu.get(1));
            priceSum += price * count;
        }

        return priceSum;
    }

    public void show(Scanner scanner) {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        } else {
            for (Map.Entry<List<String>, Integer> entry : cart.entrySet()) {
                List<String> menu = entry.getKey();
                int count = entry.getValue();
                System.out.println(menu.get(0) + " W " + menu.get(1) + "  " + count + "개 " + menu.get(2));
            }
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + priceSum());
        System.out.println("\n1. 주문\n2. 메뉴판");
        int choice = scanner.nextInt();
        if (choice == 1) {
            totalSum += priceSum();

            // Add the sold products to the stack
            for (Map.Entry<List<String>, Integer> entry : cart.entrySet()) {
                List<String> product = entry.getKey();
                int count = entry.getValue();
                for (int i = 0; i < count; i++) {
                    soldProducts.push(product);
                }
            }

            cart.clear();
            System.out.println("주문이 완료되었습니다!");
            System.out.println();
            System.out.println("대기번호는 입니다.");
            System.out.println("3초 후 메뉴판으로 돌아갑니다.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void cancel(Scanner scanner) {
        System.out.println("진행하던 주문을 취소하시겠습니까?\n1. 확인\n2. 취소");
        int choice = scanner.nextInt();
        if (choice == 1) {
            cart.clear();
            System.out.println("진행하던 주문이 취소되었습니다.");
        }
    }

    public void hidden(Scanner scanner) {
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();

        Stack<List<String>> reversedStack = new Stack<>();
        while (!soldProducts.isEmpty()) {
            reversedStack.push(soldProducts.pop());
        }

        while (!reversedStack.isEmpty()) {
            List<String> product = reversedStack.pop();
            System.out.printf("%s W %s %s\n", product.get(0), product.get(1), product.get(2));
            soldProducts.push(product);
        }

        double roundedTotalSum = Math.round(totalSum * 10) / 10.0;

        System.out.println();
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W " + roundedTotalSum + " ] 입니다.");
        System.out.println();
        System.out.println("1. 돌아가기");
        int number = scanner.nextInt();
    }
}
