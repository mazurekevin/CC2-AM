package io.swagger.api;

import io.swagger.model.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    public ResponseEntity<Payment> getPaymentById(@ApiParam(value = "", required = true) @PathVariable("payment_order_id") String paymentOrderId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Payment>(objectMapper.readValue("<Payment>  <seller_account>aeiou</seller_account>  <amount>aeiou</amount>  <currency>aeiou</currency>  <payment_order_id>aeiou</payment_order_id></Payment>", Payment.class), HttpStatus.OK);
            } catch (IOException e) {
                System.out.println("error");
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Payment>(objectMapper.readValue("{\"empty\": false}", Payment.class), HttpStatus.OK);
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
        if (getPaymentById(body.getPaymentOrderId()).getStatusCode() != HttpStatus.OK) {

            if (accept != null && accept.contains("application/xml")) {
                try {
                    return new ResponseEntity<Payment>(objectMapper.readValue("<Payment>  <seller_account>aeiou</seller_account>  <amount>aeiou</amount>  <currency>aeiou</currency>  <payment_order_id>aeiou</payment_order_id></Payment>", Payment.class), HttpStatus.CREATED);
                } catch (IOException e) {
                    System.out.println("error");
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

            if (accept != null && accept.contains("application/json")) {
                try {
                    return new ResponseEntity<Payment>(objectMapper.readValue("{\"empty\": false}", Payment.class), HttpStatus.CREATED);
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
