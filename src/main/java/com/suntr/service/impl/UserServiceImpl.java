package com.suntr.service.impl;

import com.suntr.dao.IUserDao;
import com.suntr.model.User;
import com.suntr.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by suntr on 5/20/2017.
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User getOneUserById(int id) {
        return this.userDao.getOneUserById(11);
    }

}
