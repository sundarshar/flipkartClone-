package com.example.flipkartclone.Services;

import com.example.flipkartclone.Dtos.PaymentRequestDto;
import org.springframework.stereotype.Service;

@Service("Strip")
public class StripPaymentServices implements PaymentServices{
    @Override
    public String doPayment(PaymentRequestDto paymentRequestDto) {
        return null;
    }
}
