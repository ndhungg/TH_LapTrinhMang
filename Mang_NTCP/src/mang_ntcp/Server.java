/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang_ntcp;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Server {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       ServerSocket server = new ServerSocket(9994);
        System.out.println("Server đang sẵn sàng lắng nghe! ");
        Socket client = server.accept();
        System.out.println("client đã kết nối đến Server. ");
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        int n = dis.readInt();
        int a[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = dis.readInt();
        }
        String status = "max1:" + max1(n, a) + "   max2:" + max2(n, a);
        dos.writeUTF(status);
        sort(n, a);
        status = "mang sau khi sort: ";
        for (int i = 0; i < n; i++) {
            status += "  " + a[i];
        }
        dos.writeUTF(status);
        status = "mang sau khi chèn so moi: ";
        int k = dis.readInt();
        pushing(n, a, k);
        for (int i = 0; i < n + 1; i++) {
            status += "  " + a[i];
        }
        dos.writeUTF(status);
        server.close();
        client.close();
    }
      public static int max1(int n, int a[]) {
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int max2(int n, int a[]) {
        int max1 = max1(n, a), max2 = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > max2 && a[i] < max1) {
                max2 = a[i];
            }
        }
        return max2;
    }

    public static void sort(int n, int a[]) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (a[i] < a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void pushing(int n, int a[], int k) {
        a[n] = k;
        sort(n + 1, a);
    }
}
