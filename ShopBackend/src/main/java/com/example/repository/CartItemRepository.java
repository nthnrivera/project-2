package com.example.repository;

import com.example.entity.CartItem;
import com.example.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    @Query("from CartItem ")
    public List<CartItem> findAll();

}
