package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.Employee;
import com.System.PharmacyManagement.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EmployeeDatabase {
    @Bean
    @Primary
    CommandLineRunner iniEmployeeDatabase(EmployeeRepository employeeRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(EmployeeDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                Employee employeeA = new Employee("E1", "DS1", "", "cat1", "cat1@gmail.com", "201", 0, 500);
                Employee employeeB = new Employee("E2", "DS1", "", "cat2", "cat2@gmail.com", "202", 0, 500);
                Employee employeeC = new Employee("E3", "DS2", "", "cat3", "cat3@gmail.com", "203", 0, 500);
                Employee employeeD = new Employee("E4", "DS1", "M1", "cat4", "cat4@gmail.com", "204", 0, 2000);
                Employee employeeE = new Employee("E5", "DS2", "M2", "cat5", "cat5@gmail.com", "205", 0, 2000);

                logger.info("insert data: "+ employeeRepository.save(employeeA));
                logger.info("insert data: "+ employeeRepository.save(employeeB));
                logger.info("insert data: "+ employeeRepository.save(employeeC));
                logger.info("insert data: "+ employeeRepository.save(employeeD));
                logger.info("insert data: "+ employeeRepository.save(employeeE));
            }
        };
    }

}
