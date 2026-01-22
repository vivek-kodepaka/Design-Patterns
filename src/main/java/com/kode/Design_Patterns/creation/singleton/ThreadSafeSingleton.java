package com.kode.Design_Patterns.creation.singleton;

public class ThreadSafeSingleton {

    // drawback is
    private static ThreadSafeSingleton threadSafeSingleton=null;
    private ThreadSafeSingleton(){

    }

    // all threads will wait here , only one thread goes inside at a time
    // wait time increases
    public static synchronized ThreadSafeSingleton getInstance(){

        if(threadSafeSingleton==null){
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }
}
