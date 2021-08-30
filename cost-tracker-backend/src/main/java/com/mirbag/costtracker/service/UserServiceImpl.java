package com.mirbag.costtracker.service;

import com.mirbag.costtracker.entity.User;
import com.mirbag.costtracker.repository.UserRepository;
import com.mirbag.costtracker.utilities.ResponseModel;
import com.mirbag.costtracker.utilities.UtilityFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UtilityFunctions utils;

    @Override
    public ResponseModel<User> addUser(User user) {
        Optional<User> temp = userRepository.findByUserName(user.getUserName());
        if(temp.isPresent()) {
            return utils.generateResponse("fail", "User name already exists.", null);
        }
        try {
            user = userRepository.save(user);
            return utils.generateResponse("success", "User is added successfully.", user);
        }
        catch (Exception e) {
            e.printStackTrace();
            return utils.generateResponse("fail", "Failed to add User.", null);
        }
    }

    @Override
    public ResponseModel<User> updateUser(User user) {
        Optional<User> temp = userRepository.findByUserNameAndIdNot(user.getUserName(), user.getId());
        if(temp.isPresent()) {
            return utils.generateResponse("fail", "User name already exists.", null);
        }

        try{
            Optional<User> updateUser = userRepository.findById(user.getId());
            if(updateUser.isPresent()) {
                updateUser.get().setUserName(user.getUserName());
                updateUser.get().setPassWord(user.getPassWord());
                userRepository.save(updateUser.get());
                return utils.generateResponse("success", "User is updated successfully.", user);
            }
            else {
                return utils.generateResponse("fail", "User does not exist.", null);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return utils.generateResponse("fail", "Failed to update User.", null);
        }
    }

    @Override
    public ResponseModel<User> deleteUser(Long id) {
        Optional<User> deleteUser = userRepository.findById(id);
        try {
            if(deleteUser.isPresent()) {
                deleteUser.get().setIsActive(false);
                userRepository.save(deleteUser.get());
                return utils.generateResponse("Succes", "User " + deleteUser.get().getUserName() + " is removed.",
                        deleteUser);
            }
            else {
                return utils.generateResponse("fail", "Failed to remove User.", null);
            }
        }
        catch (Exception e) {
            return utils.generateResponse("fail", "Failed to remove User.", null);
        }
    }
}
