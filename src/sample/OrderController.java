package sample;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Donuts;

import java.util.ArrayList;

import static sample.Main.currentOrder;


public class OrderController {
    @FXML
    private Button add;
    @FXML
    private TextField subtotal, totalBox;
    @FXML
    private ListView orderList;

    public void dowork(){
        currentOrder.add(makeDonutObject(2.2));
        currentOrder.add(makeDonutObject2(2.9));
        currentOrder.add(makeDonutObject(2.2));
        currentOrder.add(makeDonutObject2(2.9));
        currentOrder.add(makeDonutObject(2.2));
        currentOrder.add(makeDonutObject2(2.9));
        currentOrder.add(makeDonutObject(2.2));
        currentOrder.add(makeDonutObject2(2.9));
        ArrayList<String> strList=currentOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(strList));
    }

    public void remove(){
        if(orderList.getSelectionModel().getSelectedItem() == null){
            return;
        }
        String removeOrder = orderList.getSelectionModel().getSelectedItem().toString();
        Donuts newDonut= new Donuts();
        String index = ""+orderList.getSelectionModel().getSelectedIndex();
        currentOrder.remove(index);
        ArrayList<String> strList=currentOrder.makeAL();
        orderList.setItems(FXCollections.observableArrayList(strList));


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
