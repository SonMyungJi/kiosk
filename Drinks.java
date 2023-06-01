package homework.kiosk;

import java.util.Arrays;
import java.util.Scanner;

public class Drinks extends Menu {
    static String[][] drinksArray = {
            {"Milk", "3.0", "우유"},
            {"Water", "1.0", "물"},
            {"Coke", "6.0", "콜라"},
    };

    @Override
    public void displayMenu() {
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Drinks MENU ]");
        for (int i = 0; i < drinksArray.length; i++) {
            String[] drinks = drinksArray[i];
            System.out.println((i + 1) + ". " + (drinks[0]) + " W " + drinks[1] + " " + drinks[2]);
        }
    }

    public void selectMenu(Scanner scanner, Order order) {
        int choice = scanner.nextInt();
        int i = choice -1; // 인덱스를 계산하여 저장
        if (i >= 0 && i < drinksArray.length){
            System.out.println(Arrays.toString(drinksArray[i]));
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n1. 확인\n2. 취소");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                System.out.println((drinksArray[i][0]) + "가 장바구니에 추가되었습니다.");
                String[] selectedMenu = drinksArray[i];
                order.addToCart(selectedMenu);
            }
        }
    }
}
