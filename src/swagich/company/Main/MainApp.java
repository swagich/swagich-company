/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Sam
 * 
 */
public class MainApp extends Application {

    Stage window;
    public double xOffset, yOffset;
    @Override
    public void init(){
        System.out.println("App loading resources");
    }
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        Parent root = FXMLLoader.load(getClass().getResource("MainAppView.fxml"));
        Image icon = new Image(MainApp.class.getResourceAsStream("Images/company2.png"));
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.getIcons().add(icon);
        window.show();

    }

}
