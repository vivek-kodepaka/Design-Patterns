package com.kode.Design_Patterns.creation.factory.abstractFactory;

import com.kode.Design_Patterns.creation.factory.abstractFactory.factory.DarkThemeFactory;
import com.kode.Design_Patterns.creation.factory.abstractFactory.factory.LightThemeFactory;
import com.kode.Design_Patterns.creation.factory.abstractFactory.factory.ThemeFactory;

public class Main {
    public static void main(String[] args) {
        ThemeFactory themeFactory = new DarkThemeFactory();
        System.out.println(themeFactory.createButton().getButton());
        System.out.println(themeFactory.createRadio().getRadio());

        themeFactory = new LightThemeFactory();
        System.out.println(themeFactory.createButton().getButton());
        System.out.println(themeFactory.createRadio().getRadio());
    }
}
