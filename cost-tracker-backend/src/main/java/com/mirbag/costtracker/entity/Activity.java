package com.mirbag.costtracker.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="activity_list")
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

    @Column(name="description")
    private String description;

    @Column(name="included_user_ids")
    private String includedUserIds;

    @Column(name="amount")
    private Long amount;

    @Column(name="is_active")
    private Boolean isActive;
}
