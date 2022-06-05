package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.Orders;
import com.System.PharmacyManagement.repositories.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OrderDatabase {
    @Bean
    @Primary
    CommandLineRunner iniOrderDatabase(OrdersRepository ordersRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(OrderDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                Orders orders1 = new Orders("O1", "C2", "D1", "2019-10-10", 38);
                Orders orders2 = new Orders("O2", "C2", "D2", "2019-10-10", 38);
                Orders orders3 = new Orders("O3", "C2", "D3", "2019-10-10", 25);
                Orders orders4 = new Orders("O4", "C3", "D1", "2019-10-10", 30);
                Orders orders5 = new Orders("O5", "C3", "D2", "2019-10-10", 30);
                Orders orders6 = new Orders("O6", "C3", "D3", "2019-10-10", 29);
                Orders orders7 = new Orders("O7", "C4", "D3", "2019-10-10", 28);
                Orders orders8 = new Orders("O8", "C4", "D2", "2019-10-10", 25);
                Orders orders9 = new Orders("O9", "C4", "D3", "2019-10-10", 22);
                Orders orders10 = new Orders("O10", "C4", "D1", "2019-10-10", 39);
                Orders orders11 = new Orders("O11", "C5", "D2", "2019-10-10", 33);
                Orders orders12 = new Orders("O12", "C5", "D1", "2019-10-10", 21);
                Orders orders13 = new Orders("O13", "C5", "D3", "2019-10-10", 30);
                Orders orders14 = new Orders("O14", "C5", "D2", "2019-10-10", 22);
                Orders orders15 = new Orders("O15", "C6", "D3", "2019-10-10", 38);

                logger.info("insert data: "+ ordersRepository.save(orders1));
                logger.info("insert data: "+ ordersRepository.save(orders2));
                logger.info("insert data: "+ ordersRepository.save(orders3));
                logger.info("insert data: "+ ordersRepository.save(orders4));
                logger.info("insert data: "+ ordersRepository.save(orders5));
                logger.info("insert data: "+ ordersRepository.save(orders6));
                logger.info("insert data: "+ ordersRepository.save(orders7));
                logger.info("insert data: "+ ordersRepository.save(orders8));
                logger.info("insert data: "+ ordersRepository.save(orders9));
                logger.info("insert data: "+ ordersRepository.save(orders10));
                logger.info("insert data: "+ ordersRepository.save(orders11));
                logger.info("insert data: "+ ordersRepository.save(orders12));
                logger.info("insert data: "+ ordersRepository.save(orders13));
                logger.info("insert data: "+ ordersRepository.save(orders14));
                logger.info("insert data: "+ ordersRepository.save(orders15));
            }
        };
    }

}
