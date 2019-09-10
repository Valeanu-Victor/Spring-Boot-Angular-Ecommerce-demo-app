package com.ecommerce.app.securedapp.jpaRepository;

import com.ecommerce.app.securedapp.model.OrderDetails;
import com.ecommerce.app.securedapp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    @Override
    List<OrderDetails> findAllById(Iterable<Long> iterable);

    List<OrderDetails> findAllByOrders(Orders orders);
}
