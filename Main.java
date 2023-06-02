package homework.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();
        Product product = new Product();

        while (true) {
            menu.displayMenu();
            System.out.println();
            order.displayOrder();

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    product.displayMenu("burgers");
                    product.selectMenu("burgers", scanner, order);

                    break;
                case 2:
                    product.displayMenu("frozen");
                    product.selectMenu("frozen", scanner, order);
                    break;
                case 3:
                    product.displayMenu("drinks");
                    product.selectMenu("drinks", scanner, order);
                    break;
                case 4:
                    product.displayMenu("beer");
                    product.selectMenu("beer", scanner, order);
                    break;
                case 5:
                    order.show(scanner);
                    break;
                case 6:
                    order.cancel(scanner);
                    break;
                case 0:
                    order.hidden(scanner);
                    break;
                default: break;
            }
        }
    }
}