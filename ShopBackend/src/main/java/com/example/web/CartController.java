package com.example.web;

import com.example.entity.Cart;
import com.example.repository.CartRepository;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

//    @Autowired
//    private UserRepository userRepository;

    // GET : /api/todos/{todoId}

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/cart/{cartId}",
            produces = {"application/json"}
    )
    public ResponseEntity<?> get(@PathVariable(name = "cartId") int cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalCart.get());

    }
}
