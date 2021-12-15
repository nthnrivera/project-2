package com.example.service;

import com.example.entity.Cart;
import com.example.entity.PaymentType;
import com.example.entity.User;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public Cart makePayment(User user, Cart cart) {
        if( cart.getPaymentType() == PaymentType.DEBIT){
            user.setBalance(user.getBalance()- cart.getTotalAmount());
            cart.setTotalAmount(0.0);

        }
        if(cart.getPaymentType() == PaymentType.CREDIT){
            user.setBalance(user.getBalance()- cart.getTotalAmount());
            cart.setTotalAmount(0.0);
        }
        return cart;
    }

    // can I call cart information here
    // I need cart and User information => amount user balance
    // Do I need one more controller "Payment Controller"
}
