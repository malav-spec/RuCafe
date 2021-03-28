package model;

public class MenuItem {


    private Double price;

    public MenuItem(){
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

}
