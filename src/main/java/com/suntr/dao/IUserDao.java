package com.suntr.dao;

import com.suntr.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntr on 5/14/2017.
 */

@Repository
public interface IUserDao /*extends BaseDao<User,Integer> */{
    public User getOneUserById(int id);
    public User getOneUserByName(String name);
    public List<User> getAllUsers();
    public void addOneUser(User user);
    public void modifyUser(User user);
    public void deleteOneUser(User user);
    public void deleteOneUserById(int id);
    public void deleteOneUserByName(String name);

}
