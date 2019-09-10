package com.ecommerce.app.securedapp.dtoMapper;

import com.ecommerce.app.securedapp.dto.OrdersDto;
import com.ecommerce.app.securedapp.model.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrdersMapper {

    public Orders toEntity(OrdersDto dto) {
        Orders entity = new Orders();

        entity.setUser(dto.getUser());
        entity.setTotalCost(dto.getTotalCost());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setCheckedOut(dto.isCheckedOut());

        return entity;
    }
}