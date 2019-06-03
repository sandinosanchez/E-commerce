package com.javabootcamp.ecomerce.api.Controller;

import com.javabootcamp.ecomerce.api.Model.Reserve;
import com.javabootcamp.ecomerce.api.Service.ReserveService;
import com.javabootcamp.ecomerce.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private UserService userService;

    @PostMapping("/add/{id}&{quant}")
    public ResponseEntity newReserve(@PathVariable int quant,@PathVariable int id) throws Exception{
        try {
            reserveService.newReserve(id, quant);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            throw new Exception("Error in newReserve");
        }
    }

    @PutMapping("/buy/{id}")
    public ResponseEntity buyReserve(@PathVariable int id) throws Exception{
        try {
            reserveService.cancelReserve(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            throw new Exception("Error in buyService");
        }
    }

    @DeleteMapping("")
    public ResponseEntity deleteExpired()throws Exception{
        try {
            reserveService.deleteExpiredReserve();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            throw new Exception("Error in deleteExpired");
        }
    }

    @GetMapping("")
    public List<Reserve> shhowAll()throws Exception{
        try{
            return reserveService.findAll();
        } catch (Exception e){
            throw new Exception("Error in showAll");
        }
    }
}
