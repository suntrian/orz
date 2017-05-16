package com.suntr.user.inf;

import com.suntr.user.model.Article;
import com.suntr.user.model.User;

import java.util.List;

/**
 * Created by suntr on 5/14/2017.
 */
public interface IUser {
    public User getOneUserById(int id);
    public User getOneUserByName(String name);
    public List<User> getAllUsers();
    public void addOneUser(User user);
    public void modifyUser(User user);
    public void deleteOneUser(User user);
    public void deleteOneUserById(int id);
    public void deleteOneUserByName(String name);
    public List<Article> getUserArticlesByUserId(int userId);
}
