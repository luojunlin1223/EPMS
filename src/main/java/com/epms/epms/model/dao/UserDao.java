package com.epms.epms.model.dao;

import com.epms.epms.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Long> {
    User findByUserName(String userName);
}
