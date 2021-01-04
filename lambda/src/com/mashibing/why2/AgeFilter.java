package com.mashibing.why2;

import com.mashibing.why.Student;

public class AgeFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getAge()>25;
    }
}
