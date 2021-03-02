package com.mirbag.costtracker.repository;

import com.mirbag.costtracker.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByIsActiveTrue();
}
