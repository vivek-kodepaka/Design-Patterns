package com.kode.Design_Patterns.structural.Decorator;

//step 4: concerete decorator
public class CompressionDataSource extends BaseDecorator{
    public CompressionDataSource(DataSource nextLayer) {
        super(nextLayer);
    }

    @Override
    public String read() {
        String value = nextLayer.read();
        return value+"_comp";
    }

    @Override
    public void write(String value) {
        System.out.println(" CompressionDataSource "+ value);
        value=value+"_comp";
        nextLayer.write(value);
    }
}
