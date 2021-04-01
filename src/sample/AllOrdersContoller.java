package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static sample.Main.allOrder;
import static sample.Main.currentOrder;

/**
 * Used to represent Controller for all orders GUI
 * @author Malav Doshi and Herik Patel
 */
public class AllOrdersContoller {
    /**
     * Used to add values to Listview
     */
    @FXML
    private ListView orderList;
    /**
     * Button for the GUI
     */
    @FXML
    private Button add,change;

    public void initialize(){
        addToAllOrders();
        currentOrder.clearAll();
        ArrayList<String> temp = allOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(temp));
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
        str=str+"Total Amount = "+currentOrder.getTotalWithTax()+"\n";
        allOrder.add(str);
    }

    /**
     * Used to export all orders to a file
     */
    public void fileExport() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save File");
        File file = chooser.showSaveDialog(new Stage());
        if(file == null){
            return ;
        }
        String path = file.getAbsolutePath();
        exportDatabase(path);
    }

    /**
     * Writes all data to a given file
     * @param path Destination where the file is stored
     */
    private void exportDatabase(String path){

        if(path == null){
            return;
        }

        File myObj = new File(path);
        ArrayList<String> temp = allOrder.makeAL();
        try {
            FileWriter myWriter = new FileWriter(path);
            for(int i = 0; i <temp.size() ; i++)
            {
                myWriter.write(temp.get(i));
                myWriter.write('\n');

            }
            myWriter.close();
        }
        catch (IOException e) {
        }

    }

    /**
     * Used to remove data from storeOrder
     */
    public void remove(){
        if(orderList.getSelectionModel().getSelectedItem() == null){
            return;
        }
        String index = ""+orderList.getSelectionModel().getSelectedIndex();
        allOrder.remove(index);
        addToAllOrders();
        ArrayList<String> temp = allOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(temp));
    }

    /**
     * Used to navigate back to main screen
     * @throws Exception throws Scene not found exception
     */
    public void MainScreen()throws Exception{
        Stage stage=(Stage) add.getScene().getWindow();
        stage.close();
    }

}
