package com.Shrishti.EcommerceApplication.Controller;

import com.Shrishti.EcommerceApplication.Model.Orders;
import com.Shrishti.EcommerceApplication.Model.User;
import com.Shrishti.EcommerceApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    @Autowired
    UserService userService;

    //Create User
    @PostMapping(value = "/user")
    public String createUser(@RequestBody List<User> user){
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    //Get User By UserId
    @GetMapping(value = "/userId")
    public User getUserById(@RequestParam Integer userId){
        return userService.getUserById(userId);
    }
}
