package kits.edu.finalproject.service.productImpl;

import kits.edu.finalproject.entity.Product;
import kits.edu.finalproject.model.ProductDTO;
import kits.edu.finalproject.repository.ProductRepository;
import kits.edu.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findProductByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        boolean prod = productRepository.existsById(id);
        product.setProductId(id);
        if (prod == true) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        productRepository.deleteAll();
        return true;
    }
}