package com.javabootcamp.ecomerce.api.Controller;

import com.javabootcamp.ecomerce.api.Model.Post;
import com.javabootcamp.ecomerce.api.Model.User;
import com.javabootcamp.ecomerce.api.Service.PostService;
import com.javabootcamp.ecomerce.api.Service.RoleService;
import com.javabootcamp.ecomerce.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addUser(@Valid @RequestBody User user) throws Exception {
        try {
            userService.createUser(user);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception("Error creating User");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editUser(@PathVariable int id, @RequestBody User user) throws Exception {
        try {
            userService.editUser(id, user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception("Error editing user");
        }
    }

    @PostMapping("/add/role/{idUser}&{idRole}")
    public ResponseEntity addRole(@PathVariable int idUser, @PathVariable int idRole) throws Exception {
        try {
            userService.addRoleToUser(idUser, idRole);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception("Error creating user role");
        }
    }

    @GetMapping("/{id}")
    public List<Post> searchById(@PathVariable int id) throws Exception {
        try {
            return postService.findAllByUserId(id);
        } catch (Exception e) {
            throw new Exception("User not found");
        }
    }

    @GetMapping("/all")
    public List<User> showAllUsers() throws Exception {
        try {
            return userService.findAll();
        } catch (Exception e) {
            throw new Exception("Error in showAllUserService");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) throws Exception {
        try {
            userService.deleteUser(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception("Error in deleteUser");
        }
    }

    @GetMapping("/inactive")
    public List<User> showRecomended() throws Exception{
        try {
            return userService.listOfInactiveUser();
        }catch (Exception e){
            throw new Exception("Error in showRecomended");
        }
    }

    @DeleteMapping("/inactive")
    public ResponseEntity deleteRecomended() throws Exception{
        try {
            List<User> user = userService.listOfInactiveUser();
            userService.deleteInactiveUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e) {
            throw new Exception("Error in deleteRecomended");
        }
    }

}
