package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.UUID;
import java.util.*;

public interface UserDAO {

    int insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> getALlUsers();

    Optional<User> getUserById(UUID id);
    int deleteUserById(UUID id);
    int updateUserByUd(UUID id, User user);
}
