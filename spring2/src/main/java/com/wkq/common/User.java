package com.wkq.common;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
