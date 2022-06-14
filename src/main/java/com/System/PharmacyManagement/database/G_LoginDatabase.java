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
public class G_LoginDatabase {
    long[] loginID = new long[]{1,2,3,4,5};
    F_EmployeeDatabase employeeDatabase = new F_EmployeeDatabase();
    Employee[] employee = new Employee[]{employeeDatabase.getEmployee(1),employeeDatabase.getEmployee(2),employeeDatabase.getEmployee(3),employeeDatabase.getEmployee(4),employeeDatabase.getEmployee(5)};
    String[] password = new String[]{"PS1","PS2","PS3","PS4","PS5"};
    Login[] loginlist = new Login[5];
    @Bean
    @Primary
    CommandLineRunner iniLoginDatabase(LoginRepository loginRepository) {
        return new CommandLineRunner() {

            //Logger
            private final Logger logger = LoggerFactory.getLogger(G_LoginDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<5;i++)
                {
                    loginlist[i] = new Login(loginID[i],password[i],employee[i] );
                }
                for (int i = 0;i<5;i++)
                {
                    logger.info("insert data: "+ loginRepository.save(loginlist[i]));
                }

            }
        };
    }

}
