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

/**
 * Used to represent Controller for Donut GUI
 * @author Malav Doshi and Herik Patel
 */
public class DonutController {
    /**
     * Used to represent Donut object
     */
    Donuts donutOrder = new Donuts();
    /**
     * Used to represent combo box for GUI
     */
    @FXML
    private ComboBox flavorBox;
    /**
     * Used to represent combo box for GUI
     */
    @FXML
    private ComboBox typeBox;
    /**
     * Used to represent Spinner for GUI
     */
    @FXML
    private Spinner quantSpinner;
    /**
     * Used to represent Button for GUI
     */
    @FXML
    private Button add, remove;
    /**
     * Used to represent List view for GUI
     */
    @FXML
    private ListView orderList;
    /**
     * Used to represent Text field for GUI
     */
    @FXML
    private TextField subtotal, totalBox;
    /**
     * Used to represent yeast donut flavors
     */
    private final String[] yeastFlavors = {"Strawberry-Filled","Cinnamon","Chocolate-Frosted"};
    /**
     * Used to represent donut holes flavors
     */
    private final String[] holesFlavors = {"Jelly", "Marble-Frosted", "Apple-Crumb", "Boston Kreme"};

    /**
     * Used to represent cake flavors
     */
    private final String[] cakeFlavors = {"Blueberry","Classic Glazed","Maple Bacon","Red Velvet","Mint Chocolate","Hibiscus"};

    /**
     * Used to represent Order List
     */
    private final ArrayList<String> orders = new ArrayList();
    /**
     * Used to represent Order prices
     */
    private final ArrayList<Double> orderPrices = new ArrayList<>();

    /**
     * Used to set total amount for the order
     */
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

    /**
     * Used to add items from order to list
     */
    @FXML
    public void addToList(){
        orders.add(donutOrder.getDetails());
        orderList.setItems(FXCollections.observableArrayList(orders));
        orderPrices.add(donutOrder.itemPrice());
        totalBox.setText(getSubTotal());
    }

    /**
     * Used to set flavor for donut
     */
    @FXML
    public void setFlavor(){
        donutOrder.setFlavor((String)flavorBox.getValue());
    }

    /**
     * Used to add to current order
     * @throws Exception Throws scene not found exception
     */
    @FXML
    public void addToOrder()throws Exception{
        for(int i = 0; i < orders.size(); i++){


            StringTokenizer st = new StringTokenizer(orders.get(i).replaceAll("\\s", ""), ",");
            Donuts donut = getDonutOrder(st);
            currentOrder.add(donut);
        }
        String stringTotal=getSubTotal();
        currentOrder.setTotal(currentOrder.getTotal()+Double.parseDouble(stringTotal.substring(1)));
        Stage stage=(Stage) add.getScene().getWindow();
        stage.close();


    }

    /**
     * Used to get Donut object from order
     * @param st String tokenizer
     * @return Donut object reference
     */
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

    /**
     * Used to get total for order
     * @return String value for total
     */
    public String getSubTotal(){
        int i;
        double sum = 0;

        for(i = 0; i < orderPrices.size(); i++){
            sum += orderPrices.get(i);
        }

        return "$ " + sum;
    }

    /**
     * Used to remove an item from list
     */
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
