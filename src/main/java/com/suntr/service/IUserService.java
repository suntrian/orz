package com.suntr.service;

import com.suntr.model.User;

import java.util.List;

/**
 * Created by suntr on 5/20/2017.
 */
public interface IUserService extends BaseService<User, Integer> {
    public User getOneUserById(int id);
}
