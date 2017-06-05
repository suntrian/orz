package com.suntr.service.impl;

import com.suntr.dao.BaseDao;
import com.suntr.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by suntr on 5/20/2017.
 */

public class BaseServiceImpl<T, PK extends Serializable>
        implements BaseService<T,PK> {

    protected BaseDao dao;
    public BaseServiceImpl() {
    }
    public BaseServiceImpl(BaseDao dao){
        this.dao = dao;
    }

    @Override
    public int insert(T t) {
        return this.dao.insert(t);
    }

    @Override
    public int datete(T t) {
        return this.dao.delete(t);
    }

    @Override
    public int update(T t) {
        return this.dao.update(t);
    }

    @Override
    public T selectByPrimaryKey(PK id) {return (T)this.dao.selectByPrimaryKey(id); }

    @Override
    public List<T> selectAll() {
        return this.dao.selectAll();
    }

    @Override
    public int count() {
        return this.dao.count();
    }
}
