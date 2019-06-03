package com.javabootcamp.ecomerce.api.Repository;

import com.javabootcamp.ecomerce.api.Model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve,Integer> {

    List<Reserve> findAllByDateBefore(LocalDate date);

    Reserve findByUserIdAndDateBefore(int id, LocalDate date);

    List<Reserve> findAll();

    void delete(Reserve reserve);

    void deleteById(int id);

    Reserve findById(int id);
}
