package ruwanbook;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rukshani
 */
public class connection {
    public static Connection getcon(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            System.out.println("ok1");
            String dbURL = "jdbc:derby://localhost:1527/contact;create=true";
            //Connect and create a database if not exist in the memory:
            String user = "rukshani";
            String password = "rukshani";
            Connection con = DriverManager.getConnection(dbURL,user,password);
            System.out.println("ok2");
            return con;
            
        } catch (Exception ex) {
            System.out.println("not ok "+ex);
        }
        return null;        
    }
}
