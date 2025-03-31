package com.example.demo.Factory;

import org.springframework.stereotype.Component;

@Component("DEBIT_CARD")
public class DebitCardPayment implements PaymentProcessor {
    private static final double COMMISSION_RATE = 0.01;

    @Override
    public double processPayment(double amount) {
        double finalAmount = amount + (amount * COMMISSION_RATE);
        System.out.println("Procesando pago con tarjeta de débito");
        if (amount > 500) {
            finalAmount += 5; // Cargo adicional
        }
        return finalAmount;
    }
}