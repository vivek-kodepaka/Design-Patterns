package com.kode.Design_Patterns.behavioral.obsNiftyFifty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements PriceObserver{
    private String username;
    @Override
    public void consumePrice(Double price) {
        System.out.println(username + ": priced updated to "+price);
    }
}
