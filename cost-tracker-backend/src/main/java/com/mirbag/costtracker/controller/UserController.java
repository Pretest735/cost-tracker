package com.mirbag.costtracker.controller;

import com.mirbag.costtracker.entity.User;
import com.mirbag.costtracker.repository.UserRepository;
import com.mirbag.costtracker.service.UserService;
import com.mirbag.costtracker.utilities.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @GetMapping(value="/list")
    private List<User> getUserList() {
        return userRepo.findByIsActiveTrue();
    }

    @PostMapping(value="/add")
    private ResponseModel<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping(value = "/update")
    private ResponseModel<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(value= "/delete/{id}")
    private ResponseModel<User> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
