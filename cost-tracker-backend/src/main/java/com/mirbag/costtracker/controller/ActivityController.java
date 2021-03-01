package com.mirbag.costtracker.controller;

import com.mirbag.costtracker.entity.Activity;
import com.mirbag.costtracker.entity.User;
import com.mirbag.costtracker.repository.ActivityRepository;
import com.mirbag.costtracker.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cost-activity")
public class ActivityController {
    private ActivityRepository activityRepository;
    private UserRepository userRepository;
    // fetch all cost activities
    @GetMapping(value = "/cost-activities")
    private List<Activity> getAllActivities() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }

    @PostMapping(value = "/add-activity")
    private Activity addActivity(@RequestBody Activity activity) {
        List<User> users = userRepository.findByIsActiveTrue();
    }
}
