/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuaso;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Client {
    
     public static void main(String[] args) throws IOException {
         //Khai báo Socket kết nối đến Server thông qua: địa chỉ và cổng của server
        Socket client = new Socket("localhost",9994);
        //Tạo 2 lớp DataInputStreams và DataOutputStreams để nhận và gửi dữ liệu.
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        //Thực hiện nhập dữ liệu từ bàn phím với số nguyên n
        //Gửi dữ liệu số nguyên n đến server
        Scanner nhap = new Scanner(System.in);  
        System.out.println("nhập số nguyên n: ");
        int n=Integer.parseInt(nhap.nextLine());        
        // Thực hiện gửi Dữ liệu lên Server
        dos.writeInt(n);
        //Nhận kết quả từ Server trả về.
        String ketqua= dis.readUTF();
        System.out.println("Cac thua so nguyen to cua n la : " + ketqua);
        //Đóng kết nối Socket
        client.close();
        
    }
    
}
