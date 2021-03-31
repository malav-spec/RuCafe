package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;



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
            Parent root = FXMLLoader.load(getClass().getResource("CurrentOrder.fxml"));
            Stage window=(Stage) orderCoffee.getScene().getWindow();
            Scene scene = new Scene(root, 750, 600);
            scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
            window.setScene(scene);
            window.show();
        }
        else if(ordersBox.getValue().equals("Previous Orders")){
            Parent root = FXMLLoader.load(getClass().getResource("AllOrders.fxml"));
            Stage window=(Stage) orderCoffee.getScene().getWindow();
            Scene scene = new Scene(root, 750, 600);
            scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
            window.setScene(scene);
            window.show();
        }
    }

    /**
     * Used to go to Coffee GUI
     * @throws Exception Throws scene not found exception
     */
    public void goToCoffee()throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Coffee.fxml"));
        Stage window=(Stage) orderCoffee.getScene().getWindow();
        Scene scene = new Scene(root, 750, 600);
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }
    /**
     * Used to go to Donut GUI
     * @throws Exception Throws scene not found exception
     */
    public void goToDonut()throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Donut.fxml"));
        Stage window=(Stage) orderDonut.getScene().getWindow();
        Scene scene = new Scene(root, 750, 600);
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

}
