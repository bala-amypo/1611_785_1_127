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
    private UserService userService;
    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String email = request.get("email");
        String password = request.get("password");
        return userService.registerCustomer(name, email, password);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        User user = userService.login(email, password);
        if (user == null) {
            return Map.of("error", "Invalid credentials");
        }
        return Map.of(
            "id", user.getId().toString(),
            "name", user.getFullName(),
            "email", user.getEmail(),
            "role", user.getRole().toString()
        );
    }
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
