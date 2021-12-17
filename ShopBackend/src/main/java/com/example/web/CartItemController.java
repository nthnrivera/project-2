package com.example.web;

import com.example.entity.Cart;
import com.example.entity.CartItem;
import com.example.entity.Shop;
import com.example.entity.User;
import com.example.repository.CartItemRepository;
import com.example.repository.CartRepository;
import com.example.repository.UserRepository;
import com.example.service.CartService;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
public class CartItemController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/cartsitems/{cartItemsId}",
            produces = {"application/json"}
    )
    public ResponseEntity<?> get(@PathVariable(name = "cartItemsId") int cartItemsId) {
        Optional<CartItem> optionalCartItems = cartItemRepository.findById(cartItemsId);
        if (optionalCartItems.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalCartItems.get());

    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/cartsitems",
            produces = {"application/json", "application/xml"}
    )
    public Collection<CartItem> getAll() {

        Collection<CartItem> cartItems = cartItemRepository.findAll();
        return cartItems;
    }



    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/cartsitems",
            consumes = {"application/json", "application/xml"}
    )
    public ResponseEntity<?> post(@RequestBody CartItem cartItem) {


        cartItem = cartItemRepository.save(cartItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(cartItem);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/cartsitems/{cartItemsId}"
    )
    public ResponseEntity<?> delete(@PathVariable(name = "cartItemsId") int cartItemsId) {
        cartItemRepository.deleteById(cartItemsId); // delete from shop where id=?
        return ResponseEntity.ok().build();
    }


}
