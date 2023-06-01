package homework.kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Burgers extends Menu {

    public Burgers() {
        super();
    }

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
            String[] burgers = burgersArray[i];
            System.out.println((i + 1) + ". " + burgers[0] + " W " + burgers[1] + " " + burgers[2]);
        }
    }


    public void selectMenu(Scanner scanner, Order order) {
        int choice = scanner.nextInt();
        int i = choice - 1; // Calculate and store the index
        if (i >= 0 && i < burgersArray.length) {
            System.out.println(burgersArray[i][0] + " W " + burgersArray[i][1] + " " + burgersArray[i][2]);
            System.out.println("위 메뉴에 옵션을 추가하시겠습니까?\n1. 확인\n2. 취소");
            int optionChoice = scanner.nextInt();
            if (optionChoice == 1) {
                ArrayList<String> optionList = getOption(scanner, i);
                System.out.println(optionList.get(0) + " W " + optionList.get(1) + " " + optionList.get(2));
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인\n2. 취소");
                int userChoice1 = scanner.nextInt();
                if (userChoice1 == 1) {
                    System.out.println(optionList.get(0) + "가 장바구니에 추가되었습니다.");
                    String[] selectedMenu = optionList.toArray(new String[0]);
                    order.addToCart(selectedMenu);
                } else {
                    // Handle invalid user choice
                }
            } else if (optionChoice == 2) {
                System.out.println(burgersArray[i][0] + " W " + burgersArray[i][1] + " " + burgersArray[i][2]);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인\n2. 취소");
                int userChoice2 = scanner.nextInt();
                if (userChoice2 == 1) {
                    System.out.println(burgersArray[i][0] + "가 장바구니에 추가되었습니다.");
                    String[] selectedMenu = burgersArray[i];
                    order.addToCart(selectedMenu);
                } else {
                    // Handle invalid user choice
                }
            } else {
                // Handle invalid option choice
            }
        } else {
            // Handle invalid burger choice
        }
    }

    public ArrayList<String> getOption(Scanner scanner, int j) {
        ArrayList<String> optionList = new ArrayList<>();
        System.out.println("1. Single\n2. Double");
        int optionChoice = scanner.nextInt();
        if (optionChoice == 1) {
            String burgerName = burgersArray[j][0] + "(Single)";
            String burgerPrice = burgersArray[j][1];
            String burgerDesc = burgersArray[j][2];
            optionList.add(burgerName);
            optionList.add(burgerPrice);
            optionList.add(burgerDesc);
        } else if (optionChoice == 2) {
            String burgerName = burgersArray[j][0] + "(Double)";
            double burgerPrice = Double.parseDouble(burgersArray[j][1]) + 3.6;
            String burgerDesc = burgersArray[j][2];
            optionList.add(burgerName);
            optionList.add(String.valueOf(burgerPrice));
            optionList.add(burgerDesc);
        } else {
            // Handle invalid option choice
        }
        return optionList;
    }

}
