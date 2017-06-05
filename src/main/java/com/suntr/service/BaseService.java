package com.suntr.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by suntr on 5/20/2017.
 */
public interface BaseService<T, PK extends Serializable> {

    public int insert(T t);
    public int datete(T t);
    public int update(T t);
    public T selectByPrimaryKey(PK id);
    public List<T> selectAll();
    public int count();
}
