package model;

public class Donuts extends MenuItem implements Customizable{

    private String type= "";
    private int quantity = 0;
    private String flavor= "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double roundOff(double number){ //rounds off a number to two decimal places
        return Math.round(number * 100.0) / 100.0;
    }

    public double calculate(){

        double price_type = 0;

        if(type.equals("Yeast Donut")){
            price_type = 1.39;
        }
        else if(type.equals("Cake Donut")){
            price_type = 1.59;
        }
        else if(type.equals("Donut Holes")){
            price_type = 0.33;
        }
        return roundOff(price_type * quantity);
    }

    public String getDonutDetails(){
        return type + ", " + flavor + " (" + quantity + ")";
    }

    @Override
    public String toString(){
        return "$"+calculate();
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
