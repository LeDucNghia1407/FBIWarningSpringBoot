package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.*;
import com.System.PharmacyManagement.repositories.ClientRepository;
import com.System.PharmacyManagement.repositories.DrugRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.text.SimpleDateFormat;
import java.sql.Date;


import static com.System.PharmacyManagement.repositories.DrugRepository.*;

@Configuration
public class DrugDatabase {

    //Define Date variable

    //Define the data
    String[] drugId = new String[]{"D1","D2","D3"};
    String[] drugsupplierId = new String[]{"S1","S1","S1"};
    String[] drugname = new String[]{"Panadol","Vitamin C","Stomach"};
    Date[] manufacturingdate = new Date[] {Date.valueOf("2019-02-03"),Date.valueOf("2019-03-03"),Date.valueOf("2019-05-05")};
    Date[] expiredDate = new Date[]{Date.valueOf("2019-02-03"),Date.valueOf("2019-03-03"),Date.valueOf("2019-05-05")};
    String[] type = new String[]{"bar","bar","bar"};
    float[] price = new float[]{10,20,50};

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
            private static final Logger logger = LoggerFactory.getLogger(DrugDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<3;i++)
                {
                    druglist[i] = new Drug(drugId[i],drugsupplierId[i],drugname[i],manufacturingdate[i],expiredDate[i],type[i],price[i]);
                }
                for (int i = 0;i<3;i++)
                {
                    logger.info("insert data: "+ drugRepository.save(druglist[i]));
                }

            }
        };
    }

}
