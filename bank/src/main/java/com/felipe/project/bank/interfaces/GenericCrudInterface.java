package com.felipe.project.bank.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericCrudInterface<T> {
    T save(T obj);

    Optional<T> findById(long id);

    List<T> findAll();

    void delete(long id);

    T update(T obj);
}
