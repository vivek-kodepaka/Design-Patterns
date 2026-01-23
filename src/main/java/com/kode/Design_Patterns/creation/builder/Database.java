package com.kode.Design_Patterns.creation.builder;
/*
* step1 private constructor
* step2 : static inner builder class -> same variable names as outer class
* step3: add setters with builder as return type
* step4: add static builder method in outer class which gives DatabaseBuilder obj
* step5: add validation in builder class
* step6: add build method in builder class --> return outer class
*
* */
public class Database {

    private String url;
    private String userName;
    private String password;
    private String port;

    private Database(String url,String userName,String password,String port){
        this.url=url;
        this.userName=userName;
        this.password=password;
        this.port=port;
    }
    private Database(){
    }
    public static DatabaseBuilder builder(){
        return new DatabaseBuilder();
    }

    public static class DatabaseBuilder{
        private String url;
        private String userName;
        private String password;
        private String port;


        public DatabaseBuilder url(String url) {
            this.url = url;
            return this;
        }
        public DatabaseBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public DatabaseBuilder password(String password) {
            this.password = password;
            return this;
        }

        public DatabaseBuilder port(String port) {
            this.port = port;
            return this;
        }

        public Database build(){
            if(validate())
                return new Database(this.url,this.userName,this.password,this.port);

            throw new IllegalArgumentException("Invalid database configuration");
        }



        public Boolean validate(){
            if(this.userName==null){
                throw new IllegalArgumentException("Invalid database configuration username is null");
                //return false;
            }
            if(this.url==null)
                    return false;

            if(this.port==null)
                throw new IllegalArgumentException("Invalid database configuration port is null");

            return true;

        }


    }
}
