package com.avd.dao;

import com.avd.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
    User getById(int id);
    void update(User user);
    void delete(int id);
}
