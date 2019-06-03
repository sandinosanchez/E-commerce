package com.javabootcamp.ecomerce.api.Controller;

import com.javabootcamp.ecomerce.api.Model.Category;
import com.javabootcamp.ecomerce.api.Model.Product;
import com.javabootcamp.ecomerce.api.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity createCategory(@RequestBody Category category) throws Exception{
        try{
            categoryService.createCategory(category);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            throw new Exception("Error in createCategory");
        }
    }

    @GetMapping("")
    public List<Category> showAll() throws Exception{
        try {
            return categoryService.findAll();
        } catch (Exception e) {
            throw new Exception("Error in showAll");
        }
    }

    @GetMapping("/{id}")
    public List<Product> searchById(@PathVariable int id) throws Exception{
        try {
            return categoryService.categoryProd(id);
        }catch (Exception e){
            throw new Exception("Error in searchById");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editCategory(@PathVariable int id,@RequestBody Category categoryUpdate) throws Exception{
        try {
            categoryService.editCategory(id,categoryUpdate);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            throw new Exception("Error in editCategory");
        }
    }
}
