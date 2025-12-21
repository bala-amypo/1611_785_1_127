package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
public Object register(@RequestBody Map<String, String> req) {

    String name = req.get("name");
    String email = req.get("email");
    String password = req.get("password");

    if (name == null || email == null || password == null) {
        return Map.of("message", "All fields are required");
    }

    User user = service.registerCustomer(name, email, password);

    if (user == null) {
        return Map.of("message", "Email already exists");
    }

    return user;
}


    @PostMapping("/login")
    public Object login(@RequestBody Map<String, String> req) {

        User user = service.login(
                req.get("email"),
                req.get("password")
        );

        if (user == null) {
            return Map.of("message", "Invalid credentials");
        }

        return Map.of(
                "id", user.getId(),
                "name", user.getFullName(),
                "email", user.getEmail(),
                "role", user.getRole()
        );
    }

    /* CRUD */

    @PostMapping("/users/post")
    public User post(@RequestBody User user) {
        return service.postData(user);
    }

    @GetMapping("/users/get")
    public List<User> getAll() {
        return service.getAllData();
    }

    @GetMapping("/users/getid/{id}")
    public User getById(@PathVariable long id) {
        return service.getData(id);
    }

    @PutMapping("/users/put/{id}")
    public User update(@PathVariable long id, @RequestBody User user) {
        return service.updateData(id, user);
    }

    @DeleteMapping("/users/delete/{id}")
    public String delete(@PathVariable long id) {
        return service.deleteData(id);
    }
}
