package com.example.learnings;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;
import lombok.Data;

@Data
public class PaymentCallback {

    @JsonProperty("cafNumber")
    private String cafNumber;

    @JsonProperty("mobileNumber")
    private String mobileNumber;

    @JsonProperty("lob")
    private String lob;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("txStatus")
    private String txStatus;


    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("pgId")
    private String pgId;

    @JsonProperty("txDateTime")
    private Long txDateTime;

    @Nullable
    public static OnlinePaymentCallbackRequest getOnlinePaymentCallbackRequest(PaymentCallback paymentCallback){
        if (paymentCallback==null){
            return null;
        }

        OnlinePaymentCallbackRequest onlinePaymentCallbackRequest=new OnlinePaymentCallbackRequest();
        onlinePaymentCallbackRequest.setCafNumber(paymentCallback.getCafNumber());
        onlinePaymentCallbackRequest.setAmount(paymentCallback.getAmount());
        onlinePaymentCallbackRequest.setTxId(paymentCallback.getPgId());
        onlinePaymentCallbackRequest.setTxDateTime(paymentCallback.getTxDateTime());
        onlinePaymentCallbackRequest.setMobileNumber(paymentCallback.getMobileNumber());


        String backwardPaymentStatus= TransactionStatus.PAYMENT_SUCCESS.getTransactionStatusType()
                                                                       .equalsIgnoreCase(paymentCallback.getTxStatus())?"2":
                                                                        paymentCallback.getTxStatus();

        onlinePaymentCallbackRequest.setTxStatus(backwardPaymentStatus);

        return onlinePaymentCallbackRequest;
    }


}
