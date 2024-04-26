package com.example.flipkartclone.Services.Stratagy;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelectionImp implements PaymentGatewaySelection{

    @Override
    public int paymentGatewaySelection() {
        return 1;
    }
}
