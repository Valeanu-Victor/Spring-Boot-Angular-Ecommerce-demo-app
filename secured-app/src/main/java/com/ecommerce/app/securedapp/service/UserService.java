package com.ecommerce.app.securedapp.service;

import com.ecommerce.app.securedapp.dto.UserDto;
import com.ecommerce.app.securedapp.dtoMapper.UserMapper;
import com.ecommerce.app.securedapp.jpaRepository.UserRepository;
import com.ecommerce.app.securedapp.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private OrdersService ordersService;

    @Autowired
    private void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity<HttpStatus> createUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        userRepository.save(userMapper.toEntity(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Orders returnActiveOrder(long idUser) {
        // returns null if user has no active order or else it returns the active order
        List<Orders> orders = ordersService.getOrdersByIdUser(idUser);
        if (orders.isEmpty()) {
            return null;
        }

        for (Orders order : orders) {
            if (!order.isCheckedOut()) return order;
        }
        return null;
    }
}