package com.kode.Design_Patterns.behavioral.obsNiftyFifty;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

public class Main {
    public static void main(String[] args) {
        NiftyFifty niftyFifty = new NiftyFifty(10.0);

        NiftyFiftyManager niftyFiftyManager = new NiftyFiftyManager();
        Users users = new Users("kode");
        niftyFiftyManager.addUser(users);
        users = new Users("vivek");
        niftyFiftyManager.addUser(users);

        niftyFiftyManager.publishPriceChange(20.0);
    }
}
