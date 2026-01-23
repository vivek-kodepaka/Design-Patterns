package com.kode.Design_Patterns.creation.factory.abstractFactory.factory;

import com.kode.Design_Patterns.creation.factory.abstractFactory.Button;
import com.kode.Design_Patterns.creation.factory.abstractFactory.Radio;

public interface ThemeFactory {
    Button createButton();
    Radio createRadio();
}
