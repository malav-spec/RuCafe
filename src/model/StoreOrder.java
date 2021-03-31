package model;

import java.util.ArrayList;

public class StoreOrder implements Customizable{
    /**
     * Used to represent Order Number
     */
    private int orderNumber = 0;
    /**
     * Used to Represent Arraylist that stores all previous orders
     */
    private ArrayList<String> orders = new ArrayList();

    /**
     * Used to Add a order to array list
     * @param obj Order which we want to add
     * @return True if order was added successfully
     */
    @Override
    public boolean add(Object obj) {
        orderNumber++;
        String ord = (String) obj;
        orders.add(ord);
        return true;
    }

    /**
     * Used to Return strung arraylist of orders
     * @return Arraylist of String
     */
    public ArrayList<String> makeAL(){
    return orders;
    }

    /**
     * Used to remove order from the list
     * @param obj Which we want to remove
     * @return True if order was removed successfully
     */
    @Override
    public boolean remove(Object obj) {
        orderNumber--;
        orders.remove(Integer.parseInt(obj.toString()));
        return true;
    }
}
