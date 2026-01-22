package com.kode.Design_Patterns.behavioral.observer;

public class SmsConsumer implements Consumer{
    @Override
    public void consume(Double price) {
        System.out.println("sending sms for price: "+ price);
    }
}
