/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BT1;

/**
 *
 * @author TienDat
 */
public class Main {
    public static void main(String[] args) {
        QLUser ql= new  QLUser(100);
        
        frmMain obj = new frmMain(ql);
        obj.setVisible(true);
    }
    
}
