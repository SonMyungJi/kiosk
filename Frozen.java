package homework.kiosk;

import java.util.Arrays;
import java.util.Scanner;

public class Frozen extends Menu {
    public Frozen() {
        super();
    }

    static String[][] frozenArray = {
            {"딸기 아이스크림", "5.0", "딸기가 좋아"},
            {"바닐라 아이스크림", "5.0", "바닐라가 좋아"},
    };

    @Override
    public void displayMenu() {
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Frozen Custard MENU ]");
        for (int i = 0; i < frozenArray.length; i++) {
            String[] frozen = frozenArray[i];
            System.out.println((i + 1) + ". " + (frozen[0]) + " W " + frozen[1] + " " + frozen[2]);
        }
    }

    public void selectMenu(Scanner scanner, Order order) {
        int choice = scanner.nextInt();
        int index = choice -1; // 인덱스를 계산하여 저장
        if (index >= 0 && index < frozenArray.length){
            System.out.println(Arrays.toString(frozenArray[index]));
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n1. 확인\n2. 취소");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                System.out.println((frozenArray[index][0]) + "가 장바구니에 추가되었습니다.");
                String[] selectedMenu = frozenArray[index];
                order.addToCart(selectedMenu);
            }
        }
    }
}
