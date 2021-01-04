package com.mashibing.why2;

import com.mashibing.why.Student;

public class ScoreFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getScore()>85;
    }
}
