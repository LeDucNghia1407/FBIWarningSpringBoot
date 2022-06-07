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
    String[] managerID = new String[]{"M1","M2"};
    String[] drugStoreID = new String[]{"DS1","DS2"};
    Manager[] managerlist = new Manager[2];
    @Bean
    @Primary
    CommandLineRunner iniManagerDatabase(ManagerRepository managerRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(ManagerDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<2;i++)
                {
                    managerlist[i] = new Manager(managerID[i],drugStoreID[i] );
                }
                for (int i = 0;i<2;i++)
                {
                    logger.info("insert data: "+ managerRepository.save(managerlist[i]));
                }
            }
        };
    }

}
