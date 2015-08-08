/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruwanbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rukshani
 */
public class RuwanBook extends Application {
    private static Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));        
        Scene scene = new Scene(root,400,400);   
        stage.setTitle("IMS");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
     public static Stage getStage(){       
        return stage;
    }
}
