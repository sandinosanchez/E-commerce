package com.javabootcamp.ecomerce.api.Service;

import com.javabootcamp.ecomerce.api.Model.Category;
import com.javabootcamp.ecomerce.api.Model.Product;
import com.javabootcamp.ecomerce.api.Repository.CategoryRepository;
import com.javabootcamp.ecomerce.api.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findById(int id){
        return productRepository.findAllByCategoryId(id);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void createCategory(Category category) throws Exception{
        if (httpSession.getAttribute("role") == "admin")
            categoryRepository.save(category);
        else {
            throw new Exception("Permission error");
        }
    }

    public List<Product> categoryProd(int id){
        Category category = categoryRepository.findById(id);
        if (Objects.nonNull(category))
            return category.getProductList();
        else {
            return null;
        }
    }

    public void editCategory(int id,Category categoryUpdate) throws Exception{
        if(httpSession.getAttribute("role") == "admin"){
            Category category = categoryRepository.findById(id);
            if(Objects.nonNull(category)) {
                if (Objects.nonNull(categoryUpdate.getName()))
                    category.setName(categoryUpdate.getName());
                if (Objects.nonNull(categoryUpdate.getDescription()))
                    category.setDescription(categoryUpdate.getDescription());
                categoryRepository.save(category);
            }
        } else {
            throw new Exception("Permission error");
        }
    }

    public void deleteCategory(int id) throws Exception{
        if(httpSession.getAttribute("role") == "admin" )
            categoryRepository.deleteById(id);
        else {
            throw new Exception("Permission error");
        }
    }
}
