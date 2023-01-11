package se.lexicon.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.sequencer.AccountIdGenerator;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component //in order to use SPRING-> adding @Component,class AccountDaoImpl become a bean
public class AccountDaoImpl implements AccountDao {

    private List<Account> storage=new ArrayList<>(); //define the storage to collect data from methods


    @Override
    public Account create(Account account) {
        //step1: validate the method parameters
        //step2: generate account number and set it to account id
        //step3: add account to storage
        //step4: return the result

        if (account == null) throw new IllegalArgumentException("Account was null"); //validate
        Long accountId= AccountIdGenerator.generateAccountNumber();                  //generate
        account.setId(accountId);
        storage.add(account);                                                        //add to storage
        return account;                                                             //return
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        if (accountId == null) throw new IllegalArgumentException("Account Id was null");
        return storage.stream()                                 //stream source
                .filter(account -> account.getId().equals(accountId))  //use intermediate op to create a small stream
                .findFirst();                                   //terminal op -> to make a result

        // stream method returns Optional -> we can move "return" in front of stream method
    }

    @Override
    public Collection<Account> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(Long accountId) throws DataNotFoundException {
      Optional<Account> accountToRemove = findById(accountId);
      if (!accountToRemove.isPresent())throw new DataNotFoundException("Data not found Exception");
      else storage.remove(accountToRemove.get());
    }

    @Override
    public void updateBalance(Account account)  throws DataNotFoundException{
        //step1: validate the method parameter (account)

        if (account==null)throw new IllegalArgumentException("Account data was null");
        //step2: check the accountId
        Optional<Account> optionalAccount = findById(account.getId());
        if (!optionalAccount.isPresent())throw new DataNotFoundException("Data not found Exception");
        //step3: update account
        else storage.forEach(element -> {
            if (element.getId().equals(account.getId())){
                // when we compare 2 objects it is better to use .equals(), instead of ==
                //== is used to compare primitive data types(ex int)

                element.setBalance(account.getBalance());
            }
        });


    }


}
