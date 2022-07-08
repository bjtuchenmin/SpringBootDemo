package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 一个使用了 JPA 连接数据库的示例
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addNewUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "email") String email) {
        User user = new User(name, email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
