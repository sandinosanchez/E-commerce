package com.javabootcamp.ecomerce.api.Repository;

import com.javabootcamp.ecomerce.api.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByName(String productName);

    List<Product> findByCategoryName(String categoryName);

    List<Product> findAllByCategoryId(int id);

}
