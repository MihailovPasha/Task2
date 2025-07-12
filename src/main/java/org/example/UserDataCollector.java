package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserDataCollector {
    private final Scanner scanner;

    public UserDataCollector(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<User> collectUsers() {
        List<User> users = new ArrayList<>();
        System.out.println("Введите количество пользователей:");
        int count = getIntInput();

        for (int i = 0; i < count; i++) {
            users.add(collectSingleUser(i + 1));
        }
        return users;
    }

    private User collectSingleUser(int index) {
        System.out.println("Пользователь #" + index);
        System.out.print("Имя: ");
        String name = scanner.nextLine();

        System.out.print("Возраст: ");
        int age = getIntInput();

        return new User(name, age);
    }

    private int getIntInput() {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Ошибка! Введите число: ");
                scanner.nextLine();
            }
        }
    }
}
