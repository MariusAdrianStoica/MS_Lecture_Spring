package se.lexicon.service;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Customer;

public interface CustomerService {

    Customer registerCustomer(Customer customerData);

    Customer findById(Long id) throws DataNotFoundException;

    }

