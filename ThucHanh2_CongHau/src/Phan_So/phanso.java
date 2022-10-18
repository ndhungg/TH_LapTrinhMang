/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phan_So;

import java.io.Serializable;

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
            mauso = (int) (Math.random() * 90+1); 
        } while (mauso==0);
    }
    public phanso () {
        tuso = (int) (Math.random() *100); 
        do{
            mauso = (int) (Math.random() *90+1); 
        }while (mauso==0);
    }
    public phanso (int tuso, int mauso) {
        this.tuso = tuso; 
        if (mauso==0) {
            mauso = 1;
        }else{
            this.mauso= mauso;
        }
    }
    public String toString() {
        return tuso+"/"+mauso;
    }
    public int getMauso() {
        return mauso;
    }
    public boolean isPrimeNumber() {
        if (this.mauso < 2) {
            return false;
        }

        int squareRoot = (int) Math.sqrt(this.mauso);
        for (int i = 2; i <= squareRoot; i++) {
            if (this.mauso % i == 0) {
                return false;
            }
        }
        return true;
    }
}
