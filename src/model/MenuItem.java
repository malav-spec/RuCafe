package model;

public class MenuItem {


    private Double price;

    public MenuItem(){
    }
    public String getDetails(){
    return "";
    }

    public MenuItem(Double price){
        this.price = price;
    }

    public void setPrice(Double p){
        this.price = p;
    }

    public Double getPrice(){
        return price;
    }

    public int getQuantity() {
        return 0;
    }

    public String getFlavor() {
        return null;
    }

    public String getType() {
        return null;
    }

}
