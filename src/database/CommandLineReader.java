package database;

import model.BulkProduct;
import model.Product;
import repository.BulkProductRepository;
import repository.ProductRepository;
import service.Checkout;

import java.util.List;

// class that is used to mock a database
// in other words where setting of prices
// occurs (basic CSV style)

public class CommandLineReader {

    private ProductRepository productRepository;
    private BulkProductRepository bulkProductRepository;

    public CommandLineReader(ProductRepository productRepository, BulkProductRepository bulkProductRepository){
        this.bulkProductRepository = bulkProductRepository;
        this.productRepository = productRepository;
    }

    private boolean isBulkProduct(String str){
        return str.matches("[a-zA-Z0-9]+,[0-9]+,[0-9]+,[0-9]+");
    }

    private boolean isValidProduct(String str){
        boolean productRegex = str.matches("[a-zA-Z0-9]+,[0-9]+");


        return productRegex || isBulkProduct(str);
    }

    private void addProduct(String str) throws IllegalArgumentException{

        if(!isValidProduct(str)){
            throw new IllegalArgumentException("Invalid item. Must match {name,price} or {name,price,bulkPrice" +
                    ", bulkRequirement}");
        }

        String[] product = str.split(",");

        if(isBulkProduct(str)){
            bulkProductRepository.save(new BulkProduct(product[0],
                    Integer.parseInt(product[1]),Integer.parseInt(product[2]),Integer.parseInt(product[3])));
        }
        else{
            productRepository.save(new Product(product[0],Integer.parseInt(product[1])));
        }
    }

    public void seedProducts(List<String> products){
        for(String product: products){
            try{
                addProduct(product);
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    public String generateOrder(List<String> order){
        Checkout checkout = new Checkout(bulkProductRepository, productRepository);

        return checkout.generateOrder(order);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public BulkProductRepository getBulkProductRepository() {
        return bulkProductRepository;
    }
}
