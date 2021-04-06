package GUI;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static GUI.Main.allOrder;
import static GUI.Main.currentOrder;

/**
 * Used to represent Controller for Current order GUI
 * @author Malav Doshi and Herik Patel
 */

public class OrderController {
    /**
     * Represents Button for GUI
     */
    @FXML
    private Button add;
    /**
     * Represents Text field for GUI
     */
    @FXML
    private TextField totalBox;
    /**
     * Represents Listview for GUI
     */
    @FXML
    private ListView orderList;

    /**
     * Constructor for class OrderController
     */
    public OrderController(){

    }

    /**
     * Used to show data in Listview
     */
    public void initialize(){
        ArrayList<String> strList=currentOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(strList));
        totalBox.appendText("Total amount= $"+currentOrder.getTotalWithTax());
    }

    /**
     * Used to close the current window and show previous
     */
    public void show(){
        addToAllOrders();
        currentOrder.clearAll();
        Stage stage=(Stage) add.getScene().getWindow();
        stage.close();
    }

    /**
     * Used to add data to stores order
     */
    private void addToAllOrders(){
        ArrayList<String> temp = currentOrder.makeAL();
        String str = "";
        for(int i=0;i<temp.size();i++){
            str=str+temp.get(i)+"\n";
        }
        if(currentOrder.getTotal()==0.0)
            return;
        str=str+"Total Amount = $"+currentOrder.getTotalWithTax()+"\n";
        allOrder.add(str);
    }

    /**
     * Used to navigate to Donut scene
     * @throws Exception throws scene not found exception
     */
    public void addDonut() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Donut.fxml"));
        Stage window=(Stage) add.getScene().getWindow();
        Scene scene = new Scene(root, 750, 600);
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    /**
     * Used to navigate to Coffee scene
     * @throws Exception throws scene not found exception
     */
    public void addCoffee() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Coffee.fxml"));
        Stage window=(Stage) add.getScene().getWindow();
        Scene scene = new Scene(root, 750, 600);
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    /**
     * Used to remove items from Order
     */
    public void remove(){
        if(orderList.getSelectionModel().getSelectedItem() == null){
            return;
        }
        String index = ""+orderList.getSelectionModel().getSelectedIndex();
        String removeItem= orderList.getSelectionModel().getSelectedItem().toString();
        updateTotal(removeItem);
        currentOrder.remove(index);
        ArrayList<String> strList=currentOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(strList));
        totalBox.setText(""+currentOrder.getTotalWithTax());

    }

    /**
     * Used to Update total amount of Money
     * @param str Order as String
     */
    private void updateTotal(String str){
        StringTokenizer st = new StringTokenizer(str, ",");
        String amountInString="";
        while(st.hasMoreTokens()){
            amountInString=st.nextToken();
        }
        Double amount = Double.parseDouble(amountInString);
        currentOrder.setTotal(currentOrder.getTotal()-amount);
    }

}
