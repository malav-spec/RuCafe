package model;

import java.util.ArrayList;

public class StoreOrder implements Customizable{

    private ArrayList<Order> orders = new ArrayList<>();
    private int numOrders;

    @Override
    public boolean add(Object obj) {

        if(obj instanceof Order){
            Order ord = (Order) obj;
            orders.add(ord);
            numOrders++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {

        if(obj instanceof Order){
            Order ord = (Order) obj;
            orders.remove(ord);
            numOrders--;
            return true;
        }
        return false;
    }
}
