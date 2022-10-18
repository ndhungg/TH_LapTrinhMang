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
public class Server {
   public static void main(String[] args) throws SocketException, IOException {
    DatagramSocket server = new DatagramSocket(8888);
            System.out.println("Server dang chay!");
        
            byte mangn[] = new byte[256];
            DatagramPacket nhann = new DatagramPacket(mangn, mangn.length);
            
            server.receive(nhann);
            //
            String chuoin = new String(nhann.getData(),0,nhann.getLength()).trim();
          
            String s=chuoin;
            System.out.println(""+s);
            try{
                File f = new File(s);
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null){
                System.out.println(line);
            }
             fr.close();
             br.close();;
            
        }catch (IOException e){
            e.printStackTrace();
        }
            //
            server.close();
            
      }
}
