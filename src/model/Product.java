package model;

public class Product {
    private String name;
    private int priceInPence;

    public Product(String name, int priceInPence){
        this.priceInPence = priceInPence;
        this.name = name;
    }

    @Override
    public String toString(){
        return name + ": " + priceInPence + "p";
    }

    public int getPriceInPence() {
        return priceInPence;
    }

    public String getName() {
        return name;
    }
}
