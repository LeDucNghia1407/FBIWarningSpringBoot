package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.DrugStore;
import com.javatechie.jpa.entity.DrugSupplier;
import com.javatechie.jpa.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, String> {
    List<Login> findByid(String id);
}
