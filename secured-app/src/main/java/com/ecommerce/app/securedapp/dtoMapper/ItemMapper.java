package com.ecommerce.app.securedapp.dtoMapper;

import com.ecommerce.app.securedapp.dto.ItemDto;
import com.ecommerce.app.securedapp.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item toEntity(ItemDto dto) {
        Item entity = new Item();

        entity.setCategory(dto.getCategory());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setCreatedDate(dto.getCreatedDate());

        return entity;
    }

}
