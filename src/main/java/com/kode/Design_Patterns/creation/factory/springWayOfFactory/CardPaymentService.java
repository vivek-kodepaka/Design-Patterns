package com.kode.Design_Patterns.creation.factory.springWayOfFactory;

import org.springframework.stereotype.Service;

@Service("CARD")
public class CardPaymentService implements PaymentService {
    @Override
    public void pay(Double amount) {
        System.out.println(amount+ " payment done by card");

    }
}
