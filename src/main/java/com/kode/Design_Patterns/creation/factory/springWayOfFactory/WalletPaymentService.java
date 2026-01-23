package com.kode.Design_Patterns.creation.factory.springWayOfFactory;

import org.springframework.stereotype.Service;

@Service("WALLET")
public class WalletPaymentService implements PaymentService {
    @Override
    public void pay(Double amount) {
        System.out.println(amount + "  payment done by wallet");
    }
}
