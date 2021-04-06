package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Order;
import model.StoreOrder;

/**
 * Used for the start of the application
 * @author Malav Doshi and Herik Patel
 */
public class Main extends Application {
    public static Order currentOrder = new Order();
    public static StoreOrder allOrder = new StoreOrder();


    /**
     * Method to start the GUI window
     * @param primaryStage Stage object which is the main window for GUI
     * @throws Exception Not used
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


    public static void main(String[] args) {
        launch(args);
    }
}
