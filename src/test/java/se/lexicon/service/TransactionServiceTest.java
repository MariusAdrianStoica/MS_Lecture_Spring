package se.lexicon.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Transaction;

@ExtendWith(SpringExtension.class) //in order to write the unit test in spring framework
@ContextConfiguration(classes = AppConfig.class)
public class TransactionServiceTest {

    @Autowired
    TransactionService testObject;

    //todo: add unit tests for transaction service
}
