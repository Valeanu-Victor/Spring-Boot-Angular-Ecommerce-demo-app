package com.ecommerce.app.securedapp.controller;

import com.ecommerce.app.securedapp.dto.ItemDto;
import com.ecommerce.app.securedapp.model.Item;
import com.ecommerce.app.securedapp.model.viewModels.InsertItemModel;
import com.ecommerce.app.securedapp.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAll() {
        List<Item> items = itemService.getItems();

        if (items.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping(
            value = "/seller",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HttpStatus> insertItem(@RequestBody InsertItemModel insertItemModel) {
        ItemDto itemDto = new ItemDto();

        itemDto.setCategory(insertItemModel.getCategory());
        itemDto.setName(insertItemModel.getName());
        itemDto.setPrice(insertItemModel.getPrice());
        itemDto.setQuantity(insertItemModel.getQuantity());
        itemDto.setCreatedDate(new Date());

        return itemService.insertOne(itemDto);
    }
}