/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang_tcp;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Server {
    int arrFromClient[]=new int[10];
ServerSocket welcomeSocket = new ServerSocket(6786);
while(true){
    Socket connectionSocket = welcomeSocket.accept();
    DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
    for(int i=0;i<10;i++) {
        arrFromClient[i] = inFromClient.readInt();
    }
    Arrays.sort(arrFromClient);
    for (int i = 0; i < arrFromClient.length; i++) {
        outToClient.writeInt(arrFromClient[i]);
    }
}
}
