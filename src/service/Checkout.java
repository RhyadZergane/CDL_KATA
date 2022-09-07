package service;

import model.BulkProduct;
import model.Product;
import repository.BulkProductRepository;
import repository.BulkProductRepositoryImpl;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class Checkout {
    private BulkProductRepository bulkProductRepository;
    private ProductRepository productRepository;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Checkout(BulkProductRepository bulkProductRepository, ProductRepository productRepository){
        this.bulkProductRepository = bulkProductRepository;
        this.productRepository = productRepository;
    }

    private HashMap<String,Integer> getQuantity(List<String> order){
        HashMap<String,Integer> quantity = new HashMap<>();
        for(String product: order){
            if(bulkProductRepository.get(product) == null && productRepository.get(product) == null){
                System.err.println("Invalid product");
            }
            else{
                quantity.merge(product, 1, Integer::sum);
            }
        }

        return quantity;
    }

    private double calculateTotalInPounds(HashMap<String,Integer> orderQuantity){
        double total = 0;

        for(String product: orderQuantity.keySet()){
            // Item available for bulk order
            if(bulkProductRepository.get(product) != null){
                BulkProduct foundItem = bulkProductRepository.get(product);
               int quantity = orderQuantity.get(product);

               if(quantity >= foundItem.getBulkRequirement()){
                   int remainder = quantity % foundItem.getBulkRequirement();
                   int quantityAtBulkPrice = quantity / foundItem.getBulkRequirement();
                   total += (quantityAtBulkPrice * foundItem.getBulkPriceInPence()) +
                           (remainder * foundItem.getPriceInPence());
               }
               else{
                   total += quantity * foundItem.getPriceInPence();
               }
            }
            else{
                Product foundProduct = productRepository.get(product);

                total += foundProduct.getPriceInPence() * orderQuantity.get(product);
            }
        }

        return total / 100;
    }

    public String generateOrder(List<String> order){
        HashMap<String,Integer> orderQuantity = getQuantity(order);

        double total = calculateTotalInPounds(orderQuantity);

        return "Order total = £" + df.format(total);
    }
}
