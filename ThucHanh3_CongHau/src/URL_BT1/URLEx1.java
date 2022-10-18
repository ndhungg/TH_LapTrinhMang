/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URL_BT1;
import java.net.*;
/**
 *
 * @author Admin
 */
public class URLEx1 {
    public static void main(String[] args){
            try{
            URL u = new URL("http://www.poly.edu/fall97/grad.php?q=idx#cs");
            System.out.println("The protocol is:" +u.getProtocol());
            System.out.println("The host is:" +u.getHost());
            System.out.println("The port is:" +u.getPort());
            System.out.println("The file is:" +u.getFile());
            System.out.println("The anchor is:" +u.getRef());
            System.out.println("The query is:" +u.getQuery());
        }catch(MalformedURLException e){
    
        }
    }

}
