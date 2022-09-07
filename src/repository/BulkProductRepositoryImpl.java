package repository;

import model.BulkProduct;

import java.util.HashMap;
import java.util.List;

public class BulkProductRepositoryImpl implements BulkProductRepository{
    private HashMap<String,BulkProduct> products;

    public BulkProductRepositoryImpl(HashMap<String,BulkProduct> hashMap){
        this.products = hashMap;
    }

    public BulkProductRepositoryImpl(){
        this.products = new HashMap<>();
    }

    @Override
    public Object save(BulkProduct product) {
        products.putIfAbsent(product.getName(), product);
        return null;
    }

    @Override
    public BulkProduct get(String name) {
        return products.getOrDefault(name,null);
    }

    @Override
    public BulkProduct delete(String name) {
        return products.remove(name);
    }

    @Override
    public void Update(String name, BulkProduct product) {
        products.put(name,product);
    }

    @Override
    public List<BulkProduct> getAllBulkProducts(){
        return products.values().stream().toList();
    }
}
