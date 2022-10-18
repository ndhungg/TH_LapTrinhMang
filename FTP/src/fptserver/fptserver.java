/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptserver;
//import BT1.Main;
import BT1.DBAccess;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class fptserver {
    public static final int DANGNHAP=1;
    public static final int KHONGLALENH=0;
    public static final int DANGNHAPKHONGTHANHCONG=0;
    public static final int DANGNHAPTHANHCONG=1;
    public static final int THOAT=2;
    public static final int UPLOAD=3;
    public static final int DOWNLOAD=4;
/*public static int laLenh(String cmd){
    if(cmd.equals("DANGNHAP"))
        return DANGNHAP;
    return KHONGLALENH;
    }*/
    public static final int PORT = 10000;
    public static void main(String[] args) {
        String userA="tu";
        String passA="tu";
        String path="C:/";
        DBAccess acc = new DBAccess();
        ServerSocket s;
        try {
            s=new ServerSocket(PORT);
            while(true){
                Socket new_s=s.accept();
                boolean lap=true;
                while(lap){
                    String cmd;
                    Scanner sc=new Scanner(new_s.getInputStream());
                    cmd=sc.nextLine();
                    switch (laLenh(cmd)){
                        case DANGNHAP:
                            String user=sc.nextLine();
                            String pass=sc.nextLine();
                            PrintWriter pw;
                            ResultSet rs=acc.Query("select * from taikhoan where username='"+user+"' and password='"+pass+"'");
                            pw = new PrintWriter(new_s.getOutputStream());
                            if (rs.next()) {
                                pw.println(DANGNHAPTHANHCONG);
                                path = rs.getString("path");
                                //mo thu muc len goi ve cho client                               
                                File dir = new File(path);
                                File dsFile[] = dir.listFiles();
                                if (dsFile == null) {
                                    JOptionPane.showMessageDialog(null, "Đường dẫn không đúng,hay không phait thư mục");

                                } else {
                                    pw.println(dsFile.length);
                                    for (int i = 0; i < dsFile.length; i++) {
                                        pw.println(dsFile[i].getName());
                                    }
                                }

                            //}
                           /* pw=new PrintWriter(new_s.getOutputStream());
                            if(user.equals(userA) && pass.equals(passA)){
                                pw.println(DANGNHAPTHANHCONG);
                                File dir=new File(path);
                                File dsFile[]=dir.listFiles();
                                if(dsFile==null){
                                    JOptionPane.showMessageDialog(null, "duong dan sai");
                                }else{
                                    pw.println(dsFile.length);
                                    for(int i=0;i<dsFile.length;i++)
                                        pw.println(dsFile[i].getName());
                                }*/
                            }else
                            {
                                pw.println(DANGNHAPKHONGTHANHCONG);
                                pw.println("dang nhap k thanh cong");
                            }
                            pw.flush();
                            break;
                        case UPLOAD:
                            System.out.println("Da vao lenh upload");
                            String fileName=sc.nextLine();
                            System.out.println("Da lay ten tap tin");
                            try {
                               String path2;
                               if(path.lastIndexOf("/")>=path.length()-1)
                                   path2=path + "/"+fileName;
                               else
                                   path2=path+"/"+fileName;
                               System.out.println(path2);
                               FileOutputStream fos=new FileOutputStream(new File(path2));
                               BufferedOutputStream bos=new BufferedOutputStream(fos);
                               BufferedInputStream bis;
                               bis=new BufferedInputStream(new_s.getInputStream());
                               byte buf[]=new byte[bis.available()];
                               bos.write(bis.read(buf));
                               bos.flush();
                               bos.close();
                               pw=new PrintWriter(new_s.getOutputStream());
                               pw.println("DANHAN");
                               pw.flush();
                               Main.traThuMucClient(path, pw);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                            
                        case DOWNLOAD:
                            System.out.println("Da vao lenh download");
                            String fileNameD=sc.nextLine();
                            System.out.println("Da lay ten tap tin");
                            try{
                            String cpath;

                            if (path.lastIndexOf("/")>=path.length()-1)
                                 cpath=path + fileNameD;
                            else
                                 cpath=path + "/" + fileNameD;
                            System.out.println(cpath);

                            BufferedInputStream bis;
                            bis=new BufferedInputStream (new FileInputStream(cpath));

                            byte buf[]=new byte[bis.available()];

                            BufferedOutputStream bos;
                            bos=new BufferedOutputStream(new_s.getOutputStream());
                            bos.write(bis.read(buf));
                            System.out.println("da goi du lieu tap tin ve cho client");
                            bos.flush();

                            Scanner scRequest=new Scanner(new_s.getInputStream());
                            String cmdRequest=scRequest.nextLine();
                            System.out.println("da nhan dap tra tu server");
                            if(cmdRequest.equals("DANHAN"))
                                System.out.println("Đã gửi tập tin thành công");
                            else
                                System.out.println("Gửi tập tin thất bại");
                            }catch(Exception e){
                            System.out.println(e);
                            }
                            break;
                        case THOAT:
                            lap=false;
                            break;
                    }
                }
                new_s.close();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
     
}

    public static int laLenh(String cmd){
        if(cmd.equals("DANGNHAP"))
            return DANGNHAP;
        if(cmd.equals("UPLOAD"))
            return UPLOAD;
        if(cmd.equals("DOWLOAD"))
            return DOWNLOAD;
        return KHONGLALENH;
    }

}
   
