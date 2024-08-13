package com.example.paymentserviceproject.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazarpayConfig {
    @Value("${razorpay.key.id}")
    private String razorpayId;
    @Value("${razorpay.key.Secret}")
    private String razorpaySecret;
@Bean
    public RazorpayClient getRazarPayClient() throws RazorpayException
    {
        return new RazorpayClient(razorpayId, razorpaySecret);
    }
}
