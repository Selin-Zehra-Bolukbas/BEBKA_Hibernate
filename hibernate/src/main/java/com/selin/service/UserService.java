package com.selin.service;

import com.selin.dao.UserDao;
import com.selin.dao.impl.UserDaoImpl;
import com.selin.model.User;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(String name, String email) {
        User user = new User(name, email);
        userDao.create(user);
    }

    public User findUserById(Long id) {
        return userDao.getUserById(id);
    }

    public void updateUser(Long id, String newName, String newEmail) {
        User user = userDao.getUserById(id);
        if (user != null) {
            user.setName(newName);
            user.setEmail(newEmail);
            userDao.updateUser(user);
        } else {
            System.out.println("Kullanıcı bulunamadı:  " + id);
        }
    }

    public void removeUser(Long id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUser(id);
        } else {
            System.out.println("Silinecek kullanıcı bulunamadı: " + id);
        }
    }
}
