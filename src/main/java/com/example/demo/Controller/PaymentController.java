package com.example.demo.Controller;

import com.example.demo.Factory.PaymentProcessor;
import com.example.demo.Service.PaymentProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")

public class PaymentController {

    @Autowired
    private final PaymentProcessorFactory paymentProcessorFactory;

    public PaymentController(PaymentProcessorFactory paymentProcessorFactory) {
        this.paymentProcessorFactory = paymentProcessorFactory;
    }

    @PostMapping("/process")
    public double processPayment(@RequestParam String paymentType, @RequestParam double amount) {
        PaymentProcessor processor = paymentProcessorFactory.getPaymentProcessor(paymentType);
        return processor.processPayment(amount);
    }
}
