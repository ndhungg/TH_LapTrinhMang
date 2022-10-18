/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIBo;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class clientthread {
     public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",1234);
        //Khai báo các luồng nhập xuất
        Scanner in = new Scanner(client.getInputStream());
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        //Nhập dữ liệu gửi lên server
        int luachon =0;
        int n =0;
        String chuoi ="";
           System.out.println("nhập n: ");
            n = sc.nextInt();
            String guiluachon = String.valueOf(n) + "@" + String.valueOf(1);
            out.println(guiluachon);
            String songuyenton = in.nextLine().trim();
            System.out.println(n + " " + songuyenton);
        
    }
}
