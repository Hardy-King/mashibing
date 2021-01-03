package com.mashibing.dao;

import com.mashibing.bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserDaoAnno {
    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);
}
