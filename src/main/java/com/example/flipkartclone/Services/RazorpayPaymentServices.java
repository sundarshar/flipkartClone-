package com.example.flipkartclone.Services;

import com.example.flipkartclone.Dtos.PaymentRequestDto;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("Razorpay")
public class RazorpayPaymentServices implements PaymentServices {

    private RazorpayClient razorpayClient;
    public RazorpayPaymentServices( RazorpayClient razorpayClient ) {
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String doPayment(PaymentRequestDto paymentRequestDto) throws RazorpayException {
        try{
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",paymentRequestDto.getAmount());
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("receipt", paymentRequestDto.getOrderId());

        JSONObject customer = new JSONObject();
        customer.put("email",paymentRequestDto.getEmail());
        customer.put("phone",paymentRequestDto.getPhone());
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);

        paymentLinkRequest.put("callback_url", "https://flipkartClone.com/razorpayWebHook");
        paymentLinkRequest.put("callback_method", "post");

        PaymentLink response = razorpayClient.paymentLink.create(paymentLinkRequest);
        return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
