package com.javabootcamp.ecomerce.api.Service;


import com.javabootcamp.ecomerce.api.Model.Role;
import com.javabootcamp.ecomerce.api.Model.User;
import com.javabootcamp.ecomerce.api.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private HttpSession httpSession;

    public List<Role> showRoles(){
        return roleRepository.findAll();
    }

    public void newRole(Role role){
        roleRepository.save(role);
    }

    public void editRole(int id,Role roleEdit) throws Exception{
        if(httpSession.getAttribute("role") == "admin"){
            Role role = roleRepository.findById(id);
            if (Objects.nonNull(role)){
                if(Objects.nonNull(roleEdit.getRole()))
                    role.setRole(roleEdit.getRole());
                roleRepository.save(role);
            } else{
                throw new Exception("That role doesn't exist");
            }
        } else {
            throw new Exception("Permission error");
        }
    }

}
