package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.*;
import com.System.PharmacyManagement.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ClientDatabase {
    String[] clientID = new String[]{"C1","C2","C3","C4","C5"};
    String[] employeeID = new String[]{"E1","E3","E2","E2","E1"};
    Client[] clientlist = new Client[5];
    @Bean
    @Primary
    CommandLineRunner iniClientDatabase(ClientRepository clientRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(ClientDatabase.class);
            @Override
            public void run(String... args) throws Exception {
                for (int i = 0;i<5;i++)
                {
                    clientlist[i] = new Client(clientID[i],employeeID[i]);
                }
                for (int i = 0;i<5;i++)
                {
                    logger.info("insert data: " + clientRepository.save(clientlist[i]));
                }

            }
        };
    }

}
