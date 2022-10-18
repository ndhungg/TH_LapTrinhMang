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
public class Server {
      public static void main(String[] args) throws SocketException, IOException {

         DatagramSocket server = new DatagramSocket(8888);
        System.out.println("Server đang chạy!!!");
        while(true)
        {
            byte manga[] = new byte[256];
            int lenght = manga.length;
            DatagramPacket nhann = new DatagramPacket(manga, lenght);
            server.receive(nhann);
            String chuoin = new String(nhann.getData(),0,nhann.getLength()).trim();
            int []n=new int [100];
            
            n[] = chuoin;
            byte SoNguyen[] = new byte[256];
            SoNguyen=SN.getBytes();
            InetAddress ip= nhann.getAddress();
            int port = nhann.getPort();
            DatagramPacket guifibo = new DatagramPacket(SoNguyen, SoNguyen.length, ip, port);
            server.send(guifibo);
//            mangfibo = String.valueOf(sofibo).getBytes();
//            int lenghtfi = mangfibo.length;
//            InetAddress ip = nhann.getAddress();
//            int port = nhann.getPort();
//            DatagramPacket guifibo = new DatagramPacket(mangfibo, lenghtfi, ip, port);
//            server.send(guifibo);
        }
    }
    public static String SN= "";
    public static void SoNguyen(int a[], int n, int i){
        int dem =0;
        for (int j=0;j<n;j++){
            if(a[j]==i)
                dem++;
        }
        for(i=0; i<n;i++){
            if(dem == 1) SN=String.valueOf(a[i]);
        }
    }
}
