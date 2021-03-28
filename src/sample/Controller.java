package sample;


import com.sun.javafx.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ChoiceBox ordersBox;

    @FXML
    private Button orderCoffee;

    private void loadSceneAndSendMessage(){

    }

    @FXML
    public void goToCoffeeTab(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Coffee.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 750, 600);
            scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("Order Coffee");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToDonutTab(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Donut.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 750, 600);
            scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("Order Donuts");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
