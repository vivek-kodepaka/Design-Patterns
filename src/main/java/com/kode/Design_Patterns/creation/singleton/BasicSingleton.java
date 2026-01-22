package com.kode.Design_Patterns.creation.singleton;

//constructor hiding
//global access point
public class BasicSingleton {
    //class loading eager initialization
    //drawback -> we cant pass any dynamic values to constructor
    //            eager creates object even if u dont need it
    private static BasicSingleton basicSingleton= new BasicSingleton();
    private BasicSingleton(){

    }
    public static BasicSingleton getInstance(){
        return basicSingleton;
    }


}
