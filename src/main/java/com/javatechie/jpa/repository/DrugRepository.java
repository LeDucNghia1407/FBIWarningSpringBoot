package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Client;
import com.javatechie.jpa.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {
    List<Drug> findByid(Long id);
}
