package com.example.learn.spring.boot.swagger.servcie;

import com.example.learn.spring.boot.swagger.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
public class UserService {

    public List<User> findAllUsers() {
        List<User> allUser = new ArrayList();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("name" + i);
            user.setEmail("email" + i + "@aa.com");
            user.setCreateTime(Calendar.getInstance().getTime());
            user.setUpdateTime(Calendar.getInstance().getTime());

            allUser.add(user);
        }

        return allUser;
    }
}