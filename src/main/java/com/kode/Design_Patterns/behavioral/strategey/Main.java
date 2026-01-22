package com.kode.Design_Patterns.behavioral.strategey;

public class Main {

    public static void main(String[] args) {
        NavigationStartgey navigationStartgey = new TwoVehiclerStratagey();
        Navigator navigator = new Navigator(navigationStartgey);
        System.out.println(navigator.navigate("10","2"));
        navigationStartgey = new FourVehiclerStratagey();
        navigator = new Navigator(navigationStartgey);
        System.out.println(navigator.navigate("10","2"));

    }
}
