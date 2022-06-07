package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.DrugStore;
import com.System.PharmacyManagement.repositories.DrugStoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DrugStoreDatabase {
    String[] drugStoreID = new String[]{"DS1","DS2"};
    String[] drugSupplierID = new String[]{"S1","S1"};
    String[] name = new String[]{"Earth","Moon"};
    String[] address = new String[]{"VGU","VGU"};
    DrugStore[] drugstorelist = new DrugStore[2];

    @Bean
    @Primary
    CommandLineRunner iniDrugStoreDatabase(DrugStoreRepository drugstoreRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(DrugStoreDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<2;i++)
                {
                    drugstorelist[i] = new DrugStore(drugStoreID[i],drugSupplierID[i], name[i],address[i]);
                }
                for (int i = 0;i<2;i++)
                {
                    logger.info("insert data: "+ drugstoreRepository.save(drugstorelist[i]));
                }
            }
        };
    }

}
