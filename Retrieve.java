/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailmanagement;

/**
 *
 * @author Simranjit
 */
import java.io.*;
import java.sql.*;
public class Retrieve {
   public static void main(String[] args) throws IOException,SQLException
   {
       String cid;
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter Customer Id : ");
       cid=br.readLine();
        String uri="jdbc:derby://localhost:1527/sample";
        String uid="app";
        String pass="app";
        Connection conn=DriverManager.getConnection(uri,uid,pass);
        PreparedStatement stat=conn.prepareStatement("Select * from Retail where CID=?");
        stat.setString(1,cid);
        ResultSet rs=stat.executeQuery();
        System.out.println("ID \t Name \t Product");
        while(rs.next())
        {
          System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        }
   }
}
