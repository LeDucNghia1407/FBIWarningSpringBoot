package com.javatechie.jpa.database;


import com.javatechie.jpa.entity.*;
import com.javatechie.jpa.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class A_DrugSupplierDatabase {

    long[] drugSupplierIDlist = new long[]{1};
    String[] namelist = new String[]{"Europe"};
    String[] addresslist = new String[]{"Europe"};
    DrugSupplier[] drugsupplierlist = new DrugSupplier[1];

    @Bean
    @Primary
    CommandLineRunner iniDrugSupplierDatabase(DrugSupplierRepository drugsupplierRepository) {
        return new CommandLineRunner() {

            //Logger
            private  final Logger logger = LoggerFactory.getLogger(A_DrugSupplierDatabase.class);
            @Override
            public void run(String... args) throws Exception {



                for (int i = 0;i<1;i++)
                {
                    drugsupplierlist[i] = new DrugSupplier(drugSupplierIDlist[i],namelist[i],addresslist[i] );
                }
                for (int i = 0;i<1;i++)
                {
                    logger.info("insert data: "+ drugsupplierRepository.save(drugsupplierlist[i]));
                }

            }
        };
    }

    public DrugSupplier getDrugSupplier(int i)
    {
        DrugSupplier drugSupplier = new DrugSupplier(drugSupplierIDlist[i-1],namelist[i-1],addresslist[i-1]);
        return drugSupplier;

    }

}
