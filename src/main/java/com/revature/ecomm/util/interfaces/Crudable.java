package com.revature.ecomm.util.interfaces;

import java.io.IOException;
import java.util.List;

public interface Crudable<T> {
    T create( T newObject);

    List<T> findAll() throws IOException;
    T findById(String id);

    public boolean update(T updatedObject);

    boolean delete(String id);
}
