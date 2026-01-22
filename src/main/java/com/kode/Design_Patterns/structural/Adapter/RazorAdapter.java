package com.kode.Design_Patterns.structural.Adapter;

public class RazorAdapter implements WalmartPayment{
    @Override
    public String doPayment(int id, Double amount) {
        return new RazorPayPayment().pay(id,amount);
    }
}
