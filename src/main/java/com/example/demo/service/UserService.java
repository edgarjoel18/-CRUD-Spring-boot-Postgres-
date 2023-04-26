package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    // this class will use dependency injection
    private final UserDAO userDAO;
    // injection here
    @Autowired
    public UserService(@Qualifier("postgres") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int addUser(User user){
        return userDAO.insertUser(user);
    }

    public List<User> getAllUsers(){
        return userDAO.getALlUsers();
    }

    public Optional<User> getUserById(UUID id){
        return userDAO.getUserById(id);
    }

    public int deleteUserById(UUID id){
        return userDAO.deleteUserById(id);
    }

    public int updateUserById(UUID id, User user){
        return userDAO.updateUserByUd(id, user);
    }

}

