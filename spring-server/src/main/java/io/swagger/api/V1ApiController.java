package io.swagger.api;

import io.swagger.model.CreditCard;
import io.swagger.model.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-18T20:34:07.576Z")

@Controller
public class V1ApiController implements V1Api {

    private static final Logger log = LoggerFactory.getLogger(V1ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    public static final String HASH_KEY = "Payment";

    @Autowired
    private RedisTemplate template;

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    public ResponseEntity<Payment> getPaymentById(@ApiParam(value = "", required = true) @PathVariable("payment_order_id") String paymentOrderId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                Payment payment = (Payment) template.opsForHash().get(HASH_KEY,paymentOrderId);
                CreditCard card = payment.getCreditCardInfo();
                return new ResponseEntity<Payment>(objectMapper.readValue("<Payment> <CreditCard> <card_number>"+ card.getCardNumber() +"</card_number> <cvc>"+ card.getCvc()+" </cvc> <expiration> " + card.getExpiration() + " </expiration>  </CreditCard>  <seller_account>" + payment.getSellerAccount() + "</seller_account>  <amount>" + payment.getAmount() + "</amount>  <currency>" + payment.getCurrency() + "</currency>  <payment_order_id>" + payment.getPaymentOrderId() + "</payment_order_id></Payment>", Payment.class), HttpStatus.OK);
            } catch (IOException e) {
                System.out.println("error");
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                Payment payment = (Payment) template.opsForHash().get(HASH_KEY,paymentOrderId);
                CreditCard card = payment.getCreditCardInfo();
                return new ResponseEntity<Payment>(objectMapper.readValue("{" +
                        "    \"credit_card_info\":\n" +
                        "        {\n" +
                        "            \"card_number\":\""+card.getCardNumber()+"\",\n" +
                        "            \"cvc\":\""+card.getCvc()+"\",\n" +
                        "            \"expiration\":\""+card.getExpiration()+"\"\n" +
                        "        },\n" +
                        "    \"seller_account\":\""+payment.getSellerAccount()+"\",\n" +
                        "    \"amount\":\""+payment.getAmount()+"\",\n" +
                        "    \"currency\":\""+payment.getCurrency()+"\",\n" +
                        "    \"payment_order_id\":\""+payment.getPaymentOrderId()+"\"\n" +
                        "}", Payment.class), HttpStatus.OK);
            } catch (IOException e) {
                System.out.println("error");
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Payment> placePayment(@ApiParam(value = "", required = true) @Valid @RequestBody Payment body) {
        String accept = request.getHeader("Accept");
        System.out.println("statut : "+getPaymentById(body.getPaymentOrderId()).getStatusCode());
        if (getPaymentById(body.getPaymentOrderId()).getStatusCode() != HttpStatus.OK) {
            System.out.println("statut : "+getPaymentById(body.getPaymentOrderId()).getStatusCode());
            if (accept != null && accept.contains("application/xml")) {
                try {
                    CreditCard card = body.getCreditCardInfo();
                    template.opsForHash().put(HASH_KEY, body.getPaymentOrderId(), body);
                    return new ResponseEntity<Payment>(objectMapper.readValue("<Payment> <CreditCard> <card_number>"+ card.getCardNumber() +"</card_number> <cvc>"+ card.getCvc()+" </cvc> <expiration> " + card.getExpiration() + " </expiration>  </CreditCard>  <seller_account>" + body.getSellerAccount() + "</seller_account>  <amount>" + body.getAmount() + "</amount>  <currency>" + body.getCurrency() + "</currency>  <payment_order_id>" + body.getPaymentOrderId() + "</payment_order_id></Payment>", Payment.class), HttpStatus.CREATED);
                } catch (IOException e) {
                    System.out.println("error");
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

            if (accept != null && accept.contains("application/json")) {
                try {
                    template.opsForHash().put(HASH_KEY, body.getPaymentOrderId(), body);
                    CreditCard card = body.getCreditCardInfo();
                    return new ResponseEntity<Payment>(objectMapper.readValue("{" +
                            "    \"credit_card_info\":\n" +
                            "        {\n" +
                            "            \"card_number\":\""+card.getCardNumber()+"\",\n" +
                            "            \"cvc\":\""+card.getCvc()+"\",\n" +
                            "            \"expiration\":\""+card.getExpiration()+"\"\n" +
                            "        },\n" +
                            "    \"seller_account\":\""+body.getSellerAccount()+"\",\n" +
                            "    \"amount\":\""+body.getAmount()+"\",\n" +
                            "    \"currency\":\""+body.getCurrency()+"\",\n" +
                            "    \"payment_order_id\":\""+body.getPaymentOrderId()+"\"\n" +
                            "}", Payment.class), HttpStatus.CREATED);
                } catch (IOException e) {
                    System.out.println("error");
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }

        return new ResponseEntity<Payment>(HttpStatus.CONFLICT);
    }

}
