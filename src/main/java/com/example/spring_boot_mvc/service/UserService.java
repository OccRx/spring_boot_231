package com.example.spring_boot_mvc.service;


import com.example.spring_boot_mvc.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User getUserById(long id);

    void add(User user);

    void update(User newUser);

    void delete(long id);
}
