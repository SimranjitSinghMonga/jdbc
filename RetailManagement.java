/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailmanagement;

import java.io.*;
import java.sql.*;

public class RetailManagement {

   
    public static void main(String[] args)throws IOException,SQLException {
        String cid,cname,cproduct;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Customer ID ");
        cid=br.readLine();
        System.out.print("Enter Name : ");
        cname=br.readLine();
        System.out.print("Enter Product ");
        cproduct=br.readLine();
        String uri="jdbc:derby://localhost:1527/sample";
        String uid="app";
        String pass="app";
        Connection conn=DriverManager.getConnection(uri,uid,pass);
        PreparedStatement stat=conn.prepareStatement("insert into Retail values(?,?,?)");
        stat.setString(1,cid);
        stat.setString(2,cname);
        stat.setString(3,cproduct);
        stat.executeUpdate();
        System.out.println("Your data saved successfully");
        
        
    }
}
