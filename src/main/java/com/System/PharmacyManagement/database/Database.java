package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.Client;
import com.System.PharmacyManagement.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    @Bean
    CommandLineRunner iniDatabase(ClientRepository clientRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(Database.class);
            @Override
            public void run(String... args) throws Exception {
//                Client clientA = new Client("C7", "E8");
//                Client clientB = new Client("C8", "E9");
//                logger.info("insert data: "+ clientRepository.save(clientA));
//                logger.info("insert data: "+ clientRepository.save(clientB));
            }
        };
    }

}
