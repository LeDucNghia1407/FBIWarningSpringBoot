package com.System.PharmacyManagement.repositories;

import com.System.PharmacyManagement.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    List<Client> findByclientID(String clientID);

}
