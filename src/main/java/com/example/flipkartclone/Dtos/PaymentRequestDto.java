package com.example.flipkartclone.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDto {
    private String email;
    private String phone;
    private Long amount;
    private String orderId;
}
