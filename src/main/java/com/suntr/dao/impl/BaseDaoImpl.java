package com.suntr.dao.impl;

import com.suntr.dao.BaseDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by suntr on 5/20/2017.
 */
public abstract class BaseDaoImpl<T, PK extends Serializable>
        extends SqlSessionDaoSupport implements BaseDao<T,PK> {

    private String namespace;

    public void setNamespace(String namespace){
        this.namespace = namespace;
    }
    public String getNamespace(){
        return this.namespace;
    }

    @Override
    public int insert(T t) {
        try {
            return getSqlSession().insert(getNamespace() + ".insert", t);
        } catch (Exception e){
            throw new RuntimeException("insert failed");
        }
    }

    @Override
    public int delete(T t) {
        try {
            return getSqlSession().delete(getNamespace() + ".delete",t);
        } catch (Exception e){
            throw new RuntimeException("delete failed");
        }
    }

    @Override
    public int update(T t) {
        try {
            return getSqlSession().update(getNamespace() + ".update",t);
        } catch (Exception e){
            throw new RuntimeException("update failed");
        }
    }

    @Override
    public T getOne(PK id) {
        try {
            return getSqlSession().selectOne(getNamespace() + ".getOne", id);
        } catch (Exception e){
            throw new RuntimeException("query failed");
        }
    }

    @Override
    public List<T> getAll() {
        try {
            return getSqlSession().selectList(getNamespace() + ".getAll");
        }catch (Exception e){
            throw new RuntimeException("getAll failed");
        }
    }

    @Override
    public int countAll() {
        try {
            return getSqlSession().selectOne(getNamespace() + ".countAll");
        } catch (Exception e){
            throw new RuntimeException("countAll failed");
        }

    }
}
