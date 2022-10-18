/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;
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
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        Scanner nhap= new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        // khởi tạo mảng arr
        int[] a = new int[n];
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            a[i] = sc.nextInt();
        }
        byte manga[] = new byte[256];
        manga = String.valueOf(a).getBytes();
        int lenght = manga.length;
        InetAddress ip = InetAddress.getByName("localhost");
        int port = 8888;
        DatagramPacket guia = new DatagramPacket(manga, lenght, ip, port);
        client.send(guia);
        byte nhanfi[] = new byte[256];
        int lenghtfi = nhanfi.length;
      /*  DatagramPacket nhansofi = new DatagramPacket(nhanfi, lenghtfi);
        client.receive(nhansofi);
        String fibonaci = new String(nhansofi.getData(),0, nhansofi.getLength()).trim();
        System.out.println("Các phần tử xuát hiện 1 lần là " + fibonaci);
        client.close();
        
         }*/          
    }
}
