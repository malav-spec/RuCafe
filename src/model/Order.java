package model;

import java.awt.*;
import java.util.ArrayList;

public class Order implements Customizable{

    private int orderNumber;
    ArrayList<MenuItem> itemsList = new ArrayList();

    @Override
    public boolean add(Object obj) {

        if(obj instanceof Coffee){
            MenuItem coffeeItem = (MenuItem) obj;
            itemsList.add(coffeeItem);
            return true;
        }
        else if(obj instanceof Donuts){
            MenuItem donutItem = (MenuItem) obj;
            itemsList.add(donutItem);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {

        if(obj instanceof Coffee){
            MenuItem coffeeItem = (MenuItem) obj;
            itemsList.remove(coffeeItem);
            return true;
        }
        else if(obj instanceof Donuts){
            MenuItem donut = (MenuItem) obj;
            itemsList.remove(donut);
            return true;
        }
        return false;
    }
}
