package com.mirbag.costtracker.service;

import com.mirbag.costtracker.entity.Item;
import com.mirbag.costtracker.entity.User;
import com.mirbag.costtracker.repository.ItemRepository;
import com.mirbag.costtracker.utilities.ResponseModel;
import com.mirbag.costtracker.utilities.UtilityFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UtilityFunctions utils;

    @Override
    public ResponseModel<Item> addItem(Item item) {
        Optional<Item> temp = itemRepository.findByItemName(item.getItemName());
        if(temp.isPresent()) {
            return utils.generateResponse("fail", "Item name already exists", null);
        }
        try {
            item = itemRepository.save(item);
            return utils.generateResponse("success", "Item is added successfully.", item);
        }
        catch (Exception e) {
            e.printStackTrace();
            return utils.generateResponse("fail", "Failed to add item", null);
        }
    }

    @Override
    public ResponseModel<Item> updateItem(Item item) {
        // check whether the updated name already exists
        Optional<Item> temp = itemRepository.findByItemNameAndItemIdNot(item.getItemName(), item.getItemId());
        if(temp.isPresent()) {
            return utils.generateResponse("fail","Updated item name already exists.", null);
        }
        try {
            Optional<Item> updateItem = itemRepository.findById(item.getItemId());
            if(updateItem.isPresent()) updateItem.get().setItemName(item.getItemName());
            itemRepository.save(updateItem.get());
            return utils.generateResponse("success", "Item is updated successfully.", updateItem);
        }
        catch (Exception e) {
            e.printStackTrace();
            return utils.generateResponse("fail", "Failed to update item", null);
        }
    }

    @Override
    public ResponseModel<Item> deleteItem(Long id) {
        Optional<Item> deleteItem = itemRepository.findById(id);
        try {
            if(deleteItem.isPresent()) {
                deleteItem.get().setIsActive(false);
                itemRepository.save(deleteItem.get());
                return utils.generateResponse("Succes", "Item " + deleteItem.get().getItemName() + " is removed.",
                        deleteItem);
            }
            else {
                return utils.generateResponse("fail", "Failed to remove Item.", null);
            }
        }
        catch (Exception e) {
            return utils.generateResponse("fail", "Failed to remove Item.", null);
        }
    }
}
