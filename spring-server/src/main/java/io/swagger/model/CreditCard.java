package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreditCard
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-18T20:34:07.576Z")


public class CreditCard   {
  @JsonProperty("card_number")
  private String cardNumber = null;

  @JsonProperty("cvc")
  private String cvc = null;

  @JsonProperty("expiration")
  private LocalDate expiration = null;

  public CreditCard(String cardNumber, String cvc, LocalDate expiration) {
    this.cardNumber = cardNumber;
    this.cvc = cvc;
    this.expiration = expiration;
  }

  public CreditCard(String cardNumber, String cvc, java.time.LocalDate of) {
  }

  public CreditCard cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * Get cardNumber
   * @return cardNumber
  **/
  @ApiModelProperty(value = "")


  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public CreditCard cvc(String cvc) {
    this.cvc = cvc;
    return this;
  }

  /**
   * Get cvc
   * @return cvc
  **/
  @ApiModelProperty(value = "")


  public String getCvc() {
    return cvc;
  }

  public void setCvc(String cvc) {
    this.cvc = cvc;
  }

  public CreditCard expiration(LocalDate expiration) {
    this.expiration = expiration;
    return this;
  }

  /**
   * Get expiration
   * @return expiration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getExpiration() {
    return expiration;
  }

  public void setExpiration(LocalDate expiration) {
    this.expiration = expiration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCard creditCard = (CreditCard) o;
    return Objects.equals(this.cardNumber, creditCard.cardNumber) &&
        Objects.equals(this.cvc, creditCard.cvc) &&
        Objects.equals(this.expiration, creditCard.expiration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardNumber, cvc, expiration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCard {\n");
    
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    cvc: ").append(toIndentedString(cvc)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
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

