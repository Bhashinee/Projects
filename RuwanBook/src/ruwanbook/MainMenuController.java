package ruwanbook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author rukshani
 */
public class MainMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {      
    }    
    
    @FXML
    public void productStatus(){        
       try{
            Parent root1 = FXMLLoader.load(getClass().getResource("Product.fxml"));           
            Scene scene = new Scene(root1);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
    
    public void supplierStatus(){        
       try{
            Parent root1 = FXMLLoader.load(getClass().getResource("Supplier.fxml"));           
            Scene scene = new Scene(root1);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
    
    public void customerStatus(){        
       try{
            Parent root1 = FXMLLoader.load(getClass().getResource("Customer.fxml"));           
            Scene scene = new Scene(root1);            
            RuwanBook.getStage().setTitle("easyCash");
            RuwanBook.getStage().setScene(scene);  
            RuwanBook.getStage().show();
          }catch(Exception e){}
    }
}
