package com.mashibing.why3;

import com.mashibing.why.Student;
import com.mashibing.why2.AgeFilter;
import com.mashibing.why2.ScoreFilter;
import com.mashibing.why2.StudentFilter;

import java.util.ArrayList;
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
        //age>25
        getByFilter(students, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getAge()>25;
            }
        });
        System.out.println("==========================================");
        getByFilter(students, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getScore()>85;
            }
        });
        System.out.println("==========================================");
        getByFilter(students, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getName().length()>6;
            }
        });
    }

    public static void getByFilter(List<Student> students,StudentFilter filter){
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (filter.compare(student)){
                list.add(student);
            }
        }
        printStudent(list);
    }
    public static void printStudent(ArrayList<Student> students){
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
