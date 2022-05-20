package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CreditCard;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Payment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-18T20:34:07.576Z")


public class Payment   {
  @JsonProperty("credit_card_info")
  private CreditCard creditCardInfo = null;

  @JsonProperty("seller_account")
  private String sellerAccount = null;

  @JsonProperty("amount")
  private String amount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("payment_order_id")
  private String paymentOrderId = null;

  public Payment(CreditCard creditCardInfo, String sellerAccount, String amount, String currency, String paymentOrderId) {
    this.creditCardInfo = creditCardInfo;
    this.sellerAccount = sellerAccount;
    this.amount = amount;
    this.currency = currency;
    this.paymentOrderId = paymentOrderId;
  }

  public Payment creditCardInfo(CreditCard creditCardInfo) {
    this.creditCardInfo = creditCardInfo;
    return this;
  }

  /**
   * Get creditCardInfo
   * @return creditCardInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CreditCard getCreditCardInfo() {
    return creditCardInfo;
  }

  public void setCreditCardInfo(CreditCard creditCardInfo) {
    this.creditCardInfo = creditCardInfo;
  }

  public Payment sellerAccount(String sellerAccount) {
    this.sellerAccount = sellerAccount;
    return this;
  }

  /**
   * Get sellerAccount
   * @return sellerAccount
  **/
  @ApiModelProperty(value = "")


  public String getSellerAccount() {
    return sellerAccount;
  }

  public void setSellerAccount(String sellerAccount) {
    this.sellerAccount = sellerAccount;
  }

  public Payment amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Payment currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Payment paymentOrderId(String paymentOrderId) {
    this.paymentOrderId = paymentOrderId;
    return this;
  }

  /**
   * Get paymentOrderId
   * @return paymentOrderId
  **/
  @ApiModelProperty(value = "")


  public String getPaymentOrderId() {
    return paymentOrderId;
  }

  public void setPaymentOrderId(String paymentOrderId) {
    this.paymentOrderId = paymentOrderId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.creditCardInfo, payment.creditCardInfo) &&
        Objects.equals(this.sellerAccount, payment.sellerAccount) &&
        Objects.equals(this.amount, payment.amount) &&
        Objects.equals(this.currency, payment.currency) &&
        Objects.equals(this.paymentOrderId, payment.paymentOrderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditCardInfo, sellerAccount, amount, currency, paymentOrderId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    creditCardInfo: ").append(toIndentedString(creditCardInfo)).append("\n");
    sb.append("    sellerAccount: ").append(toIndentedString(sellerAccount)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    paymentOrderId: ").append(toIndentedString(paymentOrderId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

