package com.kode.Design_Patterns.structural.Decorator;
// concrete product class
public class FileDataSource implements DataSource{
    @Override
    public String read() {
        return "Base";
    }

    @Override
    public void write(String value) {
        System.out.println(value);
    }
}
