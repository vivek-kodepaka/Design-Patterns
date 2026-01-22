package com.kode.Design_Patterns.creation.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tree implements ClonableInterface{

    private int length;
    private int age;
    private  Postion postion;
    @Override
    public Tree clone() {
        return new Tree(this);
    }

    private Tree(Tree tree){
        this.age=tree.getAge();
        this.length=tree.getLength();
        this.postion=tree.getPostion()!=null? new Postion(tree.getPostion()):null;
    }
}
