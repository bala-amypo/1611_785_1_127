package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.User;
public interface UserService{
    User postData(User stu);
    List<User>getAllData();
    String DeleteData(int id);
    StudentEntity getData(int id);
    StudentEntity updateData(int id,StudentEntity entity);

}
package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User registerCustomer(String name, String email, String rawPassword);

    User findByEmail(String email);
}
