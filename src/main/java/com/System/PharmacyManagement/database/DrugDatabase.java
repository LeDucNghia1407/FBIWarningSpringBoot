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

import static com.System.PharmacyManagement.repositories.DrugRepository.*;

@Configuration
public class DrugDatabase {
    @Bean
    @Primary
    CommandLineRunner iniDrugDatabase(DrugRepository drugRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(DrugDatabase.class);
            @Override
            public void run(String... args) throws Exception {


                Drug drugA = new Drug("D1", "S1", "Panadol", "2019-02-03", "2019-03-12", "bar", 10);
                Drug drugB = new Drug("D2", "S2", "Vitamin C", "2019-05-05", "2019-05-13", "bar", 20);
                Drug drugC = new Drug("D3", "S3", "Stomach", "2019-02-02", "2019-02-12", "bar", 50);

                logger.info("insert data: "+ drugRepository.save(drugA));
                logger.info("insert data: "+ drugRepository.save(drugB));
                logger.info("insert data: "+ drugRepository.save(drugC));
            }
        };
    }

}
