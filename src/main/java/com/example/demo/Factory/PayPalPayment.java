package com.example.demo.Factory;

import org.springframework.stereotype.Component;

@Component("PAYPAL")
public class PayPalPayment implements PaymentProcessor {
    private static final double COMMISSION_RATE = 0.02;

    @Override
    public double processPayment(double amount) {
        double finalAmount = amount + (amount * COMMISSION_RATE);
        System.out.println("Procesando pago con PayPal");
        if (amount > 750) {
            finalAmount += 7; // Cargo adicional
        }
        return finalAmount;
    }
}