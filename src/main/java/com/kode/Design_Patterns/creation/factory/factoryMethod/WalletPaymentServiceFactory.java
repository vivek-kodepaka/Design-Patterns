package com.kode.Design_Patterns.creation.factory.factoryMethod;

import com.kode.Design_Patterns.creation.factory.simpleFactory.CardPaymentService;
import com.kode.Design_Patterns.creation.factory.simpleFactory.PaymentService;
import com.kode.Design_Patterns.creation.factory.simpleFactory.WalletPaymentService;

public class WalletPaymentServiceFactory implements PaymentServiceFactory{
    @Override
    public PaymentService getInstance() {
        return new WalletPaymentService();
    }
}
