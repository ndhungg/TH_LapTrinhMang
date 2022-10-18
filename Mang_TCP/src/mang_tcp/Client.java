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
public class Client {

    int arr[]=new int[10];
int arrFromServer[]=new int[10];
Scanner inFromUser= new Scanner(System.in);
try ( Socket client = new Socket("localhost",9994)){
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
    for(int i=0;i<10;i++)
        arr[i]=inFromUser.nextInt();

    for(int i=0;i<10;i++)
        outToServer.writeInt(arr[i]);

    for(int i=0;i<10;i++)
        arrFromServer[i]=inFromServer.readInt();

    for (int i = 0; i < arrFromServer.length; i++) {
        System.out.println("From Server::"+arrFromServer[i]);
    }
}
}
