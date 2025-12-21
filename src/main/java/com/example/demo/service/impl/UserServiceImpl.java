package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.User.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /* =====================
       Test-required methods
       ===================== */

    @Override
    public User registerCustomer(String name, String email, String rawPassword) {

        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("email already exists");
        }

        User user = new User();
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(rawPassword); // store as plain text for now
        user.setRole(Role.CUSTOMER);

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            return userRepository.findByEmail(email).get();
        }
        return null;
    }

    /* =====================
       CRUD-style methods
       ===================== */

    @Override
    public User postData(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllData() {
        return userRepository.findAll();
    }

    @Override
    public String deleteData(long id) {
        userRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public User getData(long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public User updateData(long id, User entity) {
        if (userRepository.existsById(id)) {
            entity.setId(id);
            return userRepository.save(entity);
        }
        return null;
    }
}
