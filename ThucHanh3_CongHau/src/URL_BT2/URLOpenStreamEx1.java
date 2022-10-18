/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URL_BT2;
import java.io.*;
import java.net.*;
/**
 *
 * @author Admin
 */
public class URLOpenStreamEx1 {
    public static void main(String[] args) throws MalformedURLException{
        String s="https://www.hutech.edu.vn";
        String thisLine;
        try {
            URL u= new URL(s);
            try {
                DataInputStream dis=new DataInputStream(u.openStream());
                BufferedReader br= new BufferedReader(new InputStreamReader(dis));
                while((thisLine = br.readLine())!=null){
                    System.out.println(thisLine);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
}
