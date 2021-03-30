package model;

import java.awt.*;
import java.util.ArrayList;

public class Order implements Customizable {

    private int orderNumber;
    private double total=0;
    ArrayList<MenuItem> itemsList = new ArrayList();

    public String toString(Object obj){
        if (obj instanceof Coffee) {
            MenuItem coffeeItem = (MenuItem) obj;
            return coffeeItem.getDetails();
        } else if (obj instanceof Donuts) {
            MenuItem donutItem = (MenuItem) obj;
            return donutItem.getDetails();
        }
        return "";
    }

    public double getTotal() {
        return total;
    }
     public void setTotal(double total){
        this.total=total;
     }

    @Override
    public boolean add(Object obj) {

        if (obj instanceof Coffee) {
            MenuItem coffeeItem = (MenuItem) obj;
            itemsList.add(coffeeItem);
            return true;
        } else if (obj instanceof Donuts) {
            MenuItem donutItem = (MenuItem) obj;
            itemsList.add(donutItem);
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Object obj) {
        System.out.println(obj.toString());
        System.out.println(Integer.parseInt(obj.toString()));
        itemsList.remove(Integer.parseInt(obj.toString()));
        return true;
        /*
        if (obj instanceof Coffee) {
            MenuItem coffeeItem = (MenuItem) obj;
            int index = find(coffeeItem);
            itemsList.remove(index);
            return true;
        } else if (obj instanceof Donuts) {
            MenuItem donut = (MenuItem) obj;
            int index = find(donut);
            itemsList.remove(index);
            return true;
        }
        return false;*/
    }

    public ArrayList<String> makeAL() {
        ArrayList<String> orders = new ArrayList();
        for(int i=0;i<itemsList.size();i++)
        {
            orders.add(toString(itemsList.get(i)));
        }
        return orders;
    }

    private int find(MenuItem obj) {
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i).getType().equals(obj.getType())) {
                if (itemsList.get(i).getFlavor().equals(obj.getFlavor())) {
                    System.out.println(itemsList.get(i).getPrice());
                    System.out.println(obj.getPrice());
                    if (itemsList.get(i).getPrice().equals(obj.getPrice())) {
                        if (itemsList.get(i).getQuantity() == obj.getQuantity()) {
                            return i;
                        }
                    }
                }
            }
        }
        return -1;

    }
}
