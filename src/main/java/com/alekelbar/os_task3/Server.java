/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alekelbar.os_task3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static int conectados;

    public static void main(String[] args) {
        try {
            int port = 65000;
            ServerSocket server = new ServerSocket(port);
            
            while (true) {
                System.out.println("Server listen at: " + server.getInetAddress() + " on port: " + server.getLocalPort());
                Socket client = server.accept(); // Cliente

                Supplier observable = new Supplier(client);

                observable.start();
            }
        } catch (IOException e) {
            System.out.println("Se desconecto el serviodor...");
        }
    }
}
