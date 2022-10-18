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
public class Server {
     public static void main(String[] args) throws SocketException, IOException {
    DatagramSocket server = new DatagramSocket(8888);
            System.out.println("Server dang chay!");
        
            byte mangn[] = new byte[256];
            
            DatagramPacket nhann = new DatagramPacket(mangn, mangn.length);
            server.receive(nhann);
            //
            String chuoin = new String(nhann.getData(),0,nhann.getLength()).trim();
            int n = Integer.parseInt(chuoin);
            //
            List<Integer> Uoc = new ArrayList<>();
            String Uoc_Chuoi = "Cac uoc so cua n la: ";
            String SoUoc_Chuoi = "So uoc cua n: ";
            int j=0;
            int count=0;
            for(int i = 1;i <= n;i++){
            if(n % i == 0){
                Uoc.add(i);
                count++;
                Uoc_Chuoi += i + "  ";               
                           }          
            }
             SoUoc_Chuoi += count+" ";
            byte mangUoc_byte[] = new byte[256];
            byte SoUoc_byte[] = new byte[256];
            mangUoc_byte = Uoc_Chuoi.getBytes();
            SoUoc_byte=SoUoc_Chuoi.getBytes();
            InetAddress ip = nhann.getAddress();
         //   System.out.println(""+);
            int port = nhann.getPort();
            //
            DatagramPacket sendUoc = new DatagramPacket(mangUoc_byte, mangUoc_byte.length,ip,port);
            server.send(sendUoc);
            
            DatagramPacket sendSU = new DatagramPacket(SoUoc_byte, SoUoc_byte.length,ip,port);
            server.send(sendSU);
            //
            String Uoc_SNT = "Cac uoc SNT cua n : ";
            for (int i = 0; i < Uoc.size(); i++) {
                 int x =Uoc.get(i);
                if (KiemtraUSNT(x)) {
                    Uoc_SNT =Uoc_SNT + x +"  ";
                }
            }
            byte mangUocSN_byte[] = new byte[256];
            mangUocSN_byte = Uoc_SNT.getBytes();
            DatagramPacket sendUocSN = new DatagramPacket(mangUocSN_byte, mangUocSN_byte.length,ip,port);
            server.send(sendUocSN);
            //
            server.close();
            
      }
       public static boolean KiemtraUSNT(int n) {
         if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
