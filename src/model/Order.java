package model;

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
    }

    public ArrayList<String> makeAL() {
        ArrayList<String> orders = new ArrayList();
        for(int i=0;i<itemsList.size();i++)
        {
            orders.add(toString(itemsList.get(i)));
        }
        return orders;
    }

    public void clearAll(){
        itemsList.clear();
        this.total=0.0;
    }

    public Order cloneOrder(Order ord) throws CloneNotSupportedException {
        return (Order) ord.clone();
    }


}
