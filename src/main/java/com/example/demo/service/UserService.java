package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.User;

public interface UserService {

    User registerCustomer(String name, String email, String password);
    User login(String email, String password);

    User postData(User user);
    List<User> getAllData();
    User getData(long id);
    User updateData(long id, User entity);
    String deleteData(long id);
}
