package kits.edu.finalproject.repository;

import kits.edu.finalproject.entity.Product;
import kits.edu.finalproject.model.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<Product> findByNameContaining(String name);

}