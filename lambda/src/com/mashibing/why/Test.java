package com.mashibing.why;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("zhangsan",19,78));
        students.add(new Student("lisi",19,98));
        students.add(new Student("wangwu",28,90));
        students.add(new Student("zhaoliu",25,87));
        students.add(new Student("tianqi",20,82));
        students.add(new Student("wuba",35,99));
        //获取大于年龄25的student
        getStudentByAge(students);
        System.out.println("=============================================");
        //获取大于分数85的
        getStudentByScore(students);
    }
    public static void getStudentByAge(List<Student> students){
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge()>25){
                list.add(student);
            }
        }
        for (Student student : list) {
            System.out.println(student);
        }

    }
    public static void getStudentByScore(List<Student> students){
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore()>85){
                list.add(student);
            }
        }
        for (Student student : list) {
            System.out.println(student);
        }

    }
}
