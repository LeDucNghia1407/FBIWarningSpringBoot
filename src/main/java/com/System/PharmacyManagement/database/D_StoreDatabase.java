package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.*;
import com.System.PharmacyManagement.repositories.*;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import java.sql.Date;

@Data
@Configuration
public class D_StoreDatabase {
    long[] storeID = new long[]{1,2,3,4,5,6};

    B_DrugStoreDatabase drugStoreDatabase = new B_DrugStoreDatabase();
    DrugStore[] drugStore = new DrugStore[]{drugStoreDatabase.getDrugStore(1),drugStoreDatabase.getDrugStore(1),drugStoreDatabase.getDrugStore(1),drugStoreDatabase.getDrugStore(2),drugStoreDatabase.getDrugStore(2),drugStoreDatabase.getDrugStore(2)};
    C_DrugDatabase drugDatabase = new C_DrugDatabase();
    Drug[] drug = new Drug[]{drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3),drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3)};

    Date[] Storetime = new Date[]{
            Date.valueOf("2020-06-07"),Date.valueOf("2020-06-07"),Date.valueOf("2020-06-07"),
            Date.valueOf("2020-06-07"),Date.valueOf("2020-06-07"),Date.valueOf("2020-06-07")
    };

    int[] Quantity = new int[]{30,30,30,30,30,30};
    Store[] storelist = new Store[6];
    @Bean
    @Primary
    CommandLineRunner iniStoreDatabase(StoreRepository storeRepository) {
        return new CommandLineRunner() {

            //Logger
            private final Logger logger = LoggerFactory.getLogger(D_StoreDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0; i<6;i++)
                {
                    storelist[i] = new Store(storeID[i],Storetime[i],Quantity[i],drug[i],drugStore[i]);
                }
                for (int i = 0; i<6;i++)
                {
                    logger.info("insert data: "+ storeRepository.save(storelist[i]));
                }

            }
        };
    }



}
