package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.util.ArrayList;

import static sample.Main.allOrder;
import static sample.Main.currentOrder;

public class AllOrdersContoller {
    @FXML
    private ListView orderList;

    @FXML
    private Button add,change;

    public void show(){

        addToAllOrders();
        currentOrder.clearAll();
        ArrayList<String> temp = allOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(temp));
    }

    private void addToAllOrders(){
        ArrayList<String> temp = currentOrder.makeAL();
        String str = "";
        for(int i=0;i<temp.size();i++){
            str=str+temp.get(i)+"\n";
        }
        if(currentOrder.getTotal()==0.0)
            return;
        str=str+"Total Amount = "+currentOrder.getTotal()+"\n";
        allOrder.add(str);
    }

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
    public void MainScreen()throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window=(Stage) change.getScene().getWindow();
        Scene scene = new Scene(root, 750, 600);
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

}
