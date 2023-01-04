package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.impl.AccountDaoImpl;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages ="se.lexicon")
public class AppConfig {

//if you don't want to use annotation @Component in AccountDaoImpl-> second way

    /*
    @Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl();

*/
    @Bean //if you want to add a framework outside the main app
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
