package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.Orders;
import com.System.PharmacyManagement.repositories.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import java.sql.Date;

@Configuration
public class OrderDatabase {

    //Data storage
    String[] orderID = new String[]{"O1","O2","O3","O4","O5","O6","O7","O8","O9","O10","O10","O12","O13","O14","O15"};
    String[] clientID = new String[]{"C1","C1","C1","C2","C2","C2","C3","C3","C3","C4","C4","C4","C5","C5","C5"};
    String[] drugID = new String[]{"D1","D2","D3","D1","D2","D3","D1","D2","D3","D1","D2","D3","D1","D2","D3"};
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
            private static final Logger logger = LoggerFactory.getLogger(OrderDatabase.class);
            // construct and insert data
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<15;i++)
                {
                    orderslist[i] = new Orders(orderID[i],clientID[i],drugID[i],time[i],drugQuantity[i] );
                }
                for (int i = 0;i<15;i++)
                {
                    logger.info("insert data: "+ ordersRepository.save(orderslist[i]));
                }

            }
        };
    }

}
