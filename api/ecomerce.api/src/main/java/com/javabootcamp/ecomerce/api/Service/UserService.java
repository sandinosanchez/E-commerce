package com.javabootcamp.ecomerce.api.Service;


import com.javabootcamp.ecomerce.api.Model.*;
import com.javabootcamp.ecomerce.api.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReserveRepository reserveRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void createUser(User user) throws Exception{
        if (httpSession.getAttribute("role") == "admin")
            userRepository.save(user);
        else {
            throw new Exception("Permission error");
            }
    }

    public void editUser(int id, User userUpdate){
        User user = userRepository.findById(id);
        if (Objects.nonNull(user)){
            if(Objects.nonNull(userUpdate.getName()))
                user.setName(userUpdate.getName());
            if(Objects.nonNull(userUpdate.getUserName()))
                user.setUserName(userUpdate.getUserName());
            if(Objects.nonNull(userUpdate.getLastName()))
                user.setLastName(userUpdate.getLastName());
            if(Objects.nonNull(userUpdate.getPassword()))
                user.setPassword(userUpdate.getPassword());
            if(Objects.nonNull(userUpdate.getDod()))
                user.setDod(userUpdate.getDod());
            if (Objects.nonNull(userUpdate.getEmail()))
                user.setEmail(userUpdate.getEmail());
            user.setLastModif(LocalDate.now());
            userRepository.save(user);
        }
    }

    public void addRoleToUser(int idUser,int idRole) throws Exception{
        if(httpSession.getAttribute("role") == "admin") {
            Role role = roleRepository.findById(idRole);
            User user = userRepository.findById(idUser);
            if (Objects.nonNull(role)) {
                user.setUserRole(role);
                userRepository.save(user);
            } else {
                throw new Exception("That role doesn't exist");
            }
        } else {
            throw new Exception("Permission error");
        }
    }

    public void delteUserById(int id){
        if(Objects.nonNull(userRepository.findById(id))){
            userRepository.deleteById(id);
        }
    }

    public List<User> listOfInactiveUser() throws Exception{
        if (httpSession.getAttribute("role") == "admin") {
            List<User> usersInactive = new ArrayList<>();
            LocalDate date = LocalDate.now().minusDays(30);
            List<User> users = userRepository.findAllByDateBefore(date);
            if (Objects.nonNull(users)){
                for (User us : users) {
                    if (Objects.nonNull(us.getUserPost())) {
                        if (Objects.nonNull(us.getUserReserve())){
                            if (Objects.nonNull(postRepository.findByUserIdAndDateBefore(us.getId(), date))) {
                                if (Objects.nonNull(reserveRepository.findByUserIdAndDateBefore(us.getId(), date)))
                                    usersInactive.add(us);
                            }
                        }else {
                            if(Objects.nonNull(postRepository.findByUserIdAndDateBefore(us.getId(),date)))
                                usersInactive.add(us);
                        }
                    }else{
                        if (Objects.nonNull(reserveRepository.findByUserIdAndDateBefore(us.getId(),date)))
                            users.add(us);
                    }
                }
            }else{
                throw new Exception("No inactive users");
            }
            return usersInactive;
        }

        else {
            throw new Exception("Permission error");
        }

    }

    public void deleteInactiveUser(List<User> deleteList) throws Exception{
        if(httpSession.getAttribute("role")  == "admin"){
            for (User u: deleteList){
                userRepository.delete(u);
            }
        }else{
            throw new Exception("Permission error");
        }
    }

    public void deleteUser(int id) throws Exception{
        if (httpSession.getAttribute("role") == "admin") {
            userRepository.deleteById(id);
        }
        else {
            throw new Exception("permission error");
        }
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }


    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public User findById(int id){
        return userRepository.findById(id);
    }

    public boolean isAdmin(int id){
        for (Role r: roleRepository.findByUserId(id)){
            if (r.getRole().contains("admin"))
                return true;
        }
        return  false;
    }

}
