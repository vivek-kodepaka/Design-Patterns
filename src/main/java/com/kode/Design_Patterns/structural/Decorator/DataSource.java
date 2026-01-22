package com.kode.Design_Patterns.structural.Decorator;
//step1 create a product interface
public interface DataSource {
    String read();
    void write(String value);
}
