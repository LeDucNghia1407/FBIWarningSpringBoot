package com.System.PharmacyManagement.database;

import com.System.PharmacyManagement.models.*;
import com.System.PharmacyManagement.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@Configuration
public class J_InvoiceDatabase {

    long[] invoiceID = new long[]{1,2,3,4,5,6};
    C_DrugDatabase drugDatabase = new C_DrugDatabase();

    Drug[] drug = new Drug[]{drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3),drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3)};

    int[] num = new int[]{1,1,1,2,2,2};
    int[] quantity = new int[]{10,20,30,40,50,60};

    Invoice[] invoicelist = new Invoice[6];

    @Bean
    @Primary
    CommandLineRunner iniInvoiceDatabase(InvoiceRepository invoiceRepository) {
        return new CommandLineRunner() {

            //Logger
            private final Logger logger = LoggerFactory.getLogger(J_InvoiceDatabase.class);
            // construct and insert data
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<6;i++)
                {
                    invoicelist[i] = new Invoice(invoiceID[i],num[i],drug[i],quantity[i]);
                }
                for (int i = 0;i<6;i++)
                {
                    logger.info("insert data: "+ invoiceRepository.save(invoicelist[i]));
                }

            }
        };
    }

}
