//package com.example.repository;
//
//import com.example.entity.Shop;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//
//@Repository
//@Transactional
//public class JpaShopRepository implements {
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Override
//    public List<Shop> findAll() {
//
//        String jpql="from Shop";
//        Query query=entityManager.createQuery(jpql);
//
//        List<Shop> shops = query.getResultList();
//
//        return shops;
//    }
//
//    @Override
//    public Shop findByShopId(int shopId) {
//
//        Shop product=entityManager.find(Shop.class,shopId);
//
//        return product;
//    }
//
//    @Override
//    public void saveShop(Shop shop) {
//
//        entityManager.persist(shop);
//
//    }
//
//    @Override
//    public void update(Shop shop) {
//
//        entityManager.merge(shop);
//
//    }
//
//
//    @Override
//    public void deleteId(int shopId) {
//
//        entityManager.remove(entityManager.find(Shop.class,shopId));
//
//    }
//
//
//
//}