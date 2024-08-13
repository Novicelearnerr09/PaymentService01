package com.example.paymentserviceproject.Service;

import com.example.paymentserviceproject.PaymentGateWay.PaymentGateway;
import com.example.paymentserviceproject.PaymentGateWay.PaymentGatewayChooserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
   @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

   public String initiatePayment(String orderId, String email, String phoneNumber, Long amount)
   {
       try {
           PaymentGateway pg = paymentGatewayChooserStrategy.getPaymentGateway();
           return pg.getPaymentLink(orderId, email, phoneNumber, amount);
       }
       catch(Exception exception)
       {
           throw new RuntimeException(exception);
       }
   }
}
