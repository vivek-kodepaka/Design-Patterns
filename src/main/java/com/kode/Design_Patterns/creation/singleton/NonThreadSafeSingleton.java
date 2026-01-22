package com.kode.Design_Patterns.creation.singleton;

public class NonThreadSafeSingleton {

    // multiple thread breaks it
    private static NonThreadSafeSingleton nonThreadSafeSingleton = null;
    private NonThreadSafeSingleton(){

    }

    public static NonThreadSafeSingleton getInstance(){
        if(nonThreadSafeSingleton==null){
            nonThreadSafeSingleton=new NonThreadSafeSingleton();
        }
        return nonThreadSafeSingleton;
    }
}
