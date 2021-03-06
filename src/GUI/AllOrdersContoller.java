package GUI;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static GUI.Main.allOrder;

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
     * Constructor for class AllOrdersContoller
     */
    public AllOrdersContoller(){

    }

    /**
     * Used to display values in the listview
     */
    public void initialize(){
        ArrayList<String> temp = allOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(temp));
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
        ArrayList<String> temp = allOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(temp));
    }


}
