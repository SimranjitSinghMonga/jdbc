/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateRecord {
     public static void main(String[] args)throws IOException,SQLException {
        String cid,cname;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Customer ID ");
        cid=br.readLine();
        System.out.print("Enter Name Name :");
        cname=br.readLine();
        
       
        String uri="jdbc:derby://localhost:1527/sample";
        String uid="app";
        String pass="app";
        Connection conn=DriverManager.getConnection(uri,uid,pass);
        PreparedStatement stat=conn.prepareStatement("update retail set cname=? where CId=?");
        stat.setString(1,cname);
        stat.setString(2,cid);
        stat.executeUpdate();
        System.out.println("Record updated");
        
        
    }
}
