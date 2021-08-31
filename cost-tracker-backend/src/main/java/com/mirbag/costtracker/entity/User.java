package com.mirbag.costtracker.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user_list")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="pass_word")
    private String passWord;
    
    @Column(name="is_admin")
    private Boolean isAdmin;

    @Column(name="is_active")
    private Boolean isActive;

}
