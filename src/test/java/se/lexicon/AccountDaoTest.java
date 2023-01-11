package se.lexicon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.AccountDao;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;

import java.util.Optional;

@ExtendWith(SpringExtension.class) //in order to write the unit test in spring framework
@ContextConfiguration(classes = AppConfig.class)

public class AccountDaoTest {


   /*@Autowired //transforming AccountDao into a bean -> field dependency injection
    AccountDao accountDao;

    */



    /*
    AccountDao accountDao;

    @Autowired //constructor Dependency injection
    public AccountDaoTest(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    */

    // setter injection

    @Autowired
    AccountDao testObject;
    Account createdAccount;

    @BeforeEach
    public void setup(){
        Account accountData = new Account(100.00);
        createdAccount = testObject.create(accountData);
    }

    @Test
    public void findAll(){

        int expectedResult = 1;
        int actualResult = testObject.findAll().size();

        assertEquals(expectedResult, actualResult);

        // if we import the static Assertions.* -> we can write directly asserEquals
    }
    @Test
    public void findById(){
        Account expectedAccount = new Account(createdAccount.getId(), 100.00);

        Optional<Account> optionalAccount = testObject.findById(createdAccount.getId());
        //assertNotNull(optionalAccount.get()); -> if optional is null
        //Account actualAccount = optionalAccount.get();

        Account actualAccount = optionalAccount.orElse(null);
        // -> Optional is a container - if you want to have the object inside, you need to use get()
        // -> orElse - if optional account does not exist (we can not find it), operation returns null
        assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void remove(){
        assertDoesNotThrow(()-> {
            testObject.remove(createdAccount.getId());
        });
    }

    @Test
    public void remove_throws_exception(){
        assertThrows(DataNotFoundException.class, () -> testObject.remove(1L));
        //single line statement - Lambda expression
    }

    //todo: add more unit tests



}
