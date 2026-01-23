package com.kode.Design_Patterns.creation.factory.springWayOfFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentServiceFactory {

    @Autowired
    private Map<String, PaymentService> paymentServiceMap;
    //Registry way

    public PaymentService getPaymentService(String type) {
        PaymentService service = paymentServiceMap.get(type);

        if (service == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + type);
        }

        return service;
    }


}
