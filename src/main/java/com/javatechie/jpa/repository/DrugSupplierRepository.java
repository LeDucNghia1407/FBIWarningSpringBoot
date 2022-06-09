package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Client;
import com.javatechie.jpa.entity.DrugStore;
import com.javatechie.jpa.entity.DrugSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugSupplierRepository extends JpaRepository<DrugSupplier,String> {

    List<DrugSupplier> findByid(String id);
}
