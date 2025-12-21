package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.User;
public interface UserService{

    
    User postData(User stu);
    List<User>getAllData();
    String DeleteData(int id);
    User getData(long id);
    User updateData(long id,User entity);

}
package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User registerCustomer(String name, String email, String rawPassword);

    User findByEmail(String email);
}
