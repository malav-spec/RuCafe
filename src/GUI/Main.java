package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Order;
import model.StoreOrder;

/**
 * Main class to run the Application
 *@author Malav Doshi and Herik Patel
 */
public class Main extends Application {
    /**
     * Represent current order in the cart
     */
    public static Order currentOrder = new Order();
    /**
     * Represent All previous orders
     */
    public static StoreOrder allOrder = new StoreOrder();

    /**
     * Constructor for class Main
     */
    public Main(){

    }

    /**
     * Method to run the GUI initially
     * @param primaryStage Primary Stage which will be displayed initially
     * @throws Exception Scene not found Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Order Items");
        Scene scene = new Scene(root, 750, 600);
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Main Method for the class
     * @param args Not required
     */
    public static void main(String[] args) {
        launch(args);
    }
}
