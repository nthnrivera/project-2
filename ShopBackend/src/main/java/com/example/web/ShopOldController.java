//package com.example.web;
//
//import com.example.entity.Shop;
//import com.example.repository.ShopRepository;
//import io.javalin.http.Handler;
//import org.eclipse.jetty.http.HttpStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@RestController
//public class ShopController {
//
//    public static ShopRepository shopRepository;
//
//    public static Handler getAll= ctx->{
//        List<Shop> products=shopRepository.findAll();
//        TimeUnit.SECONDS.sleep(1); // intentional delay for teaching purpose
//        ctx.json(products);
//    };
//    public static Handler get= ctx->{
//        int shopId=Integer.parseInt(ctx.pathParam("shopId"));
//        Shop shop=shopRepository.findByShopId(shopId);
//        ctx.json(shop);
//    };
//    public static Handler create= ctx->{
//        Shop product=ctx.bodyAsClass(Shop.class);
//        shopRepository.saveShop(product);
//        ctx.status(HttpStatus.CREATED_201);
//    };
//    public static Handler update= ctx->{
//        Shop shop=ctx.bodyAsClass(Shop.class);
//        int shopId=Integer.parseInt(ctx.pathParam("shopId"));
//        shop.setId(shopId);
//        shopRepository.update(shop);
//        ctx.status(HttpStatus.CREATED_201);
//    };
//    public static Handler delete= ctx->{
//        int shopId=Integer.parseInt(ctx.pathParam("shopId"));
//        shopRepository.deleteId(shopId);
//    };
//
//
//}