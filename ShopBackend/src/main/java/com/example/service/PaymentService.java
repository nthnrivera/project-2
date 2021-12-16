package com.example.service;

import com.example.entity.Cart;
import com.example.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    Cart makePayment(User user, Cart cart);

}
