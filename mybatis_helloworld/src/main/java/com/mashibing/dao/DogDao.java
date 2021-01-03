package com.mashibing.dao;

import com.mashibing.bean.Dog;

import java.util.List;

public interface DogDao {
    List<Dog> selectAll();
}
