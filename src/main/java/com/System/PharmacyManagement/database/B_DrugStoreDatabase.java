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
public class B_DrugStoreDatabase {

    long[] drugStoreID = new long[]{1,2};
    A_DrugSupplierDatabase drugSupplierDatabase = new A_DrugSupplierDatabase();
    DrugSupplier[] drugSupplierID = new DrugSupplier[]{drugSupplierDatabase.getDrugSupplier(1),
            drugSupplierDatabase.getDrugSupplier(1)};
    String[] name = new String[]{"Earth","Moon"};
    String[] address = new String[]{"VGU","VGU"};
    DrugStore[] drugstorelist = new DrugStore[2];
    @Bean
    @Primary
    CommandLineRunner iniDrugStoreDatabase(DrugStoreRepository drugstoreRepository) {
        return new CommandLineRunner() {



            //Logger
            private final Logger logger = LoggerFactory.getLogger(B_DrugStoreDatabase.class);
            @Override
            public void run(String... args) throws Exception {




                for (int i = 0;i<2;i++)
                {
                    drugstorelist[i] = new DrugStore(drugStoreID[i],address[i], name[i],drugSupplierID[i]);
                }
                for (int i = 0;i<2;i++)
                {
                    logger.info("insert data: "+ drugstoreRepository.save(drugstorelist[i]));
                }
            }
        };
    }

    public DrugStore getDrugStore(int i)
    {
        DrugStore drugStore = new DrugStore(drugStoreID[i-1],address[i-1], name[i-1],drugSupplierID[i-1]);
        return drugStore;
    }
}
