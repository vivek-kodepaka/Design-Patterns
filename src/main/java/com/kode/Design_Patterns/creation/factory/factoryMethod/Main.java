package com.kode.Design_Patterns.creation.factory.factoryMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        PaymentServiceFactory paymentServiceFactory = new CardPaymentServiceFactory();
        paymentServiceFactory.getInstance().pay(10.0);

        paymentServiceFactory = new UPIPaymentServiceFactory();
        paymentServiceFactory.getInstance().pay(10.0);

        paymentServiceFactory = new WalletPaymentServiceFactory();
        paymentServiceFactory.getInstance().pay(10.0);


    }
}
