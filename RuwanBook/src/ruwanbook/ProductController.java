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
public class ProductController implements Initializable {

    
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
