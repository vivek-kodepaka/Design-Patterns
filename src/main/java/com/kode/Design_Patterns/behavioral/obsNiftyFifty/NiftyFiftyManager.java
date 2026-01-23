package com.kode.Design_Patterns.behavioral.obsNiftyFifty;

import java.util.ArrayList;
import java.util.List;

public  class NiftyFiftyManager {
    List<PriceObserver> consumersList = new ArrayList<>();

    void addUser(PriceObserver priceObserver){
        consumersList.add(priceObserver);
    }
    void removeUser(PriceObserver priceObserver){
        consumersList.remove(priceObserver);
    }

    void publishPriceChange(Double price){
        consumersList.forEach(c->c.consumePrice(price));
    }
}
