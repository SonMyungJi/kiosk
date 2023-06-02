//package homework.kiosk;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class Beer extends Menu {
//    static String[][] beerArray = {
//            {"India IPA", "8.9", "인도에서 온 홉의 향기와 과일향이 조화로운 IPA"},
//    };
//
//    @Override
//    public void displayMenu() {
//        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
//        System.out.println();
//        System.out.println("[ Beer MENU ]");
//        for (int i = 0; i < beerArray.length; i++) {
//            String output = beerArray[i][0] + " W " + beerArray[i][1] + " " + beerArray[i][2];
//            System.out.println((i + 1) + ". " + output);
//        }
//    }
//
//
//    public void selectMenu(Scanner scanner, Order order) {
//        int choice = scanner.nextInt();
//        int i = choice -1;
//        if (i >= 0 && i < beerArray.length){
//            String output = beerArray[i][0] + " W " + beerArray[i][1] + " " + beerArray[i][2];
//            System.out.println(output);
//            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n1. 확인\n2. 취소");
//            int userChoice = scanner.nextInt();
//            if (userChoice == 1) {
//                System.out.println((beerArray[i][0]) + "가 장바구니에 추가되었습니다.");
//                String[] selectedMenu = beerArray[i];
//                List<String> selectedMenuList = Arrays.asList(selectedMenu);
//                order.addToCart(selectedMenuList);
//            }
//        }
//    }
//}
