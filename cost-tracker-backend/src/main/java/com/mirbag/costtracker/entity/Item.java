package com.mirbag.costtracker.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="item_list")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long itemId;

    @Column(name="item_name")
    private Long itemName;

    @Column(name="is_active")
    private Long isActive;
}
