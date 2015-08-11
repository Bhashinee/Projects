/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rukshani
 */
public class connect {
    private static final String customerTable = "customer";
    private static final String employeeTable = "employee";
    private static final String productTable = "product";
    private static final String supplierTable = "supplier";
    
     public static Connection getcon(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            System.out.println("ok1");
            String dbURL = "jdbc:derby://localhost:1527/Inventory;create=true";
            //Connect and create a database if not exist in the memory:
            String user = "APP";
            String password = "i";
            Connection con = DriverManager.getConnection(dbURL,user,password);
            System.out.println("ok2");
            return con;
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("not ok "+ex);
        }
        return null;        
    }
//    public void createTableCustomer() throws SQLException {
//        Statement st = connect.getcon().createStatement();
//        st.execute("CREATE TABLE "
//          + customerTable
//          + "(id INTEGER NOT NULL PRIMARY KEY, name VARCHAR(25) NOT NULL,address VARCHAR(50), phone INTEGER)");
//        System.out.println("Created table "+ customerTable);
//    }
     public void insertCustomer(int id,String name,String address, int phone){
         try {
            Statement st = connect.getcon().createStatement();
            String sqlins="INSERT INTO "+customerTable+" VALUES("+id+",\'"+name+"\',\'"+address+"\',"+phone+")";
            st.execute(sqlins);
            st.close();
            
        } catch (SQLException ex) {
            System.out.println("Insert error "+ customerTable+ ex);
        }
     }
     public void deleteCustomer(int id){
        try {
            Statement ps=connect.getcon().createStatement();
            String sqldel="DELETE FROM "+customerTable+" WHERE id="+id+"";
            ps.execute(sqldel);
            System.out.println("deleted "+id);
        } catch (SQLException ex) {
            System.out.println("Delete error "+ customerTable+ ex);
        }          
      }
     public void updateCustomer(int id,String name,String address, int phone){
        try {           
            Statement ps=connect.getcon().createStatement();
            String sqlup="UPDATE "+customerTable+" SET "
                    + "name=\'"+name+"\', address=\'"+address+"\', phone="+phone+" WHERE id="+id+"";
            ps.execute(sqlup);
            
            System.out.println("Updated "+id);
        } catch (SQLException ex) {
            System.out.println("Update error "+ customerTable+ ex);
        }   
     }
     
//    public void createTableEmployee() throws SQLException {//        
//        Statement st = connect.getcon().createStatement();
//        st.execute("CREATE TABLE "
//          + employeeTable
//          + "(username VARCHAR(25) NOT NULL PRIMARY KEY, password VARCHAR(25),name VARCHAR(25),address VARCHAR(50), phone INTEGER)");
//        System.out.println("Created table "+ employeeTable);
//    }
      public void insertEmployee(String username,String password,String name,String address,int phone){
        try {
            Statement st = connect.getcon().createStatement();
            String sqlins="INSERT INTO "+employeeTable+" VALUES(\'"+username+"\',\'"+password+"\',\'"+name+"\',\'"+address+"\',"+phone+")";
            st.execute(sqlins);
            st.close();
        } catch (SQLException ex) {
            System.out.println("Insert error "+ employeeTable+ ex);
        }
      }
      public void deleteEmployee(String username){
        try {
            Statement ps=connect.getcon().createStatement();
            String sqldel="DELETE FROM "+employeeTable+" WHERE username=\'"+username+"\'";
            ps.execute(sqldel);
        } catch (SQLException ex) {
            System.out.println("Delete error "+ employeeTable+ ex);
        }          
      }
      
//    public void createTableSupplier() throws SQLException {
//        System.out.println("fakfjqjfa");
//        Statement st = connect.getcon().createStatement();
//        st.execute("CREATE TABLE "
//          + supplierTable
//          + "(id INTEGER NOT NULL PRIMARY KEY, name VARCHAR(25), address VARCHAR(50), phone INTEGER,company VARCHAR(25))");
//        System.out.println("Created table "+ supplierTable);
//    }
//    public void createTableProduct() throws SQLException {
//        Statement st = connect.getcon().createStatement();
//        st.execute("CREATE TABLE "
//          + productTable
//          + "(serialnumber INTEGER NOT NULL PRIMARY KEY, name VARCHAR(25), description VARCHAR(75), price INTEGER,quantity INTEGER, category VARCHAR(25), brand VARCHAR(25),totalprice INTEGER, supplierId INTEGER, stocklevel INTEGER, imageurl VARCHAR(75),"
//                + "FOREIGN KEY(supplierId) REFERENCES supplier(id))");
//        System.out.println("Created table "+ productTable);
//    }
    
}
