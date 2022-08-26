package com.epms.epms.model.dao;

import com.epms.epms.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
@Mapper
public interface UserDao extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
}
