package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Client;
import com.javatechie.jpa.entity.DrugStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugStoreRepository extends JpaRepository<DrugStore,String> {

    List<DrugStore> findByid(String id);
}
