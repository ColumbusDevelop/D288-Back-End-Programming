package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.services.Purchase;
import com.example.demo.services.PurchaseResponse;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.example.demo.entities.StatusType.*;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //makes cart and assigns value with getCart
        Cart cart = purchase.getCart();

        //makes order number
        String orderTrackingNumber = generateOrderTrackingNumber();

        //assigns number in cart
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //gets cart items from purchase
        Set<CartItem> cartItems = purchase.getCartItems();

        //assigns order items to cart
        cartItems.forEach(item -> cart.add(item));

        //assigns enum
        cart.setStatus(ordered);

        //associate cart to the customer
        cart.setCustomer(purchase.getCustomer());

        //saves cart to repository
        cartRepository.save(cart);

        //returns
        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        // generate random UUID number
        return UUID.randomUUID().toString();
    }
}
