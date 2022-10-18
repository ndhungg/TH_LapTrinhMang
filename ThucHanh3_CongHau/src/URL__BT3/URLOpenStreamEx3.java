/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URL__BT3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Admin
 */
public class URLOpenStreamEx3 {
     public static void main(String[] args) throws MalformedURLException{
        String s="https://www.zingnews.vn";
        String thisLine;
        try {
            URL u= new URL(s);
            try {
                DataInputStream dis=new DataInputStream(u.openStream());
                GZIPInputStream de= new GZIPInputStream(dis);
                InputStreamReader derd = new InputStreamReader(de);
                BufferedReader br= new BufferedReader(new InputStreamReader(de));
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

    private static boolean URLEncoder(String thisLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
