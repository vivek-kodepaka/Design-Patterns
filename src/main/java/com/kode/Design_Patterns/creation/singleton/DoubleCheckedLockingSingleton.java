package com.kode.Design_Patterns.creation.singleton;

public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton doubleCheckedLockingSingleton= null;
    private DoubleCheckedLockingSingleton(){

    }

    public static DoubleCheckedLockingSingleton getInstance(){
        if(doubleCheckedLockingSingleton == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (doubleCheckedLockingSingleton == null) {
                    doubleCheckedLockingSingleton = new DoubleCheckedLockingSingleton();
                    /*
                    * doubleCheckedLockingSingleton = new DoubleCheckedLockingSingleton();
                    * 1. allocating memory
                    * 2. initializing
                    * 3. assiging to varaible
                    *
                    * */
                }
            }
        }


        return doubleCheckedLockingSingleton;
    }
}
