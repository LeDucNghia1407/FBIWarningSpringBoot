package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.DrugStore;
import com.javatechie.jpa.entity.DrugSupplier;
import com.javatechie.jpa.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, String> {

    List<Store> findByid(String id);
}