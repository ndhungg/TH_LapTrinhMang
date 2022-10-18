/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_fibo;
import java.util.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        //Giai đoạn 2: Client tạo Socket
        DatagramSocket client = new DatagramSocket();
        //Giai đoạn 3: trao đổi dữ liệu giữa client và server
            //Giai đoạn 3.1: khai báo số nguyên n
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean check = false;
        while (!check) {            
            try
            {
                System.out.println("Nhập số nguyên n: ");
                n = sc.nextInt();
                check =true;
            }
            catch(Exception e)
            {
                sc.nextLine();
            }
        }
            //Giai đoạn 3.2: client tạo packet để gửi lên server: (1 mảng byte, 2 chiều dài mảng byte, 3 địa chỉ đích, 4 cổng đích)
                //Giai đoạn 3.2.1: tạo mảng dữ liệu
        byte mangn[] = new byte[256];
        mangn = String.valueOf(n).getBytes();
                //Giai đoạn 3.2.2: Tính chiều dài của mảng
        int lenght = mangn.length;
                //giai đoạn 3.2.3: khai báo địa chỉ máy đích (máy server)
        InetAddress ip = InetAddress.getByName("localhost");
                //Giai đoạn 3.2.4: khai báo cổng server
        int port = 8888;
        DatagramPacket guin = new DatagramPacket(mangn, lenght, ip, port);
        client.send(guin);
            //Giai đoạn 3.6: client nhận dữ liệu, khai báo packet (cần 2: 1 mảng chứa, 2 chiều dài mảng chứa)
                //Giai đoạn 3.6.1: khai báo mảng chứa dữ liệu từ server gửi về.
        byte nhanfi[] = new byte[256];
                //Giai đoạn 3.6.2: khai báo chiều dài mảng chứa dữ liệu từ server gửi về.
        int lenghtfi = nhanfi.length;
        DatagramPacket nhansofi = new DatagramPacket(nhanfi, lenghtfi);
        client.receive(nhansofi);
            //Giai đoạn 3.7: client hiển thị dữ liệu lên màn hình
        String fibonaci = new String(nhansofi.getData(),0, nhansofi.getLength()).trim();
        System.out.println("Số fibonaci thứ " + n + " là " + fibonaci);
            //giai đoạn 3.8: đóng socket
        client.close();
        
                
    } 
}
