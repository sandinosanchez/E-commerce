package com.javabootcamp.ecomerce.api.Controller;


import com.javabootcamp.ecomerce.api.Model.Role;
import com.javabootcamp.ecomerce.api.Service.RoleService;
import com.javabootcamp.ecomerce.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleControler {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;




    @PostMapping("/add")
    public ResponseEntity newRole(@Valid @RequestBody Role role) throws Exception{
        try {
            roleService.newRole(role);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            throw new Exception("Error creating role");
        }
    }

    @GetMapping("/all")
    public List<Role> showRoles() throws Exception{
        try {
            return roleService.showRoles();
        }catch (Exception e){
            throw new Exception("Error in showRolles");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editRole(@PathVariable int id, @RequestBody Role role) throws Exception{
        try {
            roleService.editRole(id,role);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("Error in editRole");
        }
    }


}
