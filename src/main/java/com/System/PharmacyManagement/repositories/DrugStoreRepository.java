package com.System.PharmacyManagement.repositories;

import com.System.PharmacyManagement.models.DrugStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugStoreRepository extends JpaRepository<DrugStore, String> {
    List<DrugStore> findBydrugStoreID(String drugStoreID);

}
