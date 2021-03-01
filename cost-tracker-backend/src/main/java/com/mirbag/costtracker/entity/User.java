package com.mirbag.costtracker.entity;

import lombok.Data;
import lombok.Generated;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user_list")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="charged")
    private Long charged;

    @Column(name="paid")
    private Long paid;

    @Column(name="is_active")
    private boolean isActive;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id")
//    private Set<Activity> activities;
}
