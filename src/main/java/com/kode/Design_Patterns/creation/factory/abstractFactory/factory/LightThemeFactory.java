package com.kode.Design_Patterns.creation.factory.abstractFactory.factory;

import com.kode.Design_Patterns.creation.factory.abstractFactory.Button;
import com.kode.Design_Patterns.creation.factory.abstractFactory.LightButton;
import com.kode.Design_Patterns.creation.factory.abstractFactory.LightRadio;
import com.kode.Design_Patterns.creation.factory.abstractFactory.Radio;

public class LightThemeFactory implements ThemeFactory{
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Radio createRadio() {
        return new LightRadio();
    }
}
