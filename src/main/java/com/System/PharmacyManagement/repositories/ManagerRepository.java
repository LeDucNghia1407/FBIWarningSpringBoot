package com.System.PharmacyManagement.repositories;


import com.System.PharmacyManagement.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    List<Manager> findByid(Long id);
}
