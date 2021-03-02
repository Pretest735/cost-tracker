package com.mirbag.costtracker.controller;

import com.mirbag.costtracker.entity.User;
import com.mirbag.costtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping(value="/list")
    private List<User> getUserList() {
        return userRepo.findByIsActiveTrue();
    }
}
