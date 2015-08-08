
package ruwanbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Bhashi
 */
public class supplyDetails {

    private static String dbURL = "jdbc:derby://localhost:1527/InventoryControl;create=true;";
    private static String tableName = "SUPPLIER";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
     public static final ObservableList names = 
        FXCollections.observableArrayList();
    public static final ObservableList data = 
        FXCollections.observableArrayList();

    public static void main(String[] args) {
        createConnection();
        //insertSupplier("D1", "bhash" , "Horana" , 12, "bhashi");
        selectRestaurants();
      
        shutdown();
        list();
    }

    private static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private static void insertSupplier(String id, String name, String address, int phone, String company) {
        try {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values ("
                    + id + ",'" + name + "','" + address + "','" + phone + "','" + company + "')");
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    private static void selectRestaurants() {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i) + "\t\t");
            }

            System.out.println("\n-------------------------------------------------------------------------");

            while (results.next()) {
                String ID = results.getString(1);
                String name = results.getString(2);
                String address = results.getString(3);
                int phone = results.getInt(4);
                String company = results.getString(5);

                System.out.println(ID + "\t\t" + name + "\t\t" + address + "\t\t" + phone + "\t\t" + company);
             
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    private static void shutdown() {
      
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {

        }

    }

    private static void list() {
        
        System.out.println("listview");
        //primaryStage.setTitle("List View Sample");        
        
        final ListView listView = new ListView(data);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);
        
        names.addAll(
             "Adam", "Alex", "Alfred", "Albert",
             "Brenda", "Connie", "Derek", "Donny", 
             "Lynne", "Myrtle", "Rose", "Rudolph", 
             "Tony", "Trudy", "Williams", "Zach"
        );
         
        for (int i = 0; i < 18; i++) {
            data.add(i);
        }
          
        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(names));              
               
        StackPane root = new StackPane();
        root.getChildren().add(listView);
        //primaryStage.setScene(new Scene(root, 200, 250));
        //primaryStage.show();
    
    }
    
    

    
}
