package com.example.learnings;



import org.junit.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentCallbackTest {

    @Test
    public void testGetOnlinePaymentCallbackRequest() {
        PaymentCallback paymentCallback=new PaymentCallback();
        paymentCallback.setCafNumber("123");
        paymentCallback.setAmount("3432");
        paymentCallback.setLob("Telemedia");
        paymentCallback.setMobileNumber("9999999999");
        paymentCallback.setOrderId("123453");
        paymentCallback.setPgId("pg-123");
        paymentCallback.setTxStatus("PAYMENT_SUCCESS");

        long time=Calendar.getInstance().getTimeInMillis();
        paymentCallback.setTxDateTime(time);

        OnlinePaymentCallbackRequest onlinePaymentCallbackRequest=PaymentCallback.getOnlinePaymentCallbackRequest(paymentCallback);
        assertEquals(onlinePaymentCallbackRequest.getCafNumber(),paymentCallback.getCafNumber());
        assertEquals(onlinePaymentCallbackRequest.getAmount(),paymentCallback.getAmount());
        assertEquals(onlinePaymentCallbackRequest.getMobileNumber(),paymentCallback.getMobileNumber());
        assertEquals(onlinePaymentCallbackRequest.getTxId(),paymentCallback.getPgId());
        assertEquals(onlinePaymentCallbackRequest.getTxStatus(),"2");

        paymentCallback.setTxStatus("weqqe");
        onlinePaymentCallbackRequest=PaymentCallback.getOnlinePaymentCallbackRequest(paymentCallback);
        assertEquals(onlinePaymentCallbackRequest.getTxStatus(),paymentCallback.getTxStatus());

    }
}