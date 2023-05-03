package com.example.demoaxios;

import java.util.Optional;

public interface IGeneric<T> {
    Iterable<T> findAll();

    Optional<T> findById(long id);

    T save(T t);

    void remote(long id);
}
