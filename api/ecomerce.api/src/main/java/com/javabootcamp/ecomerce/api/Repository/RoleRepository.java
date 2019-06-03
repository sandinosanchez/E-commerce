package com.javabootcamp.ecomerce.api.Repository;

import com.javabootcamp.ecomerce.api.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> findByUserId(int id);

    Role findById(int id);

    Role findByName(String name);
}
