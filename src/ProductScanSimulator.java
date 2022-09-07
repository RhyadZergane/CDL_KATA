import database.CommandLineReader;
import repository.BulkProductRepository;
import repository.BulkProductRepositoryImpl;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.Checkout;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ProductScanSimulator {

    public void simulate(String[] args){
        if(!args[0].equalsIgnoreCase("--seed") && !args[0].equalsIgnoreCase("-s")){
            throw new IllegalArgumentException("Must seed products using --seed or -s then " +
                    "give products in listed format");
        }

        int seedPointer = 1;

        List<String> seedArgs = new LinkedList<>();
        while(seedPointer < args.length && (!args[seedPointer].equals("-o") && !args[seedPointer].equals("--order")
        ) ){
            seedArgs.add(args[seedPointer]);
            seedPointer++;
        }

        ProductRepository productRepository = new ProductRepositoryImpl();
        BulkProductRepository bulkProductRepository = new BulkProductRepositoryImpl();
        CommandLineReader commandLineReader = new CommandLineReader(productRepository, bulkProductRepository);

        commandLineReader.seedProducts(seedArgs);

        if(seedPointer < args.length) {

            List<String> orderArgs = new LinkedList<>();

            for (int i = seedPointer + 1; i < args.length; i++) {
                orderArgs.add(args[i]);
            }
            System.out.println(commandLineReader.generateOrder(orderArgs));
        }
    }

    public static void main(String[] args) {
        // seed product database
        if(args.length < 2){
            throw new IllegalArgumentException("Must seed products using --seed or -s then " +
                    "give products in listed format");
        }

        ProductScanSimulator simulator = new ProductScanSimulator();

        simulator.simulate(args);

    }
}
