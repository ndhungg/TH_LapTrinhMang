/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpchat;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class ThreadChat implements Runnable{
    private Socket socket=null;
    public static frmClient chat=null;
    private Scanner in=null;
    ServerSocket server=null;
    
    public ThreadChat(){
        try {
            server= new ServerSocket(1234);
        } catch (Exception e) {e.printStackTrace();
        }
        new Thread(this).start();
}
    public void run(){
        try {
            while(true){
                while((socket=server.accept())!=null){
                    this.in=new Scanner(this.socket.getInputStream());
                    String chuoi=in.nextLine().trim();
                    chat.Hienthi(chuoi+"\n");
                }
            }
        } catch (Exception e) {
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
   
}    
