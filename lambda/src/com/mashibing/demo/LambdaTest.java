package com.mashibing.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class LambdaTest {
    public static void main(String[] args) throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running1 ...");
            }
        };
        runnable.run();

        Runnable runnable1 = ()->{
            System.out.println("running2...");
        };
        runnable1.run();

        Runnable runnable2 = ()-> System.out.println("running3...");
        runnable2.run();
        System.out.println("===========================================");

        Callable<String> c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "mashibing1";
            }
        };
        System.out.println(c1.call());
        Callable<String> c2 = ()->{return "mashibing2";};
        System.out.println(c2.call());

        Callable<String> c3 = ()->"mashibing3";
        System.out.println(c3.call());

        System.out.println("=================================================");
        List<String> list = Arrays.asList("a","sd","dsd","lisi");
        list.forEach(System.out::println);


    }
}
