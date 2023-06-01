package homework.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();

        while (true) {
            menu.displayMenu();
            System.out.println();
            order.displayOrder();

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    Burgers burgers = new Burgers();
                    burgers.displayMenu();
                    burgers.selectMenu(scanner, order);
                    break;
                case 2:
                    Frozen frozen = new Frozen();
                    frozen.displayMenu();
                    frozen.selectMenu(scanner, order);
                    break;
                case 3:
                    Drinks drinks = new Drinks();
                    drinks.displayMenu();
                    drinks.selectMenu(scanner, order);
                    break;
                case 4:
                    Beer beer = new Beer();
                    beer.displayMenu();
                    beer.selectMenu(scanner, order);
                    break;
                case 5:
                    order.show();
                    order.sell(scanner);
                    break;
                case 6:
                    order.cancel(scanner);
                    break;
                case 0:
                    order.hidden(scanner);
                    break;
                default:
            }
        }
    }
}