package homework.kiosk;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Burgers extends Menu {

    static String[][] burgersArray = {
            {"ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"},
            {"Shroom Burger", "9.4", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"},
            {"Cheese Burger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"},
            {"Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"}
    };

    @Override
    public void displayMenu() {
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.println("[ Burgers MENU ]");
        for (int i = 0; i < burgersArray.length; i++) {
            String output = burgersArray[i][0] + " W " + burgersArray[i][1] + " " + burgersArray[i][2];
            System.out.println((i + 1) + ". " + output);
        }
    }

    public void selectMenu(Scanner scanner, Order order) {
        int choice = scanner.nextInt();
        int i = choice - 1; // 인덱스를 계산하여 저장
        if (i >= 0 && i < burgersArray.length) {
            String[] originalMenu = burgersArray[i].clone(); // 원본 메뉴 정보 보관
            String output = burgersArray[i][0] + " W " + burgersArray[i][1] + " " + burgersArray[i][2];
            System.out.println(output);

            // 옵션의 영향을 받아 기존의 데이터가 바뀜
            optionArray(scanner, burgersArray, i);
            output = burgersArray[i][0] + " W " + burgersArray[i][1] + " " + burgersArray[i][2];
            System.out.println(output);
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n1. 확인\n2. 취소");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                System.out.println((burgersArray[i][0]) + "가 장바구니에 추가되었습니다.");
                String[] selectedMenu = burgersArray[i];
                List<String> selectedMenuList = Arrays.asList(selectedMenu);
                order.addToCart(selectedMenuList);
            } // 1이 아닌 숫자를 누르면 메뉴판으로 돌아감

            // 원본 데이터로 되돌림
            burgersArray[i] = originalMenu;
        }
    }


    // 옵션 선택에 따른 배열 변형 메서드
    public static void optionArray(Scanner scanner, String[][] burgersArray, int i) {
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
    }

}

