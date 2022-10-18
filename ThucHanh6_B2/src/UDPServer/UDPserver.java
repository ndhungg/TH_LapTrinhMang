/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPServer;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class UDPserver {
     static final int PORT=1234;
    private DatagramSocket socket=null;
    public UDPserver(){
        try{
            socket=new DatagramSocket(PORT);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void action(){
        InetAddress host=null;
        int port;
        String chuoi="";
        try{
            System.out.println("Server is running");
            while(true){
                DatagramPacket packet=receive(); 
                host=packet.getAddress();
                port=packet.getPort();
                chuoi=new String(packet.getData()).trim();
                if(!chuoi.equals("")){
                    Scanner s=new Scanner(chuoi);
                    s.useDelimiter("!");        
                    String loai = s.next();
                    String str = s.next();
                    if(loai.equals("tinh"))
                    {
                        if(!str.equals(""))
                        {
                        Scanner sc = new Scanner(str);
                        sc.useDelimiter("@");
                             int so1=sc.nextInt();
                        String pheptoan=sc.next();
                        int so2=sc.nextInt();
                        if(pheptoan.equals("+"))
                            str=(so1+so2)+"";
                        else if(pheptoan.equals("-"))
                            str=(so1-so2)+"";
                        else if(pheptoan.equals("*"))
                            str=(so1*so2)+"";
                        else if(pheptoan.equals("/"))
                            str=(so1/so2)+"";
                        send(str,host,port);
                    }
                    }else
                    {
                        str=str.toUpperCase();
                        if(!str.equals(""))
                            send(str,host,port);
                    }   
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            socket.close();
        }
    }
    private void send(String chuoi,InetAddress host,int port)throws IOException{
        byte[] buffer=chuoi.getBytes();
        DatagramPacket packet=new DatagramPacket(buffer, buffer.length, host, port);
        socket.send(packet);
    }
    private DatagramPacket receive()throws IOException{
        byte[] buffer=new byte[65507];
        DatagramPacket paket=new DatagramPacket(buffer, buffer.length);
        socket.receive(paket);
        return paket;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new UDPserver().action();
    }
    
}
