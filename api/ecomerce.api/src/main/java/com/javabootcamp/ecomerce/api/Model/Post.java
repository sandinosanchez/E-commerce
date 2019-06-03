package com.javabootcamp.ecomerce.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "post_id")
    private Integer id;

    @Column (name = "post_state")
    private boolean state = true;

    @Column (name = "date")
    private Date date;

    @Column (name = "stock")
    private int stock;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
    @JsonIgnore
    private List<Reserve> postReserve;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "post")
    private Product product;


    public Post() {
    }

    public Post(Integer id, boolean postState,Date date,int stock, List<Reserve> postReserve, User user, Product product) {
        this.id = id;
        this.state = postState;
        this.date = date;
        this.stock = stock;
        this.postReserve = postReserve;
        this.user = user;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPostState() {
        return state;
    }

    public void setPostState(boolean postState) {
        this.state = postState;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Reserve> getPostReserve() {
        return postReserve;
    }

    public void setPostReserve(List<Reserve> postReserve) {
        this.postReserve = postReserve;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
