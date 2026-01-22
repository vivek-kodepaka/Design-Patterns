package com.kode.Design_Patterns.behavioral.strategey;
//step2:concrete stargey
public class FourVehiclerStratagey implements NavigationStartgey{
    @Override
    public Double navigate(String from, String to) {
        //get distance 
        return 1.0;
    }
}
