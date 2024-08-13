package com.example.paymentserviceproject.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentDto {
    private Long amount;
    private String phoneNumber;
    private String email;
    private String OrderId;

}
