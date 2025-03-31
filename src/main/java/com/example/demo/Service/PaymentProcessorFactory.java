package com.example.demo.Service;

import com.example.demo.Factory.PaymentProcessor;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class PaymentProcessorFactory {

    private final Map<String, PaymentProcessor> paymentProcessors;

    public PaymentProcessorFactory(Map<String, PaymentProcessor> paymentProcessors) {
        this.paymentProcessors = paymentProcessors;
    }

    public PaymentProcessor getPaymentProcessor(String paymentType) {
        PaymentProcessor processor = paymentProcessors.get(paymentType);
        if (processor == null) {
            throw new IllegalArgumentException("Método de pago no soportado: " + paymentType);
        }
        return processor;
    }
}