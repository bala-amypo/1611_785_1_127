package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import java.util.List;
import com.example.demo.repository.UserRepo;
@Service

public class UserServiceImpl implements UserService{
    @Autowired StudentRepo student;
    //save()
    //findAll()
    //findById()
    //deleteById();
    //existById();
    @Override
    public StudentEntity postData(StudentEntity stu){
        return student.save(stu);
    }
    @Override
    public List<StudentEntity>getAllData(){
        return student.findAll();
    }
    @Override
    public String DeleteData(int id){
        student.deleteById(id);
        return "Deleted Successfully";
    }
    @Override
    public StudentEntity getData(int id){
        return student.findById(id).orElse(null);
    }
    @Override
    public StudentEntity updateData(int id,StudentEntity entity){
        if(student.existsById(id)){
            entity.setId(id);
            return student.save(entity);
        }
        return null;
    }
}
