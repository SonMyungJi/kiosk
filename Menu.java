package homework.kiosk;

public class Menu {

    String name;
    double price;
    String desc;

    public Menu() {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    static String[][] menuArray = {
            {"Burgers", "앵거스 비프 통살을 다져 만든 버거"},
            {"Frozen Custard", "매장에서 신선하게 만드는 아이스크림"},
            {"Drinks", "매장에서 직접 만든 음료"},
            {"Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"}
    };

    public void displayMenu() {
        System.out.println();
        System.out.println("SHAKESHACK BURGER에 오신 걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuArray.length; i++) {
            String[] menu = menuArray[i];
            System.out.println((i + 1) + ". " + (menu[0]) + ": " + menu[1]);
        }
    }
}
