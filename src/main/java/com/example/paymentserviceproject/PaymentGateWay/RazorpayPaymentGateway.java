package com.example.paymentserviceproject.PaymentGateWay;
//package com.example.demo.PaymentGateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;


import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway {

    private RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String getPaymentLink(String orderId, String email, String phoneNumber, Long amount)  {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);
            paymentLinkRequest.put("expire_by", 1723275278);
            paymentLinkRequest.put("reference_id", orderId);
            paymentLinkRequest.put("description", "Payment for policy no #" + orderId);
           // paymentLinkRequest.put("name",name);
            JSONObject customer = new JSONObject();
            customer.put("email", email);
            customer.put("name", phoneNumber);
            customer.put("contact", "Anurag Khanna");
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);
//           JSONObject notes = new JSONObject();
//           notes.put("policy_name", "Jeevan Bima");
//           paymentLinkRequest.put("notes", notes);
            paymentLinkRequest.put("callback_url", "https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method", "get");
            PaymentLink paymentLink = razorpayClient.paymentLink.create(paymentLinkRequest);
            return paymentLink.get("short_url").toString();
        }catch(RazorpayException r) {
            throw new RuntimeException(r);
        }
    }
}

