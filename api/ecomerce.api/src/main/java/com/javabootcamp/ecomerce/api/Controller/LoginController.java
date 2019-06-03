package com.javabootcamp.ecomerce.api.Controller;


import com.javabootcamp.ecomerce.api.Model.User;
import com.javabootcamp.ecomerce.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/{username}&{password}")
    public ResponseEntity login(HttpServletRequest request, @PathVariable String username,@PathVariable String password) throws Exception{
        httpSession = request.getSession();
        User user = userService.findByUserName(username);
        if(Objects.nonNull(user))
            if (user.getPassword().equals(password)){
                httpSession.setAttribute("user_id",user.getId());
                if (userService.isAdmin(user.getId()))
                    httpSession.setAttribute("role" ,"admin");
                else {
                    httpSession.setAttribute("role","user");
                }
                return new ResponseEntity(HttpStatus.OK);
            }else{
                throw new Exception("Your password is incorrect");
            }else{
                throw new Exception("Your must be sign in first");
        }
    }

    @GetMapping(value = "")
    public ResponseEntity logout(HttpServletRequest request) throws Exception{
        httpSession = request.getSession();
        if(Objects.nonNull(httpSession.getAttribute("user_id"))){
            httpSession.setAttribute("user_id",null);
            return new ResponseEntity(HttpStatus.OK);
        }else{
            throw new Exception("You must be sign in first");
        }
    }
}
