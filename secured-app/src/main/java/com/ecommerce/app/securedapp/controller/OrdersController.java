package com.ecommerce.app.securedapp.controller;

import com.ecommerce.app.securedapp.model.Orders;
import com.ecommerce.app.securedapp.model.viewModels.CartOwnerUsernameModel;
import com.ecommerce.app.securedapp.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAll() {
        List<Orders> orders = ordersService.getOrders();

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<Orders> getOrderByIdUser(@PathVariable long idUser) {
        List<Orders> orders = ordersService.getOrdersByIdUser(idUser);
        if (orders != null) {
            return new ResponseEntity<>((Orders) orders, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(
            value = "/checkout",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HttpStatus> checkoutOrder(@RequestBody CartOwnerUsernameModel cartOwnerUsernameModel) {
        return ordersService.checkout(cartOwnerUsernameModel);
    }
}
