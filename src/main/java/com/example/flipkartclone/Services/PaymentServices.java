package com.example.flipkartclone.Services;

import com.example.flipkartclone.Dtos.PaymentRequestDto;
import com.razorpay.RazorpayException;

public interface PaymentServices {

    String doPayment(PaymentRequestDto paymentRequestDto) throws RazorpayException;
}
