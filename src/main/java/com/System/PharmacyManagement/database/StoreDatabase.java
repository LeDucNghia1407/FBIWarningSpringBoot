package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.Store;
import com.System.PharmacyManagement.repositories.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import java.sql.Date;

@Configuration
public class StoreDatabase {
    String[] storeID = new String[]{"St1","St2","St3","St4","St5","St6"};
    String[] drugID = new String[]{"D1","D2","D3","D1","D2","D3"};
    String[] drugStoreID = new String[]{"DS1","DS1","DS1","DS2","DS2","DS2"};
    Date[] Storetime = new Date[]{
            Date.valueOf("2020-06-07"),Date.valueOf("2020-06-07"),Date.valueOf("2020-06-07"),
            Date.valueOf("2020-06-07"),Date.valueOf("2020-06-07"),Date.valueOf("2020-06-07")
    };

    int[] Quantity = new int[]{30,30,30,30,30,30};
    Store[] storelist = new Store[6];
    @Bean
    @Primary
    CommandLineRunner iniStoreDatabase(StoreRepository storeRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(StoreDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0; i<6;i++)
                {
                    storelist[i] = new Store(storeID[i],drugID[i],drugStoreID[i], Storetime[i],Quantity[i]);
                }
                for (int i = 0; i<6;i++)
                {
                    logger.info("insert data: "+ storeRepository.save(storelist[i]));
                }

            }
        };
    }

}
