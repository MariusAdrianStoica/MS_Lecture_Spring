package se.lexicon.dao;

import se.lexicon.model.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer, Long> { // second type for id -> Long
    List<Customer> findByName(String firstName);




}
