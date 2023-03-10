package se.lexicon.dao;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public interface BaseDao<T, ID> { // 2 different types

    T create(T t);                  // first type
    Optional<T> findById(ID id);    // second type
    Collection<T> findAll();

    void remove(ID id) throws DataNotFoundException;             // second type
    // when we want to modify an override function (add throws exception)
    // , we need to add this even in the original contract (BaseDao)

}
