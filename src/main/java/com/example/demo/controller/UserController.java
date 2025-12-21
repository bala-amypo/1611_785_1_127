package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.UserService;
@RestController
public class StudentController{
    @Autowired StudentService ser;
    @PostMapping("/post")
    
    public StudentEntity sendData(@RequestBody StudentEntity  stu){
        return ser.postData(stu);
    }
    @GetMapping("/get")
    public List<StudentEntity> getData(){
        return ser.getAllData();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteVal(@PathVariable int id){
        return ser.DeleteData(id);
    }
    @GetMapping("/getid/{id}")
    public StudentEntity getDataId(@PathVariable int id){
        return ser.getData(id);
    }
    @PutMapping("/put/{id}")
    public StudentEntity putVal(@PathVariable int id,@RequestBody StudentEntity entity){
        return ser.updateData(id,entity);
    }
}