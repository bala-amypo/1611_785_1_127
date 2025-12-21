package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    // ✅ Constructor Injection
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Object register(@RequestBody Map<String, String> request) {

        String name = request.get("name");
        String email = request.get("email");
        String password = request.get("password");

        if (name == null || email == null || password == null) {
            return Map.of("message", "All fields are required");
        }

        User user = userService.registerCustomer(name, email, password);

        if (user == null) {
            return Map.of("message", "Email already exists");
        }

        return user;
    }

    @PostMapping("/login")
    public Object login(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");

        User user = userService.login(email, password);

        if (user == null) {
            return Map.of("message", "Invalid credentials");
        }

        return user;
    }

    /* ---------- CRUD ---------- */

    @PostMapping("/users/post")
    public User postUser(@RequestBody User user) {
        return userService.postData(user);
    }

    @GetMapping("/users/get")
    public List<User> getAllUsers() {
        return userService.getAllData();
    }

    @GetMapping("/users/getid/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getData(id);
    }

    @PutMapping("/users/put/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User entity) {
        return userService.updateData(id, entity);
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteData(id);
    }
}
