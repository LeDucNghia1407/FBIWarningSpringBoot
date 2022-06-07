package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.DrugSupplier;
import com.System.PharmacyManagement.repositories.DrugSupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DrugSupplierDatabase {
    String[] drugSupplierID = new String[]{"S1"};
    String[] name = new String[]{"Europe"};
    String[] address = new String[]{"Europe"};
    DrugSupplier[] drugsupplierlist = new DrugSupplier[1];
    @Bean
    @Primary
    CommandLineRunner iniDrugSupplierDatabase(DrugSupplierRepository drugsupplierRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(DrugSupplierDatabase.class);
            @Override
            public void run(String... args) throws Exception {
                for (int i = 0;i<1;i++)
                {
                    drugsupplierlist[i] = new DrugSupplier(drugSupplierID[i],name[i],address[i] );
                }
                for (int i = 0;i<1;i++)
                {
                    logger.info("insert data: "+ drugsupplierRepository.save(drugsupplierlist[i]));
                }

            }
        };
    }

}
