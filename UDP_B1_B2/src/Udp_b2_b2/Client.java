/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Udp_b2_b2;
import java.util.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
       DatagramSocket client = new DatagramSocket();
        Scanner  sc = new Scanner(System.in);
        String n;
        boolean check = false;
        while(!check){
            try {
                System.out.println("Nhap duong dan: ");
                n = sc.nextLine();
                check  = true;
                byte mangn[] = new byte[256];
                mangn = String.valueOf(n).getBytes();
                InetAddress ip = InetAddress.getByName("localhost");
                int port = 8888;
                DatagramPacket guin = new DatagramPacket(mangn, mangn.length, ip, port);
                client.send(guin);
                 client.close();
            } catch (Exception e) {
                sc.nextLine();
            }
        }
       
        
     }
}
