package com.kode.Design_Patterns.behavioral.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BitCoinManager extends Publisher{
    private BitCoin bitCoin;

    public void setPrice(Double price){
        bitCoin.setPrice(price);
        publish(price);
    }
}
