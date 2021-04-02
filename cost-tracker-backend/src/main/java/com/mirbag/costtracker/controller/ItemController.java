package com.mirbag.costtracker.controller;

import com.mirbag.costtracker.entity.Item;
import com.mirbag.costtracker.repository.ItemRepository;
import com.mirbag.costtracker.service.ItemService;
import com.mirbag.costtracker.utilities.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/item")
public class ItemController {
    @Autowired
    private ItemRepository itemRepo;
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/list")
    private List<Item> getItemList() {
        return itemRepo.findByIsActiveTrue();
    }

    @PostMapping(value = "/add")
    private ResponseModel<Item> addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PostMapping(value = "/update")
    private ResponseModel<Item> updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }
}
