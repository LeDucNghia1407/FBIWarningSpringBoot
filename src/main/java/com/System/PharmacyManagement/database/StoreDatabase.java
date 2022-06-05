package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.Store;
import com.System.PharmacyManagement.repositories.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StoreDatabase {
    @Bean
    @Primary
    CommandLineRunner iniStoreDatabase(StoreRepository storeRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(StoreDatabase.class);
            @Override
            public void run(String... args) throws Exception {


                Store storeA = new Store("St1", "D1", "DS1", "2020-06-07", 30);
                Store storeB = new Store("St1", "D1", "DS1", "2020-06-07", 30);
                Store storeC = new Store("St1", "D1", "DS1", "2020-06-07", 30);
                Store storeD = new Store("St1", "D1", "DS1", "2020-06-07", 30);
                Store storeE = new Store("St1", "D1", "DS1", "2020-06-07", 30);
                logger.info("insert data: "+ storeRepository.save(storeA));
                logger.info("insert data: "+ storeRepository.save(storeB));
                logger.info("insert data: "+ storeRepository.save(storeC));
                logger.info("insert data: "+ storeRepository.save(storeD));
                logger.info("insert data: "+ storeRepository.save(storeE));
            }
        };
    }

}
