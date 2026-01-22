package com.kode.Design_Patterns.creation.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){

    }

    public static BillPughSingleton getInstance(){
        return HOLDER.billPughSingleton;
    }

    private static class HOLDER{
        private static BillPughSingleton billPughSingleton = new BillPughSingleton();
    }
}
