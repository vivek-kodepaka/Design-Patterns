package com.kode.Design_Patterns.creation.factory.simpleFactory;

public abstract class PaymentServiceFactory {

    public static PaymentService getInstance(String name){

        if(name.equalsIgnoreCase("wallet"))
            return new WalletPaymentService();
        else if (name.equalsIgnoreCase("card"))
            return new CardPaymentService();
        else if(name.equalsIgnoreCase("upi"))
            return new UPIPaymentService();

        throw new RuntimeException("no service found for "+ name);

    }
}
