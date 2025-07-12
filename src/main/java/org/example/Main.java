package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "users";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDataCollector collector = new UserDataCollector(scanner);
        List<User> users = collector.collectUsers();

        try {
            UserSerializer.serialize(users, FILENAME);
            System.out.println("Данные сохранены в: " + FILENAME);

            List<User> loadedUsers = UserDeserializer.deserialize(FILENAME);
            System.out.println("Загруженные данные:");
            loadedUsers.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}