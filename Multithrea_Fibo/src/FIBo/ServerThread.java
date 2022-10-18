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
public class ServerThread implements Runnable{
    private Scanner in = null;
    private PrintWriter out = null;
    private Socket socket;
    private String name;
    public ServerThread(Socket socket, String name) throws IOException {
        this.socket = socket;
        this.name = name;
        this.in = new Scanner(this.socket.getInputStream());
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        new Thread(this).start();
    }

   // ServerThread() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
    @Override
    public void run() {
        try {
            while (true) {
                String nhan = in.nextLine().trim();
                System.out.println("giá trị nhận: " + nhan);
                Scanner sc = new Scanner(nhan);
                sc.useDelimiter("@");
                String giatri = sc.next();
                String luachon = sc.next();
                int n = Integer.parseInt(luachon);
                System.out.println("giá trị: " + giatri);
                if(n==1)
                {
                    int ketqua =fibo(Integer.parseInt(giatri));
                    if(ketqua == 1)
                         System.out.println("Số fibonaci thứ " + giatri + " là " + ketqua);
                    
                }
                if(n==2)
                {
                    System.out.println("giá trị: " + giatri);
                    String chuanhoa = giatri.toLowerCase();
                    out.println(chuanhoa);
                }
            }
        } catch (Exception e) {
            System.out.println(name + " has departed");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
  public static int fibo(int n)
    {
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
        return fibo(n-1)+fibo(n-2);
    }
   public static int tinhtong(int n)
    {
        int temp;
        int sum = 0;
        while (n > 0) {
            temp = n % 10;
            sum += temp;
            n /= 10;
        }
         
      //  System.out.println("Tổng các chữ số = " + sum);
        return sum;
    }
 

    
}
