/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package http_objects;

import java.io.Serializable;

public class http_properties implements Serializable{
  public String data; // Alexander:1234:laurel

  public String[] getData() {
    return data.split(":");
  }
}
