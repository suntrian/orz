package com.suntr.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

    /**
     *
     * 添加 （匹配有值的字段）
     *
     **/
    public int insertSelective(T t);

    /**
     *
     * 查询（根据主键ID查询）
     *
     **/
    public T selectByPrimaryKey(@Param("id")PK id);

    /**
     *
     * 查询全部
     * */
    public List<T> selectAll();

    /**
     *
     * 查询全部，条件查询，分页查询
     * */
    public List<T> selectAll(Map<String, Object> map);

    /**
     * 查询全部，条件查询，分页查询的行数
     * */
    public List<T> selectRowCount(Map<String, Object> map);

    public int delete(T t);

    public int deleteByPrimaryKey(@Param("id")PK id);

    public int update(T t);

    public int updateSelective(T t);

    /**
     * 所有结果数
     * @return
     */
    public int count();

    /**
     * 条件查询数目
     * @param map
     * @return
     */
    public int count(Map<String, Object> map);
}
