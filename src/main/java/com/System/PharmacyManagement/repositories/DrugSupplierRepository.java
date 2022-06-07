package com.System.PharmacyManagement.repositories;

import com.System.PharmacyManagement.models.DrugSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugSupplierRepository extends JpaRepository<DrugSupplier, String> {
    List<DrugSupplier> findBydrugSupplierID(String drugSupplierID);
}
