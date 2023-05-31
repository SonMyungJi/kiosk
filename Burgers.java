package homework.kiosk;

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
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Burgers MENU ]");
        for (int i = 0; i < burgersArray.length; i++) {
            String[] burgers = burgersArray[i];
            System.out.println((i + 1) + ". " + (burgers[0]) + " W " + burgers[1] + " " + burgers[2]);
        }
    }

    public void selectMenu(Scanner scanner, Order order) {
        int choice = scanner.nextInt();
        int index = choice -1; // 인덱스를 계산하여 저장
        if (index >= 0 && index < burgersArray.length){
            System.out.println(Arrays.toString(burgersArray[index]));
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n1. 확인\n2. 취소");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                System.out.println((burgersArray[index][0]) + "가 장바구니에 추가되었습니다.");
                String[] selectedMenu = burgersArray[index];
                order.addToCart(selectedMenu);
            }
        }
    }
}


