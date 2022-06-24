/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files_operation;

import http_objects.Response_http;

/**
 *
 * @author INTEL
 */
public class Post_file extends Response_http {

    public String file_name = "";

    public boolean last_message = true;

    public int valid_bytes = 0;

    public byte[] content = new byte[MAX_SIZE];

    public final static int MAX_SIZE = 4000;
}
