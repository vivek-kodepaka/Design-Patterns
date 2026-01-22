package com.kode.Design_Patterns.structural.Decorator;

public class Main {
    public static void main(String[] args) {
     DataSource dataSource = new FileDataSource();
     DataSource encrpyt = new EncryptionDataSource(dataSource);
     DataSource comp = new CompressionDataSource(dataSource);
     System.out.println(encrpyt.read());
     System.out.println(comp.read());
     comp = new CompressionDataSource(encrpyt);
        System.out.println(comp.read());
    }
}
