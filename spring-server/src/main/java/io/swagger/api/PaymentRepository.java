package io.swagger.api;


import io.swagger.model.PaymentRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    public static final String HASH_KEY = "Payment";

    @Autowired
    private RedisTemplate template;

    public PaymentRedis save(PaymentRedis payment){
        PaymentRedis paymentResult = findPaymentById(payment.getPaymentOrderId());
        if (paymentResult==null) {
            template.opsForHash().put(HASH_KEY, payment.getPaymentOrderId(), payment);
            return payment;
        }else{
            return null;
        }

    }

    public PaymentRedis findPaymentById(int id) {
        return (PaymentRedis) template.opsForHash().get(HASH_KEY,id);
    }
}
