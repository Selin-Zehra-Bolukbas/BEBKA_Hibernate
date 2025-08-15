package com.selin.dao;

import com.selin.model.User;

public interface UserDao {
    public void create(User user);
    public User getUserById(Long id);
    public void updateUser(User user);
    public void deleteUser(Long id);
}
