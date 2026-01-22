package com.kode.Design_Patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

//step1: create an abstract for publisher + registry
//why abstract -> we dont need object of this class , will extend this in BitCoinMAnager
public abstract class Publisher {
    private List<Consumer> consumerList = new ArrayList<>();

    public void publish(Double price){
            consumerList.forEach(consumer -> consumer.consume(price));
    }

    public void addConsumer(Consumer consumer){
        consumerList.add(consumer);

    }

    public void removeConsumer(Consumer consumer){
        consumerList.remove(consumer);

    }


}
