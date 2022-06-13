package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.*;
import com.System.PharmacyManagement.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.Date;


@Configuration
public class C_DrugDatabase {

    //Define Date variable

    //Define the data
    long[] drugId = new long[]{1,2,3};
    A_DrugSupplierDatabase drugSupplierDatabase = new A_DrugSupplierDatabase();
    DrugSupplier[] drugSupplierID = new DrugSupplier[]{drugSupplierDatabase.getDrugSupplier(1),
            drugSupplierDatabase.getDrugSupplier(1),
            drugSupplierDatabase.getDrugSupplier(1)};
    String[] drugname = new String[]{"Panadol","Vitamin C","Stomach"};
    Date[] manufacturingdate = new Date[] {Date.valueOf("2019-02-03"),Date.valueOf("2019-03-03"),Date.valueOf("2019-05-05")};
    Date[] expiredDate = new Date[]{Date.valueOf("2019-02-03"),Date.valueOf("2019-03-03"),Date.valueOf("2019-05-05")};
    String[] type = new String[]{"bar","bar","bar"};
    int[] price = new int[]{10,20,50};

    Drug[] druglist = new Drug[3];






    // Print and display the utility package date in
    // java


    // Date class of sql package contains only date
    // information without time


    // Print and display the SQL java package

    @Bean
    @Primary
    CommandLineRunner iniDrugDatabase(DrugRepository drugRepository) {
        return new CommandLineRunner() {

            //Logger
            private final Logger logger = LoggerFactory.getLogger(C_DrugDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<3;i++)
                {
                    druglist[i] = new Drug(drugId[i],drugname[i],manufacturingdate[i],expiredDate[i],type[i],price[i],drugSupplierID[i]);
                }
                for (int i = 0;i<3;i++)
                {
                    logger.info("insert data: "+ drugRepository.save(druglist[i]));
                }

            }
        };
    }

    public Drug getDrug(int i)
    {
        Drug drug = new Drug(drugId[i-1],drugname[i-1],manufacturingdate[i-1],expiredDate[i-1],type[i-1],price[i-1],drugSupplierID[i-1]);
        return drug;
    }

}
