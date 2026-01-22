package com.kode.Design_Patterns.behavioral.observer;

public class EmailConsumer implements Consumer{
    @Override
    public void consume(Double price) {
        System.out.println("sending email for price: "+ price);
    }
}
