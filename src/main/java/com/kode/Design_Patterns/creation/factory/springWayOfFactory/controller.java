package com.kode.Design_Patterns.creation.factory.springWayOfFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    PaymentServiceFactory paymentServiceFactory;

    @GetMapping("/payment/{name}/{amount}")
    public String pay(@PathVariable String name,@PathVariable Double amount){
        paymentServiceFactory.getPaymentService(name).pay(amount);
        return "check in console";
    }
}
