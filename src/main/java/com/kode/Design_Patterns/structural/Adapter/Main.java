package com.kode.Design_Patterns.structural.Adapter;

public class Main {

    public static void main(String[] args) {
        // need to make a payment

        WalmartPayment walmartPayment = new RazorAdapter();
        System.out.println(walmartPayment.doPayment(1,23.1));
        WalmartPayment walmartPayment1 = new PayUAdapter();
        System.out.println(walmartPayment1.doPayment(2,345.3));
    }
}
