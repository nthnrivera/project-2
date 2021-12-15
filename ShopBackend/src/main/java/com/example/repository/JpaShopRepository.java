package com.example.repository;

import com.example.entity.Shop;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class JpaShopRepository implements ShopRepository{

    private EntityManagerFactory entityManagerFactory;

    public JpaShopRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Shop> findAll() {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        String jpql="from Shop";
        Query query=entityManager.createQuery(jpql);
        List<Shop> shops = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();;
        return shops;
    }

    @Override
    public Shop findByShopId(int shopId) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Shop product=entityManager.find(Shop.class,shopId);
        entityManager.getTransaction().commit();
        entityManager.close();;
        return product;
    }


    @Override
    public void saveShop(Shop shop) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(shop);
        entityManager.getTransaction().commit();
        entityManager.close();;
    }


    @Override
    public void update(Shop shop) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(shop);
        entityManager.getTransaction().commit();
        entityManager.close();;
    }


    @Override
    public void deleteId(int shopId) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Shop.class,shopId));
        entityManager.getTransaction().commit();
        entityManager.close();;
    }



}