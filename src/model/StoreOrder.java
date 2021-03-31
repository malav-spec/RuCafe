package model;

import java.util.ArrayList;

public class StoreOrder implements Customizable{

    private ArrayList<String> orders = new ArrayList();
    private int numOrders;

    @Override
    public boolean add(Object obj) {

        String ord = (String) obj;
        orders.add(ord);
        return true;
    }

    public ArrayList<String> makeAL(){
    return orders;
    }

    @Override
    public boolean remove(Object obj) {
        orders.remove(Integer.parseInt(obj.toString()));
        return true;
    }
}
