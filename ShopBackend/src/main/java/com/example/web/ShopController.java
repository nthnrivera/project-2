package com.example.web;

import com.example.entity.Shop;
import com.example.repository.ShopRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class ShopController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopRepository shopRepository;


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/shops/{shopId}",
            produces = {"application/json"}
    )
    public ResponseEntity<?> get(@PathVariable(name = "shopId") int cartId) {
        Optional<Shop> optionalShop = shopRepository.findById(cartId);
        if (optionalShop.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalShop.get());

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/shops",
            produces = {"application/json", "application/xml"}
    )
    public Collection<Shop> getAll() {

        Collection<Shop> shops = shopRepository.findAll();
        return shops;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/shops",
            consumes = {"application/json", "application/xml"}
    )
    public ResponseEntity<?> post(@RequestBody Shop shop) {

        shop = shopRepository.save(shop);

        return ResponseEntity.status(HttpStatus.CREATED).body(shop);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/shops/{shopId}"
    )
    public ResponseEntity<?> put(
            @PathVariable(name = "shopId") int shopId,
            @RequestBody Shop shop
    ) {
        shop.setId(shopId);
        shop=shopRepository.save(shop); // update
        return ResponseEntity.ok(shop);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/shops/{shopId}"
    )
    public ResponseEntity<?> delete(@PathVariable(name = "shopId") int shopId) {
        shopRepository.deleteById(shopId); // delete from shop where id=?
        return ResponseEntity.ok().build();
    }


}
