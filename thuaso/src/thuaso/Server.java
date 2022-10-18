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
     public static List<Integer> phanTichSoNguyen(int n) {
        int i = 2;
        List<Integer> thuaso = new ArrayList<Integer>();

        while (n > 1) {
            if (n % i == 0 && CheckNTo(i)) {
                n = n / i;
                thuaso.add(i);
            } else {
                i++;
            }
        }

        if (thuaso.isEmpty()) {
            thuaso.add(n);
        }
        return thuaso;
    }
    
    public static void main(String[] args) throws IOException {
        //Khai báo ServerSocket server mở port lắng nghe
        ServerSocket server = new ServerSocket(9994);
        System.out.println("Server đang sẵn sàng lắng nghe! ");
        //Khai báo Socket client để chấp nhận các nối từ client
        Socket client = server.accept();
        System.out.println("client đã kết nối đến Server. ");
        //Tạo 2 lớp DataInputStreams và DataOutputStreams để nhận và gửi dữ liệu.
        DataInputStream dis =new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        //Nhận dữ liệu từ client và sau đó xử lý dl theo y/c.
        int n = dis.readInt();
      
        
        //xử lý dữ liệu
        // phân tích số nguyên dương n
        List<Integer> listNumbers = phanTichSoNguyen(n);
        // in kết quả ra màn hình
        String thongbao="";  
        String ketqua="";
        int size = listNumbers.size();
        for (int i = 0; i < size-1; i++) {
            thongbao += listNumbers.get(i)+" x ";
        }
        ketqua = thongbao+listNumbers.get(size - 1);
        // Trả dữ liệu về cho client
        dos.writeUTF(ketqua);
        server.close();
        client.close();
    }
    
}
