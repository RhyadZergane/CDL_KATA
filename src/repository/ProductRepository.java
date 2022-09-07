package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    public void save(Product product);
    public Product get(String name);
    public Product delete(String name);
    public void Update(String name, Product product);
    public List<Product> getAllProducts();
}
