package com.mirbag.costtracker.controller;

import com.mirbag.costtracker.entity.Activity;
import com.mirbag.costtracker.repository.ActivityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActivityController {
    private ActivityRepository activityRepository;
    // fetch all cost activities
    @GetMapping("/cost-activities")
    public List<Activity> getAllActivities() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }
}
