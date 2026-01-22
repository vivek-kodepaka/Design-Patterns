package com.kode.Design_Patterns.structural.Adapter;

public class PayUAdapter implements WalmartPayment{
    @Override
    public String doPayment(int id, Double amount) {
        return new PayUPayment().processPayment(id,amount);
    }
}
