package com.javabootcamp.ecomerce.api.Service;

import com.javabootcamp.ecomerce.api.Model.Category;
import com.javabootcamp.ecomerce.api.Model.Post;
import com.javabootcamp.ecomerce.api.Model.Product;
import com.javabootcamp.ecomerce.api.Model.User;
import com.javabootcamp.ecomerce.api.Repository.CategoryRepository;
import com.javabootcamp.ecomerce.api.Repository.PostRepository;
import com.javabootcamp.ecomerce.api.Repository.ProductRepository;
import com.javabootcamp.ecomerce.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void newPost(User user , Post post, Product product, Category category){
        post.setDate(new Date());
        post.setPostState(true);
        post.setUser(user);
        post.setProduct(product);
        product.setPost(post);
        if(Objects.nonNull(category)){
            Category category1 = categoryRepository.findByName(category.getName());
            if(Objects.nonNull(category1)){
                post.getProduct().setCategory(category1);
                category1.getProductList().add(product);
            }else{
                post.getProduct().setCategory(null);
            }
        }else{
            post.getProduct().setCategory(null);
        }
        postRepository.save(post);
        productRepository.save(product);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public List<Post> findAllByUserId(int id){
        return postRepository.findAllByUserId(id);
    }

    public List<Post> findAllByUserName(String userName){
        return postRepository.findAllByUserName(userName);
    }

    public List<Post> findAllByProductName(String productName){
        return postRepository.findAllByProductName(productName);
    }

    public Post findById(int id){
        return postRepository.findById(id);
    }

    public void deletePostMarked() throws Exception{
        if (httpSession.getAttribute("role") == "admin") {
            List<Post> deleteList = postRepository.findAllByStateFalse();
            for (Post p : deleteList) {
                postRepository.delete(p);
            }
        } else {
            throw new Exception("Permission error");
        }
    }
}
