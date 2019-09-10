package com.ecommerce.app.securedapp.service;

import com.ecommerce.app.securedapp.dto.ItemDto;
import com.ecommerce.app.securedapp.dtoMapper.ItemMapper;
import com.ecommerce.app.securedapp.jpaRepository.ItemRepository;
import com.ecommerce.app.securedapp.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public ResponseEntity<HttpStatus> insertOne(ItemDto itemDto) {
        Optional<Item> itemOptional = itemRepository.findByNameAndCategory(itemDto.getName(), itemDto.getCategory());
        Item item = null;
        if (itemOptional.isPresent()) {
            item = itemOptional.get();
        }
        if (item != null) {
            item.setQuantity(itemDto.getQuantity() + item.getQuantity());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            itemRepository.save(itemMapper.toEntity(itemDto));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
