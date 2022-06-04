package io.swagger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Payment")
public class PaymentRedis implements Serializable {

    private CreditCardRedis creditCardInfo;

    private String sellerAccount;

    private String amount;

    private String currency;

    @Id
    private int paymentOrderId;


    public PaymentRedis(CreditCardRedis creditCardInfo, String sellerAccount, String amount, String currency, int paymentOrderId) {
        this.creditCardInfo = creditCardInfo;
        this.sellerAccount = sellerAccount;
        this.amount = amount;
        this.currency = currency;
        this.paymentOrderId = paymentOrderId;
    }

    public CreditCardRedis getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(CreditCardRedis creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(int paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }
}
