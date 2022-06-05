package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.DrugStore;
import com.System.PharmacyManagement.repositories.DrugStoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DrugStoreDatabase {
    @Bean
    @Primary
    CommandLineRunner iniDrugStoreDatabase(DrugStoreRepository drugstoreRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(DrugStoreDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                DrugStore drugstoreA = new DrugStore("DS1", "S1", "Earth", "VGU");
                DrugStore drugstoreB = new DrugStore("DS2", "S1", "Moon", "VGU");

                logger.info("insert data: "+ drugstoreRepository.save(drugstoreA));
                logger.info("insert data: "+ drugstoreRepository.save(drugstoreB));
            }
        };
    }

}
