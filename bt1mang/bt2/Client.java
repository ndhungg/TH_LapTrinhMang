/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phantichsnt;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author PHAM THE DUC
 */
public class Client {
     public static void main(String[] args) throws IOException{
        Socket client = new Socket("localhost",8000);
        DataInputStream din = new DataInputStream(client.getInputStream());
        DataOutputStream dout = new DataOutputStream(client.getOutputStream());
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap 1 so nguyen n : ");
        int n=Integer.parseInt(sc.nextLine());
        dout.writeInt(n);
        String chuoi= din.readUTF();
        System.out.println("Cac thua so nguyen to cua n la : " + chuoi);
        client.close();
    }
    } 

