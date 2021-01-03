package com.mashibing.dao;

import com.mashibing.bean.User;

import java.util.List;

public interface UserDao {
    User findUserById(Integer id);
    Integer save(User user);
    List<User> selectAll();
}
