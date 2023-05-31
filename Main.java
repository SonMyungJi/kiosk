package homework.kiosk;

import java.util.Scanner;

import static homework.kiosk.Beer.beerArray;
import static homework.kiosk.Burgers.burgersArray;
import static homework.kiosk.Drinks.drinksArray;
import static homework.kiosk.Frozen.frozenArray;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        String[][] selectedArray;
        Order order = new Order();


        while (true) {
            menu.displayMenu();
            System.out.println();
            order.displayOrder();

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    selectedArray = burgersArray;
                    Burgers burgers = new Burgers();
                    burgers.displayMenu();
                    if (selectedArray != null) {
                        burgers.selectMenu(scanner, order);
                    }
                    break;
                case 2:
                    selectedArray = frozenArray;
                    Frozen frozen = new Frozen();
                    frozen.displayMenu();
                    if (selectedArray != null) {
                        frozen.selectMenu(scanner, order);
                    }
                    break;
                case 3:
                    selectedArray = drinksArray;
                    Drinks drinks = new Drinks();
                    drinks.displayMenu();
                    if (selectedArray != null) {
                        drinks.selectMenu(scanner, order);
                    }
                    break;
                case 4:
                    selectedArray = beerArray;
                    Beer beer = new Beer();
                    beer.displayMenu();
                    if (selectedArray != null) {
                        beer.selectMenu(scanner, order);
                    }
                    break;
                case 5:
                    order.show();
                    break;
                case 6:
                    order.cancel();
                    break;
                case 0:
                    order.hidden();
                    break;
                default:
            }
        }
    }
}