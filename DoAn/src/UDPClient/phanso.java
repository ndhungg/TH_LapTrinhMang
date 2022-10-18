/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class phanso implements Serializable{
    private int tuso; 
    private int mauso; 
    public phanso (boolean a) {
        tuso = (int) (Math.random() *100); 
        do{
            mauso = (int) (Math.random() * 100); 
        } while (mauso==0);
    }
   public phanso (){
        tuso = (int) (Math.random() *100); 
        do{
            mauso = (int) (Math.random() *100); 
        }while (mauso==0);
    }
    public phanso(int tuso, int mauso) {
        this.tuso = tuso; 
        if (mauso==0) {
            mauso = 1;
        }else{
            this.mauso= mauso;
        }
    }
    String temp;
    public String toString() {
        temp= tuso+"/"+mauso;
         return temp;
    }

}
