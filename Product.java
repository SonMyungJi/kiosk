package homework.kiosk;


import java.util.*;

public class Product extends Menu {

    static String[][] burgersArray = {
            {"ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"},
            {"Shroom Burger", "9.4", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"},
            {"Cheese Burger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"},
            {"Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"}
    };

    static String[][] frozenArray = {
            {"딸기 아이스크림", "5.0", "딸기가 좋아"},
            {"바닐라 아이스크림", "5.0", "바닐라가 좋아"},
    };

    static String[][] drinksArray = {
            {"Milk", "3.0", "우유"},
            {"Water", "1.0", "물"},
            {"Coke", "6.0", "콜라"},
    };

    static String[][] beerArray = {
            {"India IPA", "8.9", "인도에서 온 홉의 향기와 과일향이 조화로운 IPA"},
    };

    final private Map<String, String[][]> menuMap;

    public Product() {
        super();
        menuMap = new HashMap<>();
        menuMap.put("burgers", burgersArray);
        menuMap.put("frozen", frozenArray);
        menuMap.put("drinks", drinksArray);
        menuMap.put("beer", beerArray);
    }

    // 오버로딩된 displayMenu() 메서드 정의
    public void displayMenu(String[][] menuArray) {
        System.out.println("아래 메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        for (int i = 0; i < menuArray.length; i++) {
            String output = menuArray[i][0] + " W " + menuArray[i][1] + " " + menuArray[i][2];
            System.out.println((i + 1) + ". " + output);
        }
    }

    // 각 카테고리에 대한 displayMenu() 메서드 오버로딩
    public void displayMenu() {
        super.displayMenu(); // Menu 클래스의 displayMenu() 호출
    }

    public void displayMenu(String category) {
        String[][] menuArray = menuMap.get(category.toLowerCase());
        if (menuArray != null) {
            displayMenu(menuArray);
        }
    }

    // selectMenu() 메서드 정의
    public void selectMenu(String category, Scanner scanner, Order order) {
        String[][] menuArray = menuMap.get(category);
        if (menuArray != null) {
            int choice = scanner.nextInt();
            int i = choice - 1; // 인덱스를 계산하여 저장
            if (i >= 0 && i < menuArray.length) {
                String[] originalMenu = menuArray[i].clone(); // 원본 메뉴 정보 보관
                String output = menuArray[i][0] + " W " + menuArray[i][1] + " " + menuArray[i][2];
                System.out.println(output);

                if (category.equals("burgers")) {
                    optionArray(scanner, menuArray, i);
                }

                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n1. 확인\n2. 취소");
                int userChoice = scanner.nextInt();
                if (userChoice == 1) {
                    System.out.println((menuArray[i][0]) + "가 장바구니에 추가되었습니다.");
                    String[] selectedMenu = menuArray[i];
                    List<String> selectedMenuList = Arrays.asList(selectedMenu);
                    order.addToCart(selectedMenuList);
                } // 1이 아닌 숫자를 누르면 메뉴판으로 돌아감

                // 원본 데이터로 되돌림
                menuArray[i] = originalMenu;
            }
        }
    }

    // 옵션 선택에 따른 배열 변형 메서드
    public static void optionArray(Scanner scanner, String[][] menuArray, int i) {
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까? \n1. Single\n2. Double");
        boolean isValidChoice = false;
        double price = Double.parseDouble(burgersArray[i][1]); // String 가격을 숫자로 변환

        while (!isValidChoice) {
            int choice = scanner.nextInt();

            if (choice == 1) {
                if (!burgersArray[i][0].endsWith("(Single)")) { // 중복된 옵션 추가 방지
                    burgersArray[i][0] += "(Single)";
                }
                price += 0;
                isValidChoice = true;
            } else if (choice == 2) {
                if (!burgersArray[i][0].endsWith("(Double)")) { // 중복된 옵션 추가 방지
                    burgersArray[i][0] += "(Double)";
                }
                price += 3.6;
                isValidChoice = true;
            } else { // while문 처음으로 돌아감. 아무 일도 발생하지 않음.
            }
        }

        burgersArray[i][1] = String.valueOf(price); // 다시 String 가격으로 변환
        String output = menuArray[i][0] + " W " + menuArray[i][1] + " " + menuArray[i][2];
        System.out.println(output);
    }

}
