package repository;

import model.BulkProduct;

import java.util.List;

public interface BulkProductRepository {
    public Object save(BulkProduct product);
    public BulkProduct get(String name);
    public BulkProduct delete(String name);
    public void Update(String name, BulkProduct product);
    public List<BulkProduct> getAllBulkProducts();
}
