package com.suntr.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by suntr on 5/20/2017.
 */
public abstract interface BaseService<T, PK extends Serializable> {

    public abstract int insert(T t);
    public abstract int datete(T t);
    public abstract int update(T t);
    public abstract T getOne(PK id);
    public abstract List<T> getAll();
    public abstract int countAll();
}
