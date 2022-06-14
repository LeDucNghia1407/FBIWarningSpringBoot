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
public class F_EmployeeDatabase {

    long[] employeeID = new long[]{1,2,3,4,5};
    B_DrugStoreDatabase drugStoreDatabase = new B_DrugStoreDatabase();
    DrugStore[] drugStore = new DrugStore[]{drugStoreDatabase.getDrugStore(1),
            drugStoreDatabase.getDrugStore(1),
            drugStoreDatabase.getDrugStore(2),
            drugStoreDatabase.getDrugStore(1),
            drugStoreDatabase.getDrugStore(2)};
    E_ManagerDatabase managerDatabase = new E_ManagerDatabase();
    Manager[] manager = new Manager[]{null,null,null,managerDatabase.getManager(1),managerDatabase.getManager(2)};
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
            private final Logger logger = LoggerFactory.getLogger(F_EmployeeDatabase.class);
            //Add data from list and insert to model
            @Override
            public void run(String... args) throws Exception {
                for (int i = 0;i<5;i++)
                {
                    employeelist[i] = new Employee(employeeID[i],name[i],email[i],phone[i],permission[i],salary[i],drugStore[i],manager[i]);

                }
                for (int i = 0;i<5;i++)
                {
                    logger.info("insert data: "+ employeeRepository.save(employeelist[i]));

                }

            }
        };
    }

    public Employee getEmployee(int i)
    {
        Employee employee = new Employee(employeeID[i-1],name[i-1],email[i-1],phone[i-1],permission[i-1],salary[i-1],drugStore[i-1],manager[i-1]);
        return employee;
    }

}
