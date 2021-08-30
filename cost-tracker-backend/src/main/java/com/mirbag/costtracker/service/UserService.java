package com.mirbag.costtracker.service;

import com.mirbag.costtracker.entity.User;
import com.mirbag.costtracker.utilities.ResponseModel;

public interface UserService {
    public ResponseModel<User> addUser(User user);
    public ResponseModel<User> updateUser(User user);
    public ResponseModel<User> deleteUser(Long id);
}
