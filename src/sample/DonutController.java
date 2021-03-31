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
    private TextField subtotal, totalBox;

    private final String[] yeastFlavors = {"Strawberry-Filled","Cinnamon","Chocolate-Frosted"};
    private final String[] holesFlavors = {"Jelly", "Marble-Frosted", "Apple-Crumb", "Boston Kreme"};
    private final String[] cakeFlavors = {"Blueberry","Classic Glazed","Maple Bacon","Red Velvet","Mint Chocolate","Hibiscus"};

    private final ArrayList<String> orders = new ArrayList();
    private final ArrayList<Double> orderPrices = new ArrayList<>();


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
        orders.add(donutOrder.getDetails());
        orderList.setItems(FXCollections.observableArrayList(orders));
        orderPrices.add(donutOrder.itemPrice());
        totalBox.setText(getSubTotal());
    }

    @FXML
    public void setFlavor(){
        donutOrder.setFlavor((String)flavorBox.getValue());
    }

    @FXML
    public void addToOrder()throws Exception{
        for(int i = 0; i < orders.size(); i++){


            StringTokenizer st = new StringTokenizer(orders.get(i).replaceAll("\\s", ""), ",");
            Donuts donut = getDonutOrder(st);
            currentOrder.add(donut);
        }
        //addToCurrentOrder();
        String stringTotal=getSubTotal();
        currentOrder.setTotal(currentOrder.getTotal()+Double.parseDouble(stringTotal.substring(1)));
        Parent root = FXMLLoader.load(getClass().getResource("CurrentOrder.fxml"));
        Stage window=(Stage) add.getScene().getWindow();
        window.setScene(new Scene(root,750,500));


    }

/*
    private void addToCurrentOrder(){
        for(int i=0;i<orders.size();i++){
            Donuts temp = new Donuts();
            StringTokenizer st = new StringTokenizer(orders.get(i), ",");
            temp.setType(st.nextToken());
            temp.setFlavor(st.nextToken());
            temp.setQuantity(Integer.parseInt(st.nextToken()));
            currentOrder.add(temp);


        }
    }*/
    public Donuts getDonutOrder(StringTokenizer st){

        Donuts donut;
        String dType = "", dFlavor = "";
        int quantity = 0;
        double price = 0;

        while(st.hasMoreTokens()){
            dType = st.nextToken();
            dFlavor = st.nextToken();
            quantity = Integer.parseInt(st.nextToken());
            price = Double.parseDouble(st.nextToken());
        }

        donut = new Donuts(price, dType, dFlavor, quantity);
        return donut;
    }

    public String getSubTotal(){
        int i;
        double sum = 0;

        for(i = 0; i < orderPrices.size(); i++){
            sum += orderPrices.get(i);
        }

        return "$ " + sum;
    }

    @FXML
    public void removeFromList(){

        if(orderList.getSelectionModel().getSelectedItem() == null){
            return;
        }

        String removeOrder = orderList.getSelectionModel().getSelectedItem().toString();

        StringTokenizer st = new StringTokenizer(removeOrder, ",");
        st.nextToken();
        st.nextToken();
        st.nextToken();
        Double price = Double.parseDouble(st.nextToken());
        orders.remove(removeOrder);
        orderPrices.remove(price);
        orderList.setItems(FXCollections.observableArrayList(orders));
        totalBox.setText(getSubTotal());
    }

}
