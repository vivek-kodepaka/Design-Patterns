package com.kode.Design_Patterns.creation.builder;

public class Main {
    public static void main(String[] args) {
        Database database = Database.builder()
                .userName("")
                .password("")
                .url("").port("").build();

        Database2 database2 = Database2.builder().setUserName("").setUrl("").build();
    }
}
