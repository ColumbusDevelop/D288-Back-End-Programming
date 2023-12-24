package com.example.demo.services;

// Not sure if these two imports needed but added them anyways
import com.example.demo.services.Purchase;
import com.example.demo.services.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}

