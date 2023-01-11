package se.lexicon.service;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.exception.InsufficientFundsException;
import se.lexicon.model.Transaction;
import se.lexicon.model.TransactionType;

public interface TransactionService {

    //this interface is responsible to transfer money - deposit/withdraw

    Transaction moneyTransfer(Long customerId, double amount, TransactionType type) throws DataNotFoundException, InsufficientFundsException;
}
