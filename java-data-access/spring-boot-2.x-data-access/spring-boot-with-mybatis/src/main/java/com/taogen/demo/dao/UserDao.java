package com.taogen.demo.dao;

import com.taogen.demo.entity.User;
import com.taogen.demo.vo.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Taogen
 */
@Mapper
public interface UserDao {
    List<User> listUsers(@Param("page") Page page, @Param("user") User user);

    User getUser(Integer id);

    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);
}
