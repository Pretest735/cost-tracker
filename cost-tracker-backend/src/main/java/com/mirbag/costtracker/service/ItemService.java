package com.mirbag.costtracker.service;

import com.mirbag.costtracker.entity.Item;
import com.mirbag.costtracker.utilities.ResponseModel;

public interface ItemService {
    public ResponseModel<Item> addItem(Item item);
    public ResponseModel<Item> updateItem(Item item);
}
