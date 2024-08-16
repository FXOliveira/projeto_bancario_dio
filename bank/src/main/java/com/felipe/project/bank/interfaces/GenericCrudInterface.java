package com.felipe.project.bank.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericCrudInterface<T> {
    void save(T obj);

    T findById(Long id);

    List<T> findAll();

    void delete(Long id);

}
