package com.example.demo.Factory;

import org.springframework.stereotype.Component;

@Component("CREDIT_CARD")
public class CreditCardPayment implements PaymentProcessor {
    private static final double COMMISSION_RATE = 0.03;

    @Override
    public double processPayment(double amount) {
        double finalAmount = amount + (amount * COMMISSION_RATE);
        System.out.println("Procesando pago con tarjeta de crédito");
        if (amount > 1000) {
            finalAmount += 10; // Cargo adicional
        }
        return finalAmount;
    }
}