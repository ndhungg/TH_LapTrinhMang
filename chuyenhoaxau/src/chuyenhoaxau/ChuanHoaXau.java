
package chuyenhoaxau;
import java.io.*;
import java.util.*;
 
public class ChuanHoaXau {
    private String st;
    public ChuanHoaXau(String s) {
        st=s;
    }
     
    public ChuanHoaXau() {}
     
//  Hàm nhập String từ bàn phím có sử dụng try catch
    String nhapString() {
        String x;
        DataInputStream ip = new DataInputStream(System.in);
        try {
            x=ip.readLine();
        }
        catch(Exception e) {
            System.out.println("Nhap lai!");
            x=nhapString();
        }
        return x;
    }
     
    public void nhapXau() {
        System.out.println("Nhap xau: ");
        st=nhapString();
    }
     
    public void hienThi() {
        System.out.println(st);
    }
     
// Hàm chuẩn hóa xâu
    public void chuannHoa() {
        st=st.trim().toLowerCase();
        st = st.replaceAll("\\s+", " ");
        String[] temp= st.split(" ");
        st="";
        for(int i=0;i<temp.length;i++) {
            st+=String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i<temp.length-1)
                st+=" ";
        }
    }
 
// Hàm đếm từ xuất hiện bằng kí tự T.
    public int countLetter() {
        int letter =0;
                // Kiểm tra chữ đầu tiên
        if(st.charAt(0)=='T');
            letter+=1;
        for(int i=1;i<st.length()-1;i++)
            if(st.charAt(i)==' ' && st.charAt(i+1)=='T')
                letter+=1;
        return letter;
    }
 
    public static void main(String[] args) {
        ChuanHoaXau a = new ChuanHoaXau();  // khai báo đối tượng a thuộc class ChuanHoaXau
        a.nhapXau();   /// gọi phương thức nhập
        System.out.println("Xau co "+a.demKTDB()+" ky tu db!");  // Gọi phương thức đếm KTDB
        a.chuannHoa();   // Chuẩn hóa
        System.out.println("Xau sau khi chuan hoa: ");
        a.hienThi();
 
                // Gọi hàm đếm từ xuất hiện bằng chữ 'T'
        System.out.println("Co "+a.countLetter()+" tu xuat hien bang chu T!");
    }  
     
}
