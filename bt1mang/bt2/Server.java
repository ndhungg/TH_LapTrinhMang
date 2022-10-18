/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phantichsnt;

import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
  public static boolean CheckNTo(int n){
        if(n<=2){
            return true;
        }
        else{
            for(int i =2; i<=Math.sqrt(n);i++){
                if(n%i==0) return false;
            }
        }
        return true;
    }
    public static List<Integer> PTThuaSo(int n){
        List<Integer> listNumber = new ArrayList<Integer>();
        for(int i=2;i<=n;i++){
            while((n%i==0)&& CheckNTo(i)){
                n=n/i;
                listNumber.add(i);
            }
        }
        System.out.print(listNumber);
        return listNumber;
    }
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8000);
        System.out.print("Server da san sang...");
        Socket client = server.accept();
        System.out.print("Client da ket noi toi Server ....");
        DataInputStream din = new DataInputStream(client.getInputStream());
        DataOutputStream dout = new DataOutputStream(client.getOutputStream());
        int n = din.readInt();
        System.out.print(n);
        List<Integer> listNumber = PTThuaSo(n);
        String chuoi="";
        for(int i =0; i< listNumber.size();i++){
            chuoi += listNumber.get(i)+"x";
        }
        dout.writeUTF(chuoi);
        server.close();
        client.close();
        
    }
}
