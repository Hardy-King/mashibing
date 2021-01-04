package com.mashibing.demo;

import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" running...");
            }
        });
        thread.start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" running2....");
        }).start();

        List<String> list = Arrays.asList("java","javaScript","scala","Objective-c","python");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println(list);

        Collections.sort(list,(a,b)->a.length()-b.length());
        list.forEach(System.out::println);
    }
}
