/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alekelbar.os_task3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    
    private String stock;
    public static int conectados;
            
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            while (true) {
                int port = 65000;
                server = new ServerSocket(port);
                System.out.println("Server listen at: " + server.getInetAddress() + " on port: " + server.getLocalPort());
                Socket client = server.accept(); // Cliente

                Supplier observable = new Supplier(client);

                observable.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    void readStock(){
        
    }
}
