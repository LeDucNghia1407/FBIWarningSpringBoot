package com.System.PharmacyManagement.repositories;


import com.System.PharmacyManagement.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findByid(Long id);
}