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

@Data
@Configuration
public class E_ManagerDatabase {
    long[] managerID = new long[]{1,2};
    B_DrugStoreDatabase drugStoreDatabase = new B_DrugStoreDatabase();
    DrugStore[] drugStore = new DrugStore[]{drugStoreDatabase.getDrugStore(1),
            drugStoreDatabase.getDrugStore(2)};
    Manager[] managerlist = new Manager[2];
    @Bean
    @Primary
    CommandLineRunner iniManagerDatabase(ManagerRepository managerRepository) {
        return new CommandLineRunner() {

            //Logger
            private final Logger logger = LoggerFactory.getLogger(E_ManagerDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<2;i++)
                {
                    managerlist[i] = new Manager(managerID[i],drugStore[i]);
                }
                for (int i = 0;i<2;i++)
                {
                    logger.info("insert data: "+ managerRepository.save(managerlist[i]));
                }
            }
        };
    }

    public Manager getManager(int i)
    {
        Manager manager = new Manager(managerID[i-1],drugStore[i-1]);
        return manager;
    }

}
