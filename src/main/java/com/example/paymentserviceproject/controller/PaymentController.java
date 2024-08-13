package com.example.paymentserviceproject.controller;

import com.example.paymentserviceproject.Dtos.InitiatePaymentDto;
import com.example.paymentserviceproject.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
@Autowired
    private PaymentService paymentService;
    @PostMapping
        public String intiatePayment(@RequestBody InitiatePaymentDto initiatePaymentDto)
    {


        return  paymentService.initiatePayment(initiatePaymentDto.getOrderId(), initiatePaymentDto.getEmail(), initiatePaymentDto.getPhoneNumber(), initiatePaymentDto.getAmount());
    }

}
