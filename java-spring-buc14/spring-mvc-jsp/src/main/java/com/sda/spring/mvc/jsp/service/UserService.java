package com.sda.spring.mvc.jsp.service;

import com.sda.spring.mvc.jsp.dao.UserDao;
import com.sda.spring.mvc.jsp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public List<User> getUserList() {
        //add some transformations
        //transform from dto to entity
        return userDao.getUsers();
    }

    public void save(User user) {
        userDao.save(user);
    }
}
