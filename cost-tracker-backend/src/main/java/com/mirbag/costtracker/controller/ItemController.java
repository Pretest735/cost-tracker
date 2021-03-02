package com.mirbag.costtracker.controller;

import com.mirbag.costtracker.entity.Item;
import com.mirbag.costtracker.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/item")
public class ItemController {
    @Autowired
    private ItemRepository itemRepo;
    @GetMapping(value = "/list")
    private List<Item> getItemList() {
        return itemRepo.findByIsActiveTrue();
    }
}
