package com.ecommerce.app.securedapp.service;

import com.ecommerce.app.securedapp.dto.OrderDetailsDto;
import com.ecommerce.app.securedapp.dto.OrdersDto;
import com.ecommerce.app.securedapp.dtoMapper.OrderDetailsMapper;
import com.ecommerce.app.securedapp.dtoMapper.OrdersMapper;
import com.ecommerce.app.securedapp.jpaRepository.ItemRepository;
import com.ecommerce.app.securedapp.jpaRepository.OrderDetailsRepository;
import com.ecommerce.app.securedapp.jpaRepository.OrdersRepository;
import com.ecommerce.app.securedapp.jpaRepository.UserRepository;
import com.ecommerce.app.securedapp.model.Item;
import com.ecommerce.app.securedapp.model.OrderDetails;
import com.ecommerce.app.securedapp.model.Orders;
import com.ecommerce.app.securedapp.model.User;
import com.ecommerce.app.securedapp.model.viewModels.AddItemModelView;
import com.ecommerce.app.securedapp.model.viewModels.CartOwnerUsernameModel;
import com.ecommerce.app.securedapp.model.viewModels.CartModelView;
import com.ecommerce.app.securedapp.model.viewModels.RemoveOneProductModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {

    private OrdersRepository ordersRepository;
    private ItemRepository itemRepository;
    private UserService userService;
    private UserRepository userRepository;
    private OrdersMapper ordersMapper;
    private OrderDetailsRepository orderDetailsRepository;
    private OrderDetailsMapper orderDetailsMapper;

    public OrderDetailsService(OrdersRepository ordersRepository, ItemRepository itemRepository,
                               UserService userService, UserRepository userRepository,
                               OrdersMapper ordersMapper, OrderDetailsRepository orderDetailsRepository,
                               OrderDetailsMapper orderDetailsMapper) {
        this.ordersRepository = ordersRepository;
        this.itemRepository = itemRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.ordersMapper = ordersMapper;
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderDetailsMapper = orderDetailsMapper;
    }

    public ResponseEntity<HttpStatus> addItemsToCart(AddItemModelView itemModelView) {
        // check if item exists and if it has enough stock
        Optional<Item> optionalItem = itemRepository.findById(itemModelView.getIdItem());
        if (!optionalItem.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Item item = optionalItem.get();
        int remainingQuantity = item.getQuantity() - itemModelView.getQuantity();

        if (remainingQuantity < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        // check if User has Order with isCheckedOut status set to false
        // if not create new Order for the User
        User user = userRepository.findByUsername(itemModelView.getUsername());
        double totalCost = itemModelView.getQuantity() * itemModelView.getPrice();

        if (userService.returnActiveOrder(user.getId()) == null) {
            OrdersDto ordersDto = new OrdersDto(user, totalCost, new Date(), false);
            Orders order = ordersMapper.toEntity(ordersDto);
            ordersRepository.save(order);

            item.setQuantity(item.getQuantity() - itemModelView.getQuantity());
            itemRepository.save(item);

            // create OrderDetails
            OrderDetailsDto orderDetailsDto = new OrderDetailsDto(order, item, itemModelView.getQuantity(),
                    itemModelView.getPrice(), totalCost);
            orderDetailsRepository.save(orderDetailsMapper.toEntity(orderDetailsDto));

            return new ResponseEntity<>(HttpStatus.OK);
        }

        // if user has active order -> add Item to that order
        Orders order = userService.returnActiveOrder(user.getId());

        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(order, item, itemModelView.getQuantity(),
                itemModelView.getPrice(), totalCost);
        orderDetailsRepository.save(orderDetailsMapper.toEntity(orderDetailsDto));

        order.setTotalCost(order.getTotalCost() + totalCost);
        ordersRepository.save(order);

        item.setQuantity(item.getQuantity() - itemModelView.getQuantity());
        itemRepository.save(item);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<CartModelView>> retrieveCartItems(CartOwnerUsernameModel cartOwnerUsernameModel) {
        User user = userRepository.findByUsername(cartOwnerUsernameModel.getUsername());

        Orders order = userService.returnActiveOrder(user.getId());
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<CartModelView> cartModelViews = new ArrayList<>();
        List<OrderDetails> activeOrderDetails = orderDetailsRepository.findAllByOrders(order);

        for (OrderDetails orderDetails : activeOrderDetails) {
            CartModelView cartModelView = new CartModelView();

            cartModelView.setOrderDetailsId(orderDetails.getId());
            cartModelView.setItemId(orderDetails.getItem().getId());
            cartModelView.setItemName(orderDetails.getItem().getName());
            cartModelView.setCategory(orderDetails.getItem().getCategory());
            cartModelView.setQuantity(orderDetails.getQuantity());
            cartModelView.setPrice(orderDetails.getPrice());

            cartModelViews.add(cartModelView);
        }

        return new ResponseEntity<>(cartModelViews, HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> removeOneOrderDetails(RemoveOneProductModel removeOneProductModel) {
        // get orderDetails, totalCost, item and user
        OrderDetails orderDetails = orderDetailsRepository.getOne(removeOneProductModel.getIdOrderDetails());
        double orderDetailsAmount = orderDetails.getAmount();
        Item item = orderDetails.getItem();
        User user = userRepository.findByUsername(removeOneProductModel.getUsername());

        // put the quantity back in stock
        item.setQuantity(item.getQuantity() + orderDetails.getQuantity());
        itemRepository.save(item);

        // remove the cost of the item from the active order or remove the order if it remains empty
        // added orderDetailsRepository.deleteById to if and else because of a bug in H2 console
        // h2 console doesn't have cascade delete so I can't delete order first because of FK constrains
        Orders order = userService.returnActiveOrder(user.getId());
        double orderTotalCost = order.getTotalCost() - orderDetailsAmount;
        if (orderTotalCost > 0) {
            order.setTotalCost(orderTotalCost);
            ordersRepository.save(order);
            orderDetailsRepository.deleteById(removeOneProductModel.getIdOrderDetails());
        } else {
            orderDetailsRepository.deleteById(removeOneProductModel.getIdOrderDetails());
            ordersRepository.delete(order);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}