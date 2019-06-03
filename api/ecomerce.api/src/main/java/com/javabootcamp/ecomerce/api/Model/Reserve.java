package com.javabootcamp.ecomerce.api.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserve")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reserve_id")
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "state")
    private boolean stateOfReserve = true;

    @Column (name = "quantity")
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;


    public Reserve() {
    }

    public Reserve(Integer id, Date date, boolean stateOfReserve, int quantity, Post post, User user) {
        this.id = id;
        this.date = date;
        this.stateOfReserve = stateOfReserve;
        this.quantity = quantity;
        this.post = post;
        this.user = user;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfResrve() {
        return date;
    }

    public void setDateOfResrve(Date dateOfResrve) {
        this.date = new Date();
    }

    public boolean isStateOfReserve() {
        return stateOfReserve;
    }

    public void setStateOfReserve(boolean stateOfReserve) {
        this.stateOfReserve = stateOfReserve;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
