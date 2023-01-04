package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.impl.AccountDaoImpl;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;
import se.lexicon.service.CustomerService;

import java.lang.annotation.Annotation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // creating an account manually
        //AccountDao accountDao = new AccountDaoImpl(); //instantiate AccountDao

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        /*AccountDao accountDao = context.getBean(AccountDao.class);
        //using IoC Container -> we don't need to instantiate manually

        CustomerDao customerDao = context.getBean(CustomerDao.class);
        Account accountData = new Account(10);

        Account createdAccount = accountDao.create(accountData);
        System.out.println("createdAccount: "+createdAccount);

        Customer customerData = new Customer("Test", "Test", createdAccount);
        Customer createdCustomer = customerDao.create(customerData);
        System.out.println(createdCustomer); */


        // all logic for creating an account and a customer can be defined in the service package


        CustomerService customerService = context.getBean(CustomerService.class);
        System.out.println(customerService.registerCustomer(new Customer("Test", "Testsson", new Account(100))));

    }
}
