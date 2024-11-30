package org.ignacioScript.co.dao;

import org.ignacioScript.co.interfaces.DataTransferObject;

import java.util.List;


public abstract class DataAccessObject <T extends DataTransferObject> {


    public abstract void save(T t);
    public abstract void update(T t, int id);
    public abstract void delete(int id);
    public abstract List<T> findAll();
    public abstract T findById(int id);

}
