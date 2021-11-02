package com.bouncer77.dao;

import com.bouncer77.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImplement implements UserDao {

    private List<User> users = Arrays.asList(new User("admin", "admin"),
            new User("test_user1", "test_user1"),
            new User("test_user2", "test_user2"),
            new User("test_user2", "test_user2"));


    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
