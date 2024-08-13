package com.example.paymentserviceproject.PaymentGateWay;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String getPaymentLink(String orderId, String email, String phoneNumber, Long amount) throws StripeException;
}
