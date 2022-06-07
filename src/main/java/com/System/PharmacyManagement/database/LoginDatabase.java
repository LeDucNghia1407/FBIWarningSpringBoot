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
    String[] loginID = new String[]{"L1","L2","L3","L4","L5"};
    String[] employeeID = new String[]{"E1","E2","E3","E4","E5"};
    String[] password = new String[]{"PS1","PS2","PS3","PS4","PS5"};
    Login[] loginlist = new Login[5];
    @Bean
    @Primary
    CommandLineRunner iniLoginDatabase(LoginRepository loginRepository) {
        return new CommandLineRunner() {

            //Logger
            private static final Logger logger = LoggerFactory.getLogger(LoginDatabase.class);
            @Override
            public void run(String... args) throws Exception {

                for (int i = 0;i<5;i++)
                {
                    loginlist[i] = new Login(loginID[i],employeeID[i],password[i] );
                }
                for (int i = 0;i<5;i++)
                {
                    logger.info("insert data: "+ loginRepository.save(loginlist[i]));
                }

            }
        };
    }

}
