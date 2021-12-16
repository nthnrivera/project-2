//package com.example;
//
//import com.example.repository.JpaShopRepository;
//import com.example.repository.ShopRepository;
//import com.example.web.ShopController;
//import io.javalin.Javalin;
//
//public class ShopApiServerApplication {
//
//
//    static {
//        ShopRepository shopRepository = new JpaShopRepository();
//        ShopController.shopRepository = shopRepository;
//    }
//
//    public static void main(String[] args) {
//
//        Javalin app = Javalin.create(config -> {
//            // your config here
//            config.enableCorsForAllOrigins();
//        }).start(4200); // server:4200
//
//
//        //------------------------------------
//        // REST API
//        //------------------------------------
//
//        // http://localhost:4200/
//
//        // Routes
//        app.get("/api/products", ShopController.getAll);
//        app.get("/api/products/{productId}", ShopController.get);
//        app.post("/api/products", ShopController.create);
//        app.put("/api/products/{productId}", ShopController.update);
//        app.delete("/api/products/{productId}", ShopController.delete);
//        // app.get("/api/products/{productId}/reviews", ProductController.getReviews);
//
//    }
//}