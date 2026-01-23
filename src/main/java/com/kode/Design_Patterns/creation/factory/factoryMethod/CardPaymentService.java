package com.kode.Design_Patterns.creation.factory.factoryMethod;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay(Double amount) {
        System.out.println(amount+ " payment done by card");

    }
}
