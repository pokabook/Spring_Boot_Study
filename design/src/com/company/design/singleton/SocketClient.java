package com.company.design.singleton;

public class SocketClient {

    private static SocketClient socketClient;

    private SocketClient(){

    }

    public static SocketClient getInstance(){
        if(socketClient == null){
           socketClient = new SocketClient(); /*NULL인 경우 새로운 객체 생성*/
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
