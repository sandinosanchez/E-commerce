package com.javabootcamp.ecomerce.api.Repository;

import com.javabootcamp.ecomerce.api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);

    List<User> findAll();

    void delete(User user);

    User findByUserName(String userName);

    List<User> findAllByDateBefore(LocalDate date);

    User findByName(String name);

    void deleteById(int id);

}
