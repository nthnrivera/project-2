package com.example;

import com.example.repository.JpaProductRepository;
import com.example.repository.ProductRepository;
import com.example.web.ProductController;
import io.javalin.Javalin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ShopApiServerApplication {

    static {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        ProductRepository productRepository = new JpaProductRepository(entityManagerFactory);
        ProductController.productRepository = productRepository;
    }

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            // your config here
            config.enableCorsForAllOrigins();
        }).start(4200); // server:4200


        //------------------------------------
        // REST API
        //------------------------------------

        // http://localhost:4200/

        // Routes
        app.get("/api/products", ProductController.getAll);
        app.get("/api/products/{productId}", ProductController.get);
        app.post("/api/products", ProductController.create);
        app.put("/api/products/{productId}", ProductController.update);
        app.delete("/api/products/{productId}", ProductController.delete);
        // app.get("/api/products/{productId}/reviews", ProductController.getReviews);

    }
}