package com.epms.epms.service;

import com.epms.epms.model.entity.User;

import java.util.List;

public interface UserService{
    List<User> findAll();
    User findByUserName(String name);
    User save(User user);
    void deleteById(Long id);
    User update(Long id,User user);
}
