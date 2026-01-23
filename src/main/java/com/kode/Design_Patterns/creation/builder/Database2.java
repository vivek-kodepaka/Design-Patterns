package com.kode.Design_Patterns.creation.builder;

public class Database2 {
    private String url;
    private String userName;
    private String password;
    private String port;



    private Database2(){}

    private Database2(String url, String userName, String password, String port) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.port = port;
    }

    public static Database2Builder builder(){
        return new Database2Builder();
    }

    public static class Database2Builder{
        private Database2 database2;

        Database2Builder(){
            this.database2=new Database2();
        }

        public Database2Builder setUrl(String url) {
            this.database2.url = url;
            return this;
        }

        public Database2Builder setUserName(String userName) {
            this.database2.userName = userName;
            return this;
        }

        public Database2Builder setPassword(String password) {
            this.database2.password = password;
            return this;
        }

        public Database2Builder setPort(String port) {
            this.database2.port = port;
            return this;
        }

        public Database2 build(){
            if(isValid())
                return new Database2(this.database2.url,this.database2.userName,this.database2.password,this.database2.port);

            throw new IllegalArgumentException("Invalid database configuration");
        }

        private boolean isValid(){
            if(database2.url==null){
               return false;
            }
            return true;
        }


    }
}
