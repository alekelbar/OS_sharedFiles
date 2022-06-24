/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alekelbar.os_task3;

import files_operation.Get_file;
import files_operation.Post_file;
import http_objects.Request_http;
import http_objects.Response_http;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Supplier extends Thread {

    private Socket client;

    private ObjectInputStream in;

    private ObjectOutputStream out;

    private Get_file request;

    private Post_file response;

    private Request_http stock_request;

    private Response_http stock_response;

    Supplier(Socket client) {
        this.client = client;
        try {
            this.in = new ObjectInputStream(client.getInputStream());
            this.out = new ObjectOutputStream(client.getOutputStream());
            this.request = new Get_file();
            this.response = new Post_file();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        super.run();
        Server.conectados++;
        System.out.println("Se conecto un usuario: " + Server.conectados + " activos...");
        while (true) {
            try {
                Object aux = in.readObject();

                if (aux instanceof Get_file) {

                    boolean lastSend = false;

                    request = (Get_file) aux;
                    Post_file send = new Post_file();

                    // retrasar la recepcion...
                    client.setSoLinger(true, 10);

                    // Se abre el fichero.
                    FileInputStream file = new FileInputStream("files_post/" + request.file_name);

                    send.file_name = request.file_name;

                    int read_bytes = file.read(send.content);

                    while (read_bytes > -1) {
                        send.valid_bytes = read_bytes;

                        // finalizo la lectura de bytes....
                        if (read_bytes < send.MAX_SIZE) {
                            send.last_message = true;
                            lastSend = true;
                        } else {
                            send.last_message = false;
                        }

                        out.writeObject(send);
                        out.flush();

                        if (send.last_message) {
                            break;
                        }

                        // Se crea un nuevo mensaje
                        send = new Post_file();
                        send.file_name = request.file_name;

                        // y se leen sus bytes.
                        read_bytes = file.read(send.content);
                    }

                    if (lastSend == false) {
                        send.last_message = true;
                        send.valid_bytes = 0;
                        out.writeObject(send);
                    }

                    file.close();

                } else if (aux instanceof Post_file) {
                    response = (Post_file) aux;
                    boolean oneMessage = false;

                    File file = new File("files_post/" + response.file_name);
                    FileOutputStream writter = new FileOutputStream(file);

                    writter.write(response.content, 0, response.valid_bytes);
                    if (response.last_message) {
                        oneMessage = true;
                    }

                    Object aux_post = null;

                    do {
                        if (!oneMessage) {
                            aux_post = in.readObject();

                            if (aux_post instanceof Post_file) {
                                response = (Post_file) aux_post;
                                writter.write(response.content, 0, response.valid_bytes);
                                System.out.println("reading ....");
                            }
                        } else {
                            System.out.println("Only one read message");
                            break;
                        }

                    } while (!response.last_message);
                    writter.close();

                } else if (aux instanceof Request_http) {
                    stock_request = (Request_http) aux;
                    String[] data = stock_request.getData();

                    Response_http response_stock = new Response_http();

                    if (data[0].equals("stock")) {
                        response_stock.data = readStock();
                        out.writeObject(response_stock);
                        out.flush();
                    } else {
                        response_stock.data = "Vacio";
                    }
                }

            } catch (ClassNotFoundException e) {
                System.out.println("An error has ocurrs: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("An error has ocurrs: " + e.getMessage());
                Server.conectados--;
                System.out.println("Un usuario se a desconectado...");
                break; // Se desconecta este cliente..
            }
        }
    }

    String readStock() {
        String carpAct = System.getProperty("user.dir");
        File carpet = new File(carpAct + "/files_post/");
        String data_dir = "";

        for (String dir : carpet.list()) {
            data_dir += dir + ":";

        }
        return data_dir;
    }
}
