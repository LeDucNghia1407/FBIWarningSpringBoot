package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.DrugStore;
import com.javatechie.jpa.entity.DrugSupplier;
import com.javatechie.jpa.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByid(Long id);
}
