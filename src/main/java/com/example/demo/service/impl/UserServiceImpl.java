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
       Auth methods
       ===================== */
    @Override
    public User registerCustomer(String name, String email, String rawPassword) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("email already exists");
        }

        User user = new User();
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(rawPassword); // plain text
        user.setRole(Role.CUSTOMER);

        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    /* =====================
       CRUD methods
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
        return userRepository.findById(id).orElse(null);
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
