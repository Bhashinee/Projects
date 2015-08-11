/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author rukshani
 */
public class CustomerController implements Initializable {
     @FXML private TextField tf_cusid;
     @FXML private TextField tf_cusname;
     @FXML private TextField tf_cusaddress;
     @FXML private TextField tf_cusphone;
     String cusid;
     String cusname;
     String cusaddress;
     String cusphone;
     int int_cusid;
     int int_cusphone;
     connect con=new connect();

    public void add(){
        cusid=tf_cusid.getText();
        cusname=tf_cusname.getText();
        cusaddress=tf_cusaddress.getText();
        cusphone=tf_cusphone.getText();
        System.out.println("add id:"+cusid+" name:"+cusname+" add:"+cusaddress+" phone:"+cusphone);    
        int_cusid= Integer.parseInt(cusid);
        int_cusphone= Integer.parseInt(cusphone);        
        con.insertCustomer(int_cusid, cusname, cusaddress, int_cusphone);
       //con.insertCustomer(1, "nilak", "nilaadd", 037);
    }
    public void update(){
        con.updateCustomer(int_cusid, cusname, cusaddress, int_cusphone);
    }
    public void delete(){        
        System.out.println("delete id:"+cusid+" name:"+cusname+" add:"+cusaddress+" phone:"+cusphone);
        con.deleteCustomer(int_cusid);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
        @FXML
    public void backToMainMenu(){
         try{
            Parent root1 = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));           
            Scene scene = new Scene(root1);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
}
