package com.System.PharmacyManagement.repositories;


import com.System.PharmacyManagement.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {
    List<Login> findByid(Long id);
}
