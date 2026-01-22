package com.kode.Design_Patterns.structural.Flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Tree {
    String name;

    public void draw(String name,int x,int y) {
        System.out.println(name+ " position x="+x+" y="+y);
    }
}
