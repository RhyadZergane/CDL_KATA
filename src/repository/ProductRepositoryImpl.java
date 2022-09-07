package repository;
import model.Product;

import java.util.HashMap;
import java.util.List;


public class ProductRepositoryImpl implements ProductRepository{
    private HashMap<String,Product> products;

    public ProductRepositoryImpl(){
        products = new HashMap<>();

    }

    public ProductRepositoryImpl(HashMap<String,Product> hm){
        products = hm;

    }

    @Override
    public void save(Product product) {
        products.putIfAbsent(product.getName(), product);
    }

    @Override
    public Product get(String name) {
        return products.getOrDefault(name,null);
    }

    @Override
    public Product delete(String name) {
        return products.remove(name);
    }

    @Override
    public void Update(String name, Product product) {
        products.put(name,product);
    }

    @Override
    public List<Product> getAllProducts(){
        return products.values().stream().toList();
    }
}
