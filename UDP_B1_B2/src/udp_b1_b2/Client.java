/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_b1_b2;
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
        int n = 0;
        boolean check = false;
        
        while(!check){
            try {
                System.out.println("Nhap so nguyen n: ");
                n = sc.nextInt();
                check  = true;
                byte mangn[] = new byte[256];
                mangn = String.valueOf(n).getBytes();
                //
                InetAddress ip = InetAddress.getByName("localhost");
                int port = 8888;
                //
                DatagramPacket guin = new DatagramPacket(mangn, mangn.length, ip, port);
                client.send(guin);
                //
                byte nhanUoc[] = new byte[256];
                DatagramPacket nhanUocN = new  DatagramPacket(nhanUoc, nhanUoc.length);
                client.receive(nhanUocN);
                byte nhanSoUoc[] = new byte[256];
                DatagramPacket nhanSOUocN = new  DatagramPacket(nhanSoUoc, nhanSoUoc.length);
                client.receive(nhanSOUocN);
                //
                String UocN = new String(nhanUocN.getData(),0,nhanUocN.getLength()).trim();
                System.out.println(UocN);
                String SoUocN = new String(nhanSOUocN.getData(),0,nhanSOUocN.getLength()).trim();
                System.out.println(SoUocN);
                //
                byte nhanUocSN[] = new byte[256];
                DatagramPacket nhanUocSN_ = new  DatagramPacket(nhanUocSN, nhanUocSN.length);
                client.receive(nhanUocSN_);
                //
                String UocSN = new String(nhanUocSN_.getData(),0,nhanUocSN_.getLength()).trim();
                System.out.println(UocSN);
                //
                 client.close();
            } catch (Exception e) {
                sc.nextLine();
            }
        }
       
        
     }
}
