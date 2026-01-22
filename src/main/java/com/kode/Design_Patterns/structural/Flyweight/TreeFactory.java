package com.kode.Design_Patterns.structural.Flyweight;

import java.util.HashMap;

public class TreeFactory {
    static HashMap<String,Tree> cache = new HashMap<>();

    public static Tree getTree(String name){

        if(!cache.containsKey(name)){
            cache.put(name, new Tree(name));
        }
        return cache.get(name);
    }
}
