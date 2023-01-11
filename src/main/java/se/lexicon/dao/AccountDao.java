package se.lexicon.dao;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;

public interface AccountDao extends BaseDao<Account, Long> { // second type for id -> Long

    void updateBalance (Account account) throws DataNotFoundException;


}
