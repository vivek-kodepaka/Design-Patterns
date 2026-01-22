package com.kode.Design_Patterns.creation.singleton;

public class DoubleCheckedLockingSingleton {
    private static DoubleCheckedLockingSingleton doubleCheckedLockingSingleton= null;
    private DoubleCheckedLockingSingleton(){

    }

    public static DoubleCheckedLockingSingleton getInstance(){
        if(doubleCheckedLockingSingleton == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (doubleCheckedLockingSingleton == null) {
                    doubleCheckedLockingSingleton = new DoubleCheckedLockingSingleton();
                }
            }
        }


        return doubleCheckedLockingSingleton;
    }
}
