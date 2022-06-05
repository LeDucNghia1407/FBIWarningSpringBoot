package com.System.PharmacyManagement.database;


import com.System.PharmacyManagement.models.Login;
import com.System.PharmacyManagement.repositories.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LoginDatabase {
    @Bean
    @Primary
    CommandLineRunner iniLoginDatabase(LoginRepository loginRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(LoginDatabase.class);
            @Override
            public void run(String... args) throws Exception {


                Login loginA = new Login("L1", "E1", "PS1");
                Login loginB = new Login("L2", "E2", "PS2");
                Login loginC = new Login("L3", "E3", "PS3");
                Login loginD = new Login("L4", "E4", "PS4");
                Login loginE = new Login("L5", "E5", "PS5");

                logger.info("insert data: "+ loginRepository.save(loginA));
                logger.info("insert data: "+ loginRepository.save(loginB));
                logger.info("insert data: "+ loginRepository.save(loginC));
                logger.info("insert data: "+ loginRepository.save(loginD));
                logger.info("insert data: "+ loginRepository.save(loginE));
            }
        };
    }

}
