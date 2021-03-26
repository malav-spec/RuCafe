package model;

public class Donuts extends MenuItem implements Customizable{
    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
