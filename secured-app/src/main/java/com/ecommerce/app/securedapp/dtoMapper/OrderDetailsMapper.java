package com.ecommerce.app.securedapp.dtoMapper;

import com.ecommerce.app.securedapp.dto.OrderDetailsDto;
import com.ecommerce.app.securedapp.model.OrderDetails;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper {

    public OrderDetails toEntity(OrderDetailsDto dto) {
        OrderDetails entity = new OrderDetails();

        entity.setOrders(dto.getOrders());
        entity.setItem(dto.getItem());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setAmount(dto.getAmount());

        return entity;
    }
}
