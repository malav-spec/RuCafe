package sample;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Donuts;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static sample.Main.currentOrder;

public class OrderController {
    @FXML
    private Button add;
    @FXML
    private TextField subtotal, totalBox;
    @FXML
    private ListView orderList;

    public void dowork(){
        ArrayList<String> strList=currentOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(strList));
        totalBox.setText(""+currentOrder.getTotal());
    }
    public void addDonut() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Donut.fxml"));
        Stage window=(Stage) add.getScene().getWindow();
        window.setScene(new Scene(root,750,500));
    }

    public void addCoffee() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Coffee.fxml"));
        Stage window=(Stage) add.getScene().getWindow();
        window.setScene(new Scene(root,750,500));
    }

    public void remove(){
        if(orderList.getSelectionModel().getSelectedItem() == null){
            return;
        }
        String removeOrder = orderList.getSelectionModel().getSelectedItem().toString();
        Donuts newDonut= new Donuts();
        String index = ""+orderList.getSelectionModel().getSelectedIndex();
        String removeItem= orderList.getSelectionModel().getSelectedItem().toString();
        updateTotal(removeItem);
        currentOrder.remove(index);
        ArrayList<String> strList=currentOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(strList));
        totalBox.setText(""+currentOrder.getTotal());



    }
    private void updateTotal(String str){
        StringTokenizer st = new StringTokenizer(str, ",");
        String amountInString="";
        while(st.hasMoreTokens()){
            amountInString=st.nextToken();
        }
        Double amount = Double.parseDouble(amountInString);
        currentOrder.setTotal(currentOrder.getTotal()-amount);
    }

    private Donuts makeDonutObject(double price){
        Donuts newDonut= new Donuts();
        newDonut.setFlavor("Strawberry-Filled");
        newDonut.setPrice(price);
        newDonut.setQuantity(1);
        newDonut.setType("Yeast Donut");
        return newDonut;
    }
    private Donuts makeDonutObject2(double price){
        Donuts newDonut= new Donuts();
        newDonut.setFlavor("Strawberry-Filled");
        newDonut.setPrice(price);
        newDonut.setQuantity(12);
        newDonut.setType("Yeast Donut");
        return newDonut;
    }
}
