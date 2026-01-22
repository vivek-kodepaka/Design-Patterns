package com.kode.Design_Patterns.behavioral.strategey;

import lombok.AllArgsConstructor;

//step3: adding a reference to context class
@AllArgsConstructor
public class Navigator {
    private NavigationStartgey navigationStartgey;

    public Double navigate(String from , String to){
       return navigationStartgey.navigate(from,to);
    }
}
