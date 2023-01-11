package se.lexicon.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;

@ExtendWith(SpringExtension.class) //in order to write the unit test in spring framework
@ContextConfiguration(classes = AppConfig.class)
public class CustomerServiceTest {


    @Autowired
    CustomerService testObject;

    Customer createdCustomer;
    @BeforeEach
    public void setup(){
        Account accountData = new Account(20.00);
        Customer customerData = new Customer("Test", "Test",accountData);
        // to create a customer we need first an account

        createdCustomer = testObject.registerCustomer(customerData);
    }

    @Test
    public void findById(){

        assertDoesNotThrow( ()-> testObject.findById(createdCustomer.getId()));

    }

    //todo: add more unit tests
}
