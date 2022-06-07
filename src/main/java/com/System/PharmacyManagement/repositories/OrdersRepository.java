package com.System.PharmacyManagement.repositories;

import com.System.PharmacyManagement.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, String> {
    List<Orders> findByorderID(String orderID);
}
