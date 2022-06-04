package io.swagger.model;

import org.threeten.bp.LocalDate;

import java.io.Serializable;

public class CreditCardRedis implements Serializable {

    private String cardNumber;

    private String cvc;

    private LocalDate expiration;

    public CreditCardRedis(String cardNumber, String cvc, LocalDate expiration) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiration = expiration;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }
}
