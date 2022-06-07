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

    String[] emID = new String[]{"E1","E2","E3","E4","E5"};
    String[] drugStoreID = new String[]{"DS1","DS1","DS2","DS1","DS2"};
    String[] Managerby = new String[]{"","","","M1","M2"};
    String[] name = new String[]{"cat1","cat2","cat3","cat4","cat5"};
    String[] email = new String[]{"cat1gmail.com","cat2gmail.com","cat3gmail.com","cat4gmail.com","cat5gmail.com"};
    String[] phone = new String[]{"201","202","203","204","205"};
    int[] permission = new int[]{0,0,0,1,1};
    int[] salary = new int[]{500,500,500,2000,2000};
    Employee[] employeelist = new Employee[5];

    @Bean
    @Primary
    CommandLineRunner iniEmployeeDatabase(EmployeeRepository employeeRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(EmployeeDatabase.class);
            //Add data from list and insert to model
            @Override
            public void run(String... args) throws Exception {
                for (int i = 0;i<5;i++)
                {
                    employeelist[i] = new Employee(emID[i],drugStoreID[i],Managerby[i],name[i],email[i],phone[i],permission[i],salary[i]);

                }
                for (int i = 0;i<5;i++)
                {
                    logger.info("insert data: "+ employeeRepository.save(employeelist[i]));

                }

            }
        };
    }

}
