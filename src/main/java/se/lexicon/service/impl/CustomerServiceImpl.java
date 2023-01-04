package se.lexicon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;
import se.lexicon.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {

    //this clas has 2 dependencies
    // to be able to create a customer -> need to access create function in AccountDaoImpl/CustomerDaoImpl

    //AccountDao accountDao = new AccountDaoImpl(); // no need to instantiate manually
    AccountDao accountDao; // because we use bean containers
    CustomerDao customerDao;

    @Autowired //to make connection with the bean containers
    // -> without @Autowired, accountDao & customerDao are null
    //with constructor is more clear
    public CustomerServiceImpl(AccountDao accountDao, CustomerDao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }

    // 2nd technique -> setters dependency injection - for each class
    /*
    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

     */

    @Override
    public Customer registerCustomer(Customer customerData) {
        //step1: validate method parameters
        //step2: create new account for customer
        //step3: assign new created account to customer
        //step4: create customer
        //step5: return the created customer

        //step1:
        if (customerData == null) throw new IllegalArgumentException("Customer Data was null!");
        if (customerData.getAccount() == null) throw new IllegalArgumentException("Account Data was null!");

        //step2:
        Account accountData = customerData.getAccount(); // costumer data has only balance here -> without id
        Account createdAccount =  accountDao.create(accountData);

        //step3:
        customerData.setAccount(createdAccount); // here we have a customer with id and balance

        //step4:
        Customer createdCustomer = customerDao.create(customerData);


        return createdCustomer;
    }
}
