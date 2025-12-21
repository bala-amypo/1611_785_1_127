package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import java.util.List;
import com.example.demo.repository.UserRepo;
@Service

public class UserServiceImpl implements UserService{
    @Autowired UserRepo student;
    //save()
    //findAll()
    //findById()
    //deleteById();
    //existById();
    @Override
    public User postData(User stu){
        return student.save(stu);
    }
    @Override
    public List<User>getAllData(){
        return student.findAll();
    }
    @Override
    public String DeleteData(long id){
        student.deleteById(id);
        return "Deleted Successfully";
    }
    @Override
    public User getData(long id){
        return student.findById(id).orElse(null);
    }
    @Override
    public User updateData(long id,User entity){
        if(student.existsById(id)){
            entity.setId(id);
            return student.save(entity);
        }
        return null;
    }
}
