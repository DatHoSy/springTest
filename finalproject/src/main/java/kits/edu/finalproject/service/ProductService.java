package kits.edu.finalproject.service;


import kits.edu.finalproject.entity.Product;
import kits.edu.finalproject.model.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<Product> findProductByName(String name);
//    public List<Product> findProductById();
    public Product createProduct(Product product);
    public Product updateProduct(int id, Product product);
    public boolean deleteProduct(int id);
}