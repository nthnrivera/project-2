package com.example.repository;

import com.example.entity.Cart;
import com.example.entity.Shop;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository  {

    List<Shop> findAll();

    Shop findByShopId(int id);

    void saveShop(Shop shop);

    void update(Shop shop);

    void deleteId(int id);

}
