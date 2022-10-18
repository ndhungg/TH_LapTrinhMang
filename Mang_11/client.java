package mang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9994);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        Scanner nhap = new Scanner(System.in);
        int n;
        boolean status = false;
        while (!status) {
            try {
                System.out.println("nhập số nguyên a: ");
                n = Integer.parseInt(nhap.nextLine());
                dos.writeInt(n);
                while (n < 0) {
                    System.out.println("số sai, nhap lai: ");
                    n = Integer.parseInt(nhap.nextLine());
                }
                for (int i = 0; i < n; i++) {
                    System.out.println("nhập số nguyên a[" + i + "]: ");
                    int x = Integer.parseInt(nhap.nextLine());
                    dos.writeInt(x);
                }
                String ketqua = dis.readUTF();
                System.out.println(ketqua);
                ketqua = dis.readUTF();
                System.out.println(ketqua);
                System.out.println("nhập số nguyên cần chèn : ");
                n = Integer.parseInt(nhap.nextLine());
                dos.writeInt(n);
                ketqua = dis.readUTF();
                System.out.println(ketqua);
                status = true;
                client.close();
            } catch (NumberFormatException ex) {

            }
        }

    }
}
