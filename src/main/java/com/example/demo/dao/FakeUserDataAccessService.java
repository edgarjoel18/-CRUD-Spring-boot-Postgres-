package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.*;
// make as a bean so it can be injected to other classes
@Repository("fakeDAO")
public class FakeUserDataAccessService implements UserDAO{
    private static List<User> db = new ArrayList<>();
    @Override
    public int insertUser(UUID id, User user) {
        db.add(new User(id, user.getName()));
        return 1;
    }

    @Override
    public List<User> getALlUsers() {
        return db;
    }

    @Override
    public Optional<User> getUserById(UUID id) {
       return db.stream().filter((user) -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> current_user = getUserById(id);
        if(current_user.isEmpty()){
            return 0;
        }
        db.remove(current_user.get());
        return 1;
    }

    @Override
    public int updateUserByUd(UUID id, User user) {
        return getUserById(id)
                .map((current_user) -> {
                    int indexOfUser = db.indexOf(current_user);
                    if(indexOfUser < 0){
                        return 0;
                    }
                    db.set(indexOfUser, new User(id, user.getName()));
                    return 1;
                })
                .orElse(null);
    }


}
