package com.javabootcamp.ecomerce.api.Repository;

import com.javabootcamp.ecomerce.api.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    void deleteById(int id);

    Category findById(int id);

    Category findByName(String name);
}
