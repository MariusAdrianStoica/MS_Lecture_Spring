package se.lexicon.dao;

import se.lexicon.model.Account;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public interface BaseDao<T, ID> { // 2 different types

    T create(T t);                  // first type
    Optional<T> findById(ID id);    // second type
    Collection<T> findAll();

    void remove(ID id);             // second type

}
