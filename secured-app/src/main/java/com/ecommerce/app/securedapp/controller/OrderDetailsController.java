package com.ecommerce.app.securedapp.controller;

import com.ecommerce.app.securedapp.model.viewModels.AddItemModelView;
import com.ecommerce.app.securedapp.model.viewModels.CartModelView;
import com.ecommerce.app.securedapp.model.viewModels.CartOwnerUsernameModel;
import com.ecommerce.app.securedapp.model.viewModels.RemoveOneProductModel;
import com.ecommerce.app.securedapp.service.OrderDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order/details")
public class OrderDetailsController {

    private OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping(
            value = "/additem",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HttpStatus> addItemToCart(@RequestBody AddItemModelView itemModelView) {
        if (itemModelView.getQuantity() <= 0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return orderDetailsService.addItemsToCart(itemModelView);
    }

    @PostMapping(
            value = "/cart",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<CartModelView>> getCartItems(@RequestBody CartOwnerUsernameModel cartOwnerUsernameModel) {
        return orderDetailsService.retrieveCartItems(cartOwnerUsernameModel);
    }

    @PostMapping(
            value = "/removeOne",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HttpStatus> removeOne(@RequestBody RemoveOneProductModel removeOneProductModel) {
        return this.orderDetailsService.removeOneOrderDetails(removeOneProductModel);
    }
}