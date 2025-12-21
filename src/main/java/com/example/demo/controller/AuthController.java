package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth/register")
    public User register(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String email = request.get("email");
        String password = request.get("password");
        return userService.registerCustomer(name, email, password);
    }

    @PostMapping("/auth/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        User user = userService.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            return Map.of("error", "Invalid credentials");
        }

        String token = jwtUtil.generateToken(email);

        return Map.of("token", token);
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
