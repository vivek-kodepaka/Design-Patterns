package com.kode.Design_Patterns.structural.Decorator;
//step3: base decorator
//abstract --> we should be implement datasouce

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract  class BaseDecorator implements DataSource{
    protected DataSource nextLayer;

}
