package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccessService implements UserDAO{
    private final JdbcTemplate jdbcTemplate;

    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, User user) {
        return 0;
    }

    @Override
    public List<User> getALlUsers() {
        List<User> users = jdbcTemplate.query("SELECT id, name FROM user_table", (result, index) -> {
            return new User(UUID.fromString(result.getString("id")), result.getString("name"));
        });
        return users;
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        User user = jdbcTemplate.queryForObject("SELECT id, name FROM user_table WHERE id = ?", new Object[]{id}, (result, index) -> {
            return new User(UUID.fromString(result.getString("id")), result.getString("name"));
        });
        return Optional.ofNullable(user);
    }

    @Override
    public int deleteUserById(UUID id) {
        return 0;
    }

    @Override
    public int updateUserByUd(UUID id, User user) {
        return 0;
    }
}
