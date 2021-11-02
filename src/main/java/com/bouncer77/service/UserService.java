package com.bouncer77.service;

import com.bouncer77.dao.UserDao;
import com.bouncer77.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {

        List<User> users = userDao.getAllUsers();
        System.out.println(users);
        // проверка прав пользователя

        return users;
    }
}
