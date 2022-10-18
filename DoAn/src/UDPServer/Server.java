/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPServer;
import UDPClient.phanso;
import UDPClient.frmClient;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.DefaultListModel;
/**
 *
 * @author Admin
 */
public class Server {
       public static boolean KTSNT(int n) {
         if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, Throwable {
        // TODO code application logic here
            DatagramSocket server = new DatagramSocket(8888);
            System.out.println("Server đang nghe!");
            //nhận phân số từ client
            byte mangps[] = new byte[256];           
            DatagramPacket nhanps = new DatagramPacket(mangps, mangps.length);
            server.receive(nhanps);
            String chuoips=new String(nhanps.getData(),0,nhanps.getLength()).trim();
            String test="";
            System.out.println("các phân số nhận được từ client: "+chuoips);
            //mã hóa des
            String SECRET_KEY = "12345678";
		
                SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "DES");				
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
                byte[] byteEncrypted = cipher.doFinal(chuoips.getBytes());
		String encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
                System.out.println("sau khi mã hóa: "+new String(encrypted));
                //mở file đưa mã hóa vào
                   try{
                        FileOutputStream fo = new FileOutputStream("phanso.dat"); 
                        BufferedOutputStream bo = new BufferedOutputStream (fo); 
                        ObjectOutputStream oo = new ObjectOutputStream (bo); 
                            oo.writeObject (encrypted); 
                            oo.close();
                            JOptionPane.showMessageDialog(null,"mã hóa des thành công!");
                        } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,"đã xảy ra lỗi"); 
                        }
                   //mở file lấy mã hóa ra
                     try{
                            FileInputStream fi = new FileInputStream(new File("phanso.dat")); 
                            BufferedInputStream bi = new BufferedInputStream(fi); 
                            ObjectInputStream obj = new ObjectInputStream (bi);
                              test=(String )obj.readObject();
                              obj.close();                                
                        }catch (Exception ex)
                        {
                            JOptionPane.showMessageDialog(null,"Lỗi");
                            
                        }
                //System.out.println("sau khi mã hóa: "+test);
                // giải mã des
                cipher.init(Cipher.DECRYPT_MODE, skeySpec);
                byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(test));
                String t=new String(decrypted);
                System.out.println("sau khi giải mã: " + t);
                //xử lí chuỗi
                t=t.substring(1);
                t=t.substring(0,t.length()-1);
                t=t.replaceAll("\\s","");
                System.out.println("sau khi xử lí chuỗi: "+t);
                String[] arStr = t.split("\\,");
                String guiclient="các phân số có mẫu số là SNT: ";
                String test2="";
                System.out.println("Kết quả");
                // tìm phân số có mẫu số là SNT
              //  System.out.println("tách: ");
                for (String item : arStr) {
                    item=item.substring(0); 
                 //   System.out.println(""+item);
                    if(KTSNT(Integer.parseInt(item.substring(3)))==true){ 
                          test2+=item+" ";
                    } 
		}
                System.out.println("các phân số mẫu SNT: "+test2);
                //gửi kết quả cho client
                guiclient=guiclient+test2;
                InetAddress ip = nhanps.getAddress();
                int port=nhanps.getPort();
                byte mang_ps[]=new byte[256];
                mang_ps=guiclient.getBytes();
                DatagramPacket sendps = new DatagramPacket(mang_ps, mang_ps.length,ip,port);
                server.send(sendps);
                server.close();
    }
 
}
