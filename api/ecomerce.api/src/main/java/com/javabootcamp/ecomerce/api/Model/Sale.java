package com.javabootcamp.ecomerce.api.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sale")
public class Sale {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_id")
    private Integer id;

    @Column(name = "sale_date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "reserve_id")
    private Reserve reserve;


    public Sale() {
    }

    public Sale(Integer id, LocalDate date, Reserve reserve) {
        this.id = id;
        this.date = date;
        this.reserve = reserve;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }
}
