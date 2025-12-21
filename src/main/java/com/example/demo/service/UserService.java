package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.StudentEntity;
public interface StudentService{
    StudentEntity postData(StudentEntity stu);
        //StudentEntity getData(); 
    List<StudentEntity>getAllData();
    String DeleteData(int id);
    StudentEntity getData(int id);
    StudentEntity updateData(int id,StudentEntity entity);

}