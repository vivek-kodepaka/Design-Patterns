package com.kode.Design_Patterns.creation.prototype;

public class Main {
    public static void main(String[] args) {
        Postion p = new Postion(1,2,3);
        Tree tree = new Tree(10,10,p);

        Tree tree2 =  tree.clone();
        System.out.println(tree2.getPostion()==tree.getPostion());
    }
}
