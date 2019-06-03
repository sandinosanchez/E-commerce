package com.javabootcamp.ecomerce.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "User")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "user_id")
    private Integer id;

    @Column (name = "first_name")
    private String name;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "password")
    private String password;

    @Column (name = "email")
    private String  email;

    @Column (name = "date_birth")
    private LocalDate dod;

    @Column (name = "last_modif")
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnore
    private List<Post> userPost = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnore
    private List<Reserve> userReserve = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    @JsonIgnore
    private Role role;

    public User() {
    }

    public User(Integer id, String name, String lastName, String userName, String password, String email, LocalDate dod,LocalDate date, List<Post> userPost, List<Reserve> userReserve, Role userRole) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.dod = dod;
        this.date =  date ;
        this.userPost = userPost;
        this.userReserve = userReserve;
        this.role = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public LocalDate getLastModif() {
        return date;
    }

    public void setLastModif(LocalDate date) {
        this.date = date;
    }

    public List<Post> getUserPost() {
        return userPost;
    }

    public void setUserPost(List<Post> userPost) {
        this.userPost = userPost;
    }

    public List<Reserve> getUserReserve() {
        return userReserve;
    }

    public void setUserReserve(List<Reserve> userReserve) {
        this.userReserve = userReserve;
    }

    public Role getUserRole() {
        return role;
    }

    public void setUserRole(Role userRole) {
        this.role = userRole;
    }
}
