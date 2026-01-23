package com.kode.Design_Patterns.creation.factory.factoryMethod;

import com.kode.Design_Patterns.creation.factory.simpleFactory.CardPaymentService;
import com.kode.Design_Patterns.creation.factory.simpleFactory.PaymentService;

public class CardPaymentServiceFactory implements PaymentServiceFactory{
    @Override
    public PaymentService getInstance() {
        return new CardPaymentService();
    }
}
