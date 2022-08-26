package com.epms.epms.service;

import com.epms.epms.model.dao.UserDao;
import com.epms.epms.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSeriviceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUserName(String name) {
        return userDao.findUserByUsername(name);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User update(Long id, User user) {
        return userDao.save(user);
    }
}
