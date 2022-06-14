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
import java.sql.Date;

@Data
@Configuration
public class I_OrderDatabase {

    //Data storage
    long[] orderID = new long[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    H_ClientDatabase clientDatabase = new H_ClientDatabase();
    Client[] client = new Client[]{clientDatabase.getClient(1),clientDatabase.getClient(1),clientDatabase.getClient(1),
            clientDatabase.getClient(2),clientDatabase.getClient(2),clientDatabase.getClient(2),
            clientDatabase.getClient(3),clientDatabase.getClient(3),clientDatabase.getClient(3),
            clientDatabase.getClient(4),clientDatabase.getClient(4),clientDatabase.getClient(4),
            clientDatabase.getClient(5),clientDatabase.getClient(5),clientDatabase.getClient(5)

    };
    C_DrugDatabase drugDatabase = new C_DrugDatabase();
    Drug[] drug = new Drug[]{drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3),
            drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3),
            drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3),
            drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3),
            drugDatabase.getDrug(1),drugDatabase.getDrug(2),drugDatabase.getDrug(3)};
    Date[] time = new Date[]{
            Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),
            Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),
            Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),
            Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),
            Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),Date.valueOf("2019-10-10"),
    };
    int[] drugQuantity = new int[]{30,30,30,30,30,30,30,30,30,30,30,30,30,30,30};
    Orders[] orderslist = new Orders[15];

    @Bean
    @Primary
    CommandLineRunner iniOrderDatabase(OrdersRepository ordersRepository) {
        return new CommandLineRunner() {

            //Logger
            private final Logger logger = LoggerFactory.getLogger(I_OrderDatabase.class);
            // construct and insert data
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<15;i++)
                {
                    orderslist[i] = new Orders(orderID[i],time[i],drugQuantity[i], drug[i],client[i]);
                }
                for (int i = 0;i<15;i++)
                {
                    logger.info("insert data: "+ ordersRepository.save(orderslist[i]));
                }

            }
        };
    }

}

