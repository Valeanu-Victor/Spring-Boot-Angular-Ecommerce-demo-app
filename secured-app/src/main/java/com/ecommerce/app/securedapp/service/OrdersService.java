package com.ecommerce.app.securedapp.service;

import com.ecommerce.app.securedapp.jpaRepository.OrdersRepository;
import com.ecommerce.app.securedapp.jpaRepository.UserRepository;
import com.ecommerce.app.securedapp.model.Orders;
import com.ecommerce.app.securedapp.model.User;
import com.ecommerce.app.securedapp.model.viewModels.CartOwnerUsernameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersService {
    private final UserRepository userRepository;
    private final OrdersRepository orderRepository;
    private UserService userService;

    @Autowired
    private void setUserService(UserService userService){
        this.userService = userService;
    }

    public OrdersService(UserRepository userRepository, OrdersRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    public List<Orders> getOrdersByIdUser(long idUser) {
        User user = userRepository.getOne(idUser);

        List<Orders> orders = new ArrayList<>();
        for (Orders order : getOrders()) {
            if (order.getUser().getId() == user.getId()) {
                orders.add(order);
            }
        }

        return orders;
    }

    public ResponseEntity<HttpStatus> checkout(CartOwnerUsernameModel cartOwnerUsernameModel) {
        User user = userRepository.findByUsername(cartOwnerUsernameModel.getUsername());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        long id = user.getId();
        if (userService.returnActiveOrder(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Orders order = userService.returnActiveOrder(id);

        order.setCheckedOut(true);
        orderRepository.save(order);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}