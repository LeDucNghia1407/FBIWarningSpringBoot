package com.System.PharmacyManagement.repositories;


import com.System.PharmacyManagement.models.Invoice;
import com.System.PharmacyManagement.models.InvoiceTotal;
import com.System.PharmacyManagement.models.InvoiceMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Long>{

    List<Invoice> findByid(Long id);

    @Query("SELECT new com.javatechie.jpa.entity.InvoiceTotal(i.num, sum(i.quantity), sum(i.quantity * d.price))  FROM Invoice i, Drug d Group by i.num")
    public List<InvoiceTotal> getJoinInformation();

    @Query("SELECT new com.javatechie.jpa.entity.InvoiceTotal(i.num, sum(i.quantity), sum(i.quantity * d.price))  FROM Invoice i, Drug d Where i.num =?1 Group by i.num")
    public List<InvoiceTotal> getJoinInformationbynum(int num);

    //@Query("SELECT i FROM Invoice i Where i.num = ?1")
    //public List<Invoice> getInvoicebynum(int num);

    @Query("SELECT new com.javatechie.jpa.entity.InvoiceMethod(i.num, d.drugName, d.price,sum(i.quantity), (d.price * sum(i.quantity))) FROM Invoice i, Drug d Group by i.num,d.drugName")
    public List<InvoiceMethod> getInvoiceMethod();
    @Query("SELECT new com.javatechie.jpa.entity.InvoiceMethod(i.num, d.drugName, d.price,sum(i.quantity), (d.price * sum(i.quantity))) FROM Invoice i, Drug d Where i.num = ?1 Group by i.num,d.drugName")
    public List<InvoiceMethod> getInvoiceMethodbyNum(int num);
}
