package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Used to represent Controller for Main GUI
 * @author Malav Doshi and Herik Patel
 */
public class Controller {
    /**
     * Represent Combobox for GUI
     */
    @FXML
    private ComboBox ordersBox;
    /**
     * Represent Button for GUI
     */
    @FXML
    private Button orderCoffee,orderDonut;

    private void loadSceneAndSendMessage(){

    }

    /**
     * Used choose option from Combobox
     * @throws Exception Throws scene not found exception
     */
    public void choiceOfOrder() throws Exception{
        if(ordersBox.getValue().equals("Current Order")){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CurrentOrder.fxml"));
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
        else if(ordersBox.getValue().equals("Previous Orders")){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("AllOrders.fxml"));
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

    /**
     * Used to go to Coffee GUI
     * @throws Exception Throws scene not found exception
     */
    public void goToCoffee()throws Exception{
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
    /**
     * Used to go to Donut GUI
     * @throws Exception Throws scene not found exception
     */
    public void goToDonut()throws Exception {
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
