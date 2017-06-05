package com.suntr.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by suntr on 5/20/2017.
 */
public interface BaseDao<T, PK extends Serializable> {

    /**
     * insert model bean
     * @param t
     * @return
     */
    public int insert(T t);

    public int delete(T t);

    public int update(T t);

    public T getOne(PK id);

    public List<T> getAll();

    public int countAll();
}
