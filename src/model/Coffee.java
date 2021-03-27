package model;

import javafx.fxml.FXML;

public class Coffee extends MenuItem implements Customizable{

    private String size = "";
    private int num_add_in = 0;
    private String[] addIn = new String[5];//List for all the addIn

    public void increaseAddOn(String add){
        addIn[num_add_in] = add;
        num_add_in += 1;
    }

    public String[] getAddInList(){
        return addIn;
    }

    public String getSize(){
        return size;
    }

    public int getNum_add_in(){
        return num_add_in;
    }

    public void setSize(String s){
        size = s;
    }

    public void setAddOn(int num){
        num_add_in = num;
    }

    public double roundOff(double number){ //rounds off a number to two decimal places
        return Math.round(number * 100.0) / 100.0;
    }

    public double calculate(){

        double size_price = 0;

        if(size.equals("Short")){
            size_price = 1.99;
        }
        else if(size.equals("Tall")){
            size_price = 2.49;
        }
        else if(size.equals("Grande")){
            size_price = 2.99;
        }
        else if(size.equals("Venti")){
            size_price = 3.49;
        }

        double add_in_cost = (0.2)*(num_add_in);

        return size_price + add_in_cost;
    }


    @Override
    public String toString(){
        return "$"+roundOff(calculate());
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
