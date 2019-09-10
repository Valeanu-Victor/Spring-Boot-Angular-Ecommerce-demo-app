package com.ecommerce.app.securedapp.jpaRepository;

import com.ecommerce.app.securedapp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
}