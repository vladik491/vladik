package com.mycompany.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Создать объект меню и добавить блюда");
            System.out.println("2. Вывести всё меню");
            System.out.println("3. Вывести все vegan friendly блюда");
            System.out.println("4. Подсчитать среднюю стоимость блюд с калорийностью более 300");
            System.out.println("5. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Добавление блюд в меню:");
                    for (int i = 0; i < 10; i++) {
                        System.out.print("Введите название блюда: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите стоимость: ");
                        double price = scanner.nextDouble();
                        System.out.print("Введите калорийность: ");
                        int calories = scanner.nextInt();
                        System.out.print("Это блюдо веганское? (yes/no): ");
                        boolean veganFriendly = scanner.next().equalsIgnoreCase("yes");
                        scanner.nextLine(); // Consume newline

                        System.out.print("Это напиток или тост? (drink/toast): ");
                        String type = scanner.nextLine();

                        if (type.equalsIgnoreCase("drink")) {
                            menu.addDish(new Drink(name, price, calories, veganFriendly));
                        } else if (type.equalsIgnoreCase("toast")) {
                            menu.addDish(new Toast(name, price, calories, veganFriendly));
                        } else {
                            System.out.println("Некорректный ввод типа блюда!");
                        }
                    }
                    break;
                case 2:
                    menu.printMenu();
                    break;
                case 3:
                    menu.printVeganDishes();
                    break;
                case 4:
                    menu.printAveragePriceForHighCalories();
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор! Попробуйте снова.");
            }
        }
    }
}
