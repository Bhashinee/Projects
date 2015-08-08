/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author rukshani
 */
public class MainController implements Initializable {
     @FXML private Text actiontarget;   
     @FXML private TextField usernameField;
     @FXML private PasswordField passwordField;
    
    @FXML
    protected void handleSubmitButtonAction() throws IOException{
        
        try {
            Statement st = connection.getcon().createStatement();
            ResultSet rs=st.executeQuery("select * from EMPLOYEE");
            String user=usernameField.getText();
            String pass=passwordField.getText();
            System.out.println("user:"+user+" pass:"+pass);
            String passdb;
            String userdb;
            
            while (rs.next()) {
                passdb=rs.getString("PASSWORD");
                userdb=rs.getString("USERNAME");
                System.out.println(passdb+" "+userdb);

                if (pass.equals(passdb)&& user.equals(userdb)) { 
                    actiontarget.setText("UserName and Password correct");                   
                    backToMainMenu();
                } else {
                   // System.out.println("UserName and Password is invalid");
                    actiontarget.setText("UserName and Password is invalid");
                }
           }
            
        } catch (SQLException ex) {
            System.out.println("ExceptionSQL"+ex);
        } 
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void backToMainMenu(){
         try{
            Parent root1 = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(root1);
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){
              System.out.println("Exceptionmenu"+e);
          }
    }
}
