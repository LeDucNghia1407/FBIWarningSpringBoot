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
    @Bean
    @Primary
    CommandLineRunner iniDrugSupplierDatabase(DrugSupplierRepository drugsupplierRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(DrugSupplierDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                DrugSupplier drugsupplierA = new DrugSupplier("S1", "Europe", "Europe");

                logger.info("insert data: "+ drugsupplierRepository.save(drugsupplierA));
            }
        };
    }

}
