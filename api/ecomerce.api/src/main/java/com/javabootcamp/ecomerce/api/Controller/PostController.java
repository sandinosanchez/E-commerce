package com.javabootcamp.ecomerce.api.Controller;

import com.javabootcamp.ecomerce.api.Model.Category;
import com.javabootcamp.ecomerce.api.Model.Post;
import com.javabootcamp.ecomerce.api.Model.Product;
import com.javabootcamp.ecomerce.api.Model.User;
import com.javabootcamp.ecomerce.api.Service.PostService;
import com.javabootcamp.ecomerce.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @PostMapping("/add")
    public ResponseEntity newPost(@Valid @RequestBody Post post) throws Exception{
        try {
            User currentUser =  userService.findById((int) httpSession.getAttribute("user_id"));
            Product prod = post.getProduct();
            Category category = prod.getCategory();
            postService.newPost(currentUser,post,prod,category);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            throw new Exception("Error in newPost");
        }
    }

    @GetMapping("")
    public List<Post> showAll()throws Exception{
        try{
            return postService.findAll();
        }catch (Exception e){
            throw new Exception("Error in showAll");
        }
    }

    @GetMapping("/{pname}")
    public List<Post> showPostByProductName(@PathVariable String pname) throws Exception{
        try {
            return postService.findAllByProductName(pname);
        }catch (Exception e){
            throw new Exception("error in showPostByproductName");
        }
    }

    @GetMapping("/p/{id}")
    public Post showPostById(@PathVariable int id) throws Exception{
        try {
            return postService.findById(id);
        }catch (Exception e){
            throw new Exception("Error in showPostByUserName");
        }
    }
}
