package com.javabootcamp.ecomerce.api.Service;


import com.javabootcamp.ecomerce.api.Model.Post;
import com.javabootcamp.ecomerce.api.Model.Reserve;
import com.javabootcamp.ecomerce.api.Model.Sale;
import com.javabootcamp.ecomerce.api.Model.User;
import com.javabootcamp.ecomerce.api.Repository.PostRepository;
import com.javabootcamp.ecomerce.api.Repository.ReserveRepository;
import com.javabootcamp.ecomerce.api.Repository.SaleRepository;
import com.javabootcamp.ecomerce.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SaleRepository saleRepository;

    public void newReserve(int idPost,int quantity){
        Post post = postRepository.findById(idPost);
        User user = userRepository.findById((int) httpSession.getAttribute("user_id"));
        Reserve reserve = new Reserve();
        if(Objects.nonNull(post)&&(post.getStock() >= quantity)){
            post.setStock(post.getStock()-quantity);
            reserve.setPost(post);
            reserve.setQuantity(quantity);
            reserve.setUser(user);
            if (post.getStock()<1)
                post.setPostState(false);
            reserve.setDateOfResrve(new Date());
            reserve.getUser().setLastModif(LocalDate.now());
            post.getPostReserve().add(reserve);
            reserveRepository.save(reserve);
            postRepository.save(post);
        }
    }

    public List<Reserve> findAll(){
        return reserveRepository.findAll();
    }

    public void deleteReserve(int id) throws Exception{
        if(httpSession.getAttribute("role") == "admin")
            reserveRepository.deleteById(id);
        else{
            throw new Exception("Permission error");
        }
    }

    public void deleteListReserve(List<Reserve> deleteList) throws Exception{
        if (httpSession.getAttribute("role") == "admin") {
            for (Reserve r : deleteList) {
                reserveRepository.delete(r);
            }
        } else {
            throw new Exception("Permission error");
        }
    }

    public void deleteExpiredReserve() throws Exception{
        if(httpSession.getAttribute("role") == "admin"){
            LocalDate date = LocalDate.now().minusDays(7);
            List<Reserve> expiredList = reserveRepository.findAllByDateBefore(date);
            for (Reserve r: expiredList){
                reserveRepository.deleteById(r.getId());
            }
        } else {
            throw new Exception("Permission error");
        }
    }

    public void cancelReserve(int id){
        Reserve reserve = reserveRepository.findById(id);
        if (Objects.nonNull(reserve)){
            Sale sale = new Sale();
            sale.setReserve(reserve);
            sale.setDate(LocalDate.now());
            saleRepository.save(sale);
            reserve.setStateOfReserve(false);
            reserveRepository.save(reserve);
        }
    }

}
