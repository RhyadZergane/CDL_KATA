package model;
public class BulkProduct extends Product{
    int bulkRequirement;
    int bulkPriceInPence;

    public BulkProduct(String name, int priceInPence, int bulkPriceInPence, int bulkRequirement){
        super(name,priceInPence);
        this.bulkPriceInPence = bulkPriceInPence;
        this.bulkRequirement = bulkRequirement;
    }

    @Override
    public String toString(){
        return this.getName() + ": " + this.getPriceInPence() + "p, bulk price: "
                + bulkPriceInPence + "p, bulk item requirement: " + bulkRequirement + " of this product";
    }

    public int getBulkPriceInPence() {
        return bulkPriceInPence;
    }

    public int getBulkRequirement() {
        return bulkRequirement;
    }
}
