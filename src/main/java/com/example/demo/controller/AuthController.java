package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users") 
public class AuthController {

    @Autowired
    private UserService ser;

    @PostMapping("/post")
    public User sendData(@RequestBody User stu) {
        return ser.postData(stu);
    }

    @GetMapping("/get")
    public List<User> getData() {
        return ser.getAllData();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVal(@PathVariable long id) {
        return ser.deleteData(id); // fixed method name
    }

    @GetMapping("/getid/{id}")
    public User getDataId(@PathVariable long id) {
        return ser.getData(id);
    }

    @PutMapping("/put/{id}")
    public User putVal(@PathVariable long id, @RequestBody User entity) {
        return ser.updateData(id, entity); // fixed variable usage
    }
}
