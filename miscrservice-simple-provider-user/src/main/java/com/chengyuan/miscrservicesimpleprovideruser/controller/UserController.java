package com.chengyuan.miscrservicesimpleprovideruser.controller;
import com.chengyuan.miscrservicesimpleprovideruser.dao.UserRepository;
import com.chengyuan.miscrservicesimpleprovideruser.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        User findOne=this.userRepository.findOne(id);
        return findOne;

    }
}
