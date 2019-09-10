package com.ecommerce.app.securedapp.jpaRepository;

import com.ecommerce.app.securedapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByNameAndCategory(String name, String category);
}