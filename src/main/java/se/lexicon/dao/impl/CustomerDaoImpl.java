package se.lexicon.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.sequencer.AccountIdGenerator;
import se.lexicon.dao.sequencer.CustomerIdSequencer;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> storage=new ArrayList<>();
    @Override
    public Customer create(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer was null");
        Long customerId= CustomerIdSequencer.nextId();                  //generate
        customer.setId(customerId);
        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        if (id == null) throw new IllegalArgumentException("Customer Id was null");
        return storage.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Customer> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(Long customerId) throws DataNotFoundException{

        Optional<Customer> optionalCustomer = findById(customerId);
        // we don't need to validate customerId, because it is validated inside findById method
        if (!optionalCustomer.isPresent())throw new DataNotFoundException("data not found exception");
        else storage.remove(optionalCustomer.get());
    }

    @Override
    public List<Customer> findByName(String firstName) {

        if (firstName == null) throw new IllegalArgumentException("firstName was null");

        /*
        List<Customer> filteredList = new ArrayList<>(); // traditional loop
        for(Customer element: storage){
            if (element.getFirstName().equals(firstName)){
                filteredList.add(element);
            }


        } */

        List<Customer> filteredList = storage.stream()
                                        .filter(element -> element.getFirstName().equals(firstName))
                                        .collect(Collectors.toList());

        //or return it directly

        return filteredList;
    }
}
