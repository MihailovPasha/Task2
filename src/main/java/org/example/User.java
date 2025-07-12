package org.example;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Пользователь (" + "Имя : " + name +
                ", Возраст : " + age + ")";
    }
}
