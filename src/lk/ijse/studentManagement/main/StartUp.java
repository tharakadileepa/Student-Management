/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author THARAKA
 */
public class StartUp extends Application {

    public static void navigateToHome(AnchorPane root, Stage stage) {
       
            TranslateTransition tt = new TranslateTransition(Duration.millis(300),root );
            tt.setFromX(0);
            tt.setToX(-root.getScene().getWidth());
            tt.play();
            
            Platform.runLater(()->{
            
                try {
                    Parent Root = FXMLLoader.load(StartUp.class.getResource("/lk/ijse/studentManagement/views/Main.fxml"));
                    Scene mainScene = new Scene(Root);
                    stage.setScene(mainScene);
                    
                    TranslateTransition tt1 = new TranslateTransition(Duration.millis(300), Root.lookup("AnchorPane"));
                    tt1.setToX(0);
                    tt1.setFromX(-mainScene.getWidth());
                    tt1.play();
                    
                    stage.centerOnScreen();
                } catch (IOException ex) {
                    Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
                  
                }
            
            });
    }

    @Override
    public void start(Stage primaryStage) {

        try {

            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/studentManagement/views/Main.fxml"));

            Scene mainScene = new Scene(root);

           
            primaryStage.setScene(mainScene);
          
            
            primaryStage.show();
           

        } catch (IOException ex) {
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
