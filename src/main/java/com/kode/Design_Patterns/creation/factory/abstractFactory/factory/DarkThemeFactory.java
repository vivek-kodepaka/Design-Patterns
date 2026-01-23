package com.kode.Design_Patterns.creation.factory.abstractFactory.factory;

import com.kode.Design_Patterns.creation.factory.abstractFactory.*;

public class DarkThemeFactory implements ThemeFactory{
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Radio createRadio() {
        return new DarkRadio();
    }
}
