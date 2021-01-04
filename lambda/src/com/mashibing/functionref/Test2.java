package com.mashibing.functionref;

import com.sun.glass.ui.Size;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test2 {
    static String put(){
        System.out.println("put......");
        return "put";
    }
    static int put1(){
        return 1;
    }

    public static void getSize(int size){
        System.out.println(size);
    }

    public static String toUpperCase(String string){
        return string.toUpperCase();
    }


    public static void main(String[] args) {
        Supplier<String> s1 = ()->Test2.put();
        System.out.println(s1.get());

        Supplier<String> s2 = Test2::put;
        System.out.println(s2.get());

        Supplier<String> s3 = Fun::hehe;
        System.out.println(s3.get());

        Consumer<Integer> c1 = Test2::getSize;
        c1.accept(1234);
        Consumer<Integer> c2 = (size)->Test2.getSize(size);
        c2.accept(232);

        Function<String,String> f1 = (str)->str.toUpperCase();
        Function<String,String> f2 = (str)->Test2.toUpperCase(str);
        Function<String,String> f3 = Test2::toUpperCase;
        Function<String,String> f4 = Fun::toUpperCase;

        System.out.println(f1.apply("dewW"));
        System.out.println(f2.apply("frew"));
        System.out.println(f3.apply("frecd"));
        System.out.println(f4.apply("dsdweef"));

        BiFunction<String,String,Integer> bf = (a,b)->a.length()+b.length();
        BiFunction<String,String,Integer> bf2 = Test2::getLength;
        System.out.println(bf.apply("dsdwe", "dsde"));
        System.out.println(bf2.apply("dsdwe", "dsde"));
    }

    static Integer getLength(String s1,String s2){
        return s1.length()+s2.length();
    }
}
class Fun{
    public static String hehe(){
        return "hehe";
    }
    public static String toUpperCase(String string){
        return string.toUpperCase();
    }
}
