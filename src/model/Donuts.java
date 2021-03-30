package model;

import java.util.ArrayList;

public class Donuts extends MenuItem implements Customizable{

    private String type= "";
    private int quantity = 0;
    private String flavor= "";
    private ArrayList<Donuts> donutList = new ArrayList<>();

    public Donuts(Double price, String type, String flavor, int quantity){
        super(price);
        this.type = type;
        this.flavor = flavor;
        this.quantity = quantity;
    }

    public Donuts(){
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double roundOff(double number){ //rounds off a number to two decimal places
        return Math.round(number * 100.0) / 100.0;
    }

    public double itemPrice(){

        double price_type = 0;

        if(this.type.equals("Yeast Donut") || this.type.equals("YeastDonut")){
            price_type = 1.39;
        }
        else if(this.type.equals("Cake Donut") || this.type.equals("CakeDonut")){
            price_type = 1.59;
        }
        else if(this.type.equals("Donut Holes") || this.type.equals("DonutHoles")){
            price_type = 0.33;
        }

        super.setPrice(roundOff(price_type * this.quantity));

        return roundOff(price_type * quantity);
    }

    @Override
    public String getDetails(){
        return type + ", " + flavor + ", " + quantity  + ", " + itemPrice();
    }

    @Override
    public String toString(){
        return "$"+itemPrice();
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof Donuts){
            Donuts donut = (Donuts) obj;
            donutList.add(donut);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
