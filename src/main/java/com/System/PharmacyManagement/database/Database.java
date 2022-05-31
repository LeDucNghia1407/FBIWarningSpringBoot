package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.repositories.ClientRepository;
import com.System.PharmacyManagement.models.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepo) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Client clientA = new Client("C7","E8");
                Client clientB = new Client("M10","E8");
                logger.info("insert data: " +clientRepo.save(clientA));
                logger.info("insert data: " +clientRepo.save(clientB));
            }
        };
    }
}
