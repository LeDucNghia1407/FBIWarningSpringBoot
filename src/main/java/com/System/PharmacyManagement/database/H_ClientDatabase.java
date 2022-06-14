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
public class H_ClientDatabase {
    long[] clientID = new long[]{1,2,3,4,5};

    F_EmployeeDatabase employeeDatabase = new F_EmployeeDatabase();
    Employee[] employee = new Employee[]{employeeDatabase.getEmployee(1),employeeDatabase.getEmployee(3),employeeDatabase.getEmployee(2),employeeDatabase.getEmployee(2),employeeDatabase.getEmployee(1)};

    Client[] clientlist = new Client[5];
    @Bean
    @Primary
    CommandLineRunner iniClientDatabase(ClientRepository clientRepository) {
        return new CommandLineRunner() {

            //Logger
            private final Logger logger = LoggerFactory.getLogger(H_ClientDatabase.class);
            @Override
            public void run(String... args) throws Exception {
                for (int i = 0;i<5;i++)
                {
                    clientlist[i] = new Client(clientID[i],employee[i]);
                }
                for (int i = 0;i<5;i++)
                {
                    logger.info("insert data: " + clientRepository.save(clientlist[i]));
                }

            }
        };
    }
    public Client getClient(int i)
    {
        Client client = new Client(clientID[i-1],employee[i-1]);
        return client;
    }

}
