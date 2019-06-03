package com.javabootcamp.ecomerce.api.Repository;

import com.javabootcamp.ecomerce.api.Model.Post;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findAllByUserName (String name);

    List<Post> findAllByProductName(String productName);

    Post findByUserIdAndDateBefore(int id, LocalDate date);

    List<Post> findAllByUserId(int userId);

    Post findByProductName(String productName);

    Post findById(int id);

    List<Post> findAll();

    List<Post> findAllByStateFalse();

}
