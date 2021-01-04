package com.mashibing.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        StudentDao sd1 = new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("插入学生1"+student);
            }
        };

        StudentDao sd2 = (student)->{
            System.out.println("插入学生2"+student);
        };

        StudentDao sd3 = (student)-> System.out.println("插入学生3"+student);
        StudentDao sd4 = (Student student)-> System.out.println("插入学生4"+student);

        sd1.insert(new Student());
        sd2.insert(new Student());
        sd3.insert(new Student());
        sd4.insert(new Student());

        System.out.println("=======================================================");

        TeacherDao td1 = new TeacherDao() {
            @Override
            public int get(Teacher teacher) {
                return 1;
            }
        };
        TeacherDao td2 = (t)->{return 2;};
        TeacherDao td3 = (Teacher t)->{return 3;};
        TeacherDao td4 = (t)->4;
        TeacherDao td5 = (Teacher t)->5;

        System.out.println(td1.get(new Teacher()));
        System.out.println(td2.get(new Teacher()));
        System.out.println(td3.get(new Teacher()));
        System.out.println(td4.get(new Teacher()));
        System.out.println(td5.get(new Teacher()));


        System.out.println("=============================================================");
        /**
         * java 中提供了一系列函数式接口，用来接收后续传入的逻辑，但是对输出输入有 要求
         */
        Function<String,Integer> f1 = (str)->{return str.length();};
        System.out.println(f1.apply("asad"));

        Supplier<String> s1 = ()->{return "mashibing";};
        Supplier<String> s2 = ()->"mashibing2";
        Supplier<Integer> n = ()->1;
        System.out.println(s1.get());
        System.out.println(s2.get());

        Consumer<String> c11 = (str) -> System.out.println(str);
        c11.accept("beijing");
        System.out.println("================================");
        Runnable runnable = ()->{
            int i = get();
            System.out.println(i);
        };
        runnable.run();
        System.out.println("================BiFunction===start=============");
        BiFunction<String,String,Integer> bf = (a,b)->a.length()+b.length();
        System.out.println(bf.apply("连老师", "真二"));
        System.out.println("================BiFunction===end=============");
        Runnable runnable1 = ()->get();
        Runnable runnable2 = ()->exec();
        /**
         * run()方法没有返回值，所以会报错
         */
        //Runnable runnable3 = ()->100;
        //Runnable runnable4 = ()->"12";、
        runnable1.run();
        System.out.println("========================================");

        LambdaInterface lambdaInterface = ()->get();
        //LambdaInterface lambdaInterface1 = ()->find();
        LambdaInterface lambdaInterface2 = ()->100;
        System.out.println(lambdaInterface.get());
        System.out.println(lambdaInterface2.get());

    }
    static int get(){
        return 1;
    }
    static String find(){
        return "strign";
    }
    static void exec(){
        find();
    }
}
