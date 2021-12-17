package com.example.web;

import com.example.entity.Cart;
import com.example.entity.User;
import com.example.repository.CartRepository;
import com.example.repository.UserRepository;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserRepository userRepository;


    // GET : /api/todos/{cartId}

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/carts/{cartId}",
            produces = {"application/json"}
    )
    public ResponseEntity<?> get(@PathVariable(name = "cartId") int cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalCart.get());

    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/carts",
            consumes = {"application/json","application/xml"}
    )
    public ResponseEntity<?> post(@RequestBody Cart cart){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        cart.setUser(user);

        if(user.getBalance() <= cart.getTotalAmount()){
//           json message
        }else
            paymentService.makePayment(user,cart);

        cart = cartRepository.save(cart);

        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }
}
