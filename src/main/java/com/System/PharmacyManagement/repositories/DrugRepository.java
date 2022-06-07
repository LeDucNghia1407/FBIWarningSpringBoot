package com.System.PharmacyManagement.repositories;

import com.System.PharmacyManagement.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug,String> {
    List<Drug> findBydrugName(String drugName);

}
