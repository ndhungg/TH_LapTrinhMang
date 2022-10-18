/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesst;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class MyConnection {
    public Connection getConnection(){
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String URL = "jdbc:sqlserver://localhost:1433;Database=quanlyuser;user=haudo;password=hau";
        Connection con = DriverManager.getConnection(URL);
        return con;
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex.toString(),"Loi",JOptionPane.ERROR_MESSAGE);
        return null;
    }
}
}
