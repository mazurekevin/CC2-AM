package io.swagger.api;


import io.swagger.model.PaymentRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @PostMapping
    public PaymentRedis save(@RequestBody PaymentRedis payment){
        return repository.save(payment);
    }

    @GetMapping("/{id}")
    public PaymentRedis getPaymentById(@PathVariable int id){

        return repository.findPaymentById(id);
    }
}
