package com.mashibing.stream;

import java.util.Date;

public class Person {
    private String name;
    public Person(){}

    public Person(String name) {
        this.name = name;
    }

    /**
     *
     * @param name
     * @return
     */
    public static Person build(String name){
        Person p = new Person(name);
        p.setName(name);
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
    @Deprecated
    public static void show(){
        System.out.println("show...");
    }

    public static void main(String[] args) {
        show();
        Date date = new Date();
        System.out.println(date.getMinutes());
        @SuppressWarnings("all")
        Person p = new Person();
        System.out.println("=========================");
        Integer a = -129;
        Integer b = -129;
        System.out.println(a == b);
    }
}
