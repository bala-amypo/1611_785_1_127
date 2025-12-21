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
    private UserRepository repo;

    @Override
    public User registerCustomer(String name, String email, String password) {

        if (repo.findByEmail(email).isPresent()) {
            return null;
        }

        User user = new User();
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.CUSTOMER);

        return repo.save(user);
    }

    @Override
    public User login(String email, String password) {

        User user = repo.findByEmail(email).orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User postData(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getAllData() {
        return repo.findAll();
    }

    @Override
    public User getData(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public User updateData(long id, User entity) {
        if (repo.existsById(id)) {
            entity.setId(id);
            return repo.save(entity);
        }
        return null;
    }

    @Override
    public String deleteData(long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted Successfully";
        }
        return "User Not Found";
    }
}
