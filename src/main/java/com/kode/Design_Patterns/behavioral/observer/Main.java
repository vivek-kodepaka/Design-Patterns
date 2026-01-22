package com.kode.Design_Patterns.behavioral.observer;

public class Main {

    public static void main(String[] args) {
        BitCoin bitCoin = new BitCoin(0.0);
        BitCoinManager bitCoinManager = new BitCoinManager(bitCoin);
        bitCoinManager.addConsumer(new EmailConsumer());
        bitCoinManager.addConsumer(new SmsConsumer());
        bitCoinManager.setPrice(10.0);
        bitCoinManager.setPrice(11.0);

    }
}
