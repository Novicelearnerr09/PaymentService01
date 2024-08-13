package com.example.paymentserviceproject.PaymentGateWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayChooserStrategy {

//    @Autowired
//    private RazorpayPaymentGateway razorpayPaymentGateway;

    @Autowired
    private StripePaymentGateway stripePaymentGateway;
    public PaymentGateway getPaymentGateway()
    {
        return stripePaymentGateway;
    }

}
