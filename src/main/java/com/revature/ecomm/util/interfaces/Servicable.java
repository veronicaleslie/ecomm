package com.revature.ecomm.util.interfaces;

import java.util.List;

public interface Servicable<T> {
    T create(T newObject);
    List<T> readAll();
    T readById(String id);


    T update(T updatedObject);

    boolean delete(String id);

    boolean validateInput(T object);


}
