package com.example.repository;

import com.example.entity.Cart;
import com.example.entity.Shop;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Integer> {

//    List<Shop> findAll();
//
//    Shop findByShopId(int id);
//
//    void saveShop(Shop shop);
//
//    void update(Shop shop);
//
//    void deleteId(int id);

    @Query("from Shop")
    public List<Shop> findAll();

}
