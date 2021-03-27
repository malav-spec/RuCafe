package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Donuts;

import java.util.ArrayList;

public class DonutController {

    Donuts donutOrder = new Donuts();

    @FXML
    private ComboBox flavorBox;

    @FXML
    private ComboBox typeBox;

    @FXML
    private Spinner quantSpinner;

    @FXML
    private Button add, remove;

    @FXML
    private ListView orderList;

    @FXML
    private TextField subtotal;

    private final String[] yeastFlavors = {"Strawberry-Filled","Cinnamon","Chocolate-Frosted"};
    private final String[] holesFlavors = {"Jelly", "Marble-Frosted", "Apple-Crumb", "Boston Kreme"};
    private final String[] cakeFlavors = {"Blueberry","Classic Glazed","Maple Bacon","Red Velvet","Mint Chocolate","Hibiscus"};

    private final ArrayList<String> orders = new ArrayList();


    @FXML
    public void getTotal(){

        subtotal.clear();
        subtotal.setEditable(false);
        String donutType = (String)typeBox.getValue();
        donutOrder.setType(donutType);

        if(donutType.equals("Yeast Donut")){
            flavorBox.setItems(FXCollections.observableArrayList(yeastFlavors));
        }
        else if(donutType.equals("Cake Donut")){
            flavorBox.setItems(FXCollections.observableArrayList(cakeFlavors));
        }
        else if(donutType.equals("Donut Holes")){
            flavorBox.setItems(FXCollections.observableArrayList(holesFlavors));
        }

        donutOrder.setQuantity((Integer)quantSpinner.getValue());
        subtotal.setText(donutOrder.toString());
    }

    @FXML
    public void addToList(){
        orders.add(donutOrder.getDonutDetails());
        orderList.setItems(FXCollections.observableArrayList(orders));

    }

    @FXML
    public void setFlavor(){
        donutOrder.setFlavor((String)flavorBox.getValue());
    }

    @FXML
    public void removeFromList(){

        String removeOrder = orderList.getSelectionModel().getSelectedItem().toString();
        orders.remove(removeOrder);
        orderList.setItems(FXCollections.observableArrayList(orders));
    }

}
