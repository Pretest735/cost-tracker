package com.mirbag.costtracker.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="cost_activity_list")
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="activity_id")
    private Long activityId;

    @Column(name="activity_date")
    private String activityDate;

    @Column(name="user_id")
    private Long userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="excludes")
    private String excludes;

    @Column(name="description")
    private String description;

    @Column(name="is_active")
    private boolean isActive;
}
