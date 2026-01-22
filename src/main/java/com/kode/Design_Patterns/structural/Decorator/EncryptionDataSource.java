package com.kode.Design_Patterns.structural.Decorator;

public class EncryptionDataSource extends BaseDecorator{
    public EncryptionDataSource(DataSource nextLayer) {
        super(nextLayer);
    }

    @Override
    public String read() {
        String value=  nextLayer.read();
        return value+ "_encr";
    }

    @Override
    public void write(String value) {
        value=value+ "_encr";
        System.out.println(value);
        nextLayer.write(value);

    }
}
