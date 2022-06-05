package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.Manager;
import com.System.PharmacyManagement.repositories.ManagerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ManagerDatabase {
    @Bean
    @Primary
    CommandLineRunner iniManagerDatabase(ManagerRepository managerRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(ManagerDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                Manager managerA = new Manager("M1", "DS1");
                Manager managerB = new Manager("M2", "DS2");


                logger.info("insert data: "+ managerRepository.save(managerA));
                logger.info("insert data: "+ managerRepository.save(managerB));
            }
        };
    }

}
