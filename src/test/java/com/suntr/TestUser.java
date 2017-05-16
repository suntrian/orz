package com.suntr;

import com.suntr.user.inf.IUser;
import com.suntr.user.model.Article;
import com.suntr.user.model.User;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Ignore;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * Created by suntr on 5/14/2017.
 * junit3 ways for test
 */
public class TestUser extends TestCase {
    SqlSession session ;
    IUser userMapper;
    @Override
    protected void tearDown() throws Exception {

        session.close();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sessionFactory.openSession(true);     //true auto commit
        userMapper = session.getMapper(IUser.class);
    }

    @Ignore
    public void testUserGet(){
        User user = userMapper.getOneUserById(12);
        Assert.assertNotNull(user);
    }

    @Ignore
    public void testUserAdd(){
        User user = new User(String.valueOf(new Random().nextInt()),"password");
        userMapper.addOneUser(user);
    }

    public void testGetUserArticlesByUserId(){
        List<Article> articles = userMapper.getUserArticlesByUserId(11);
        for (Article article: articles){
            System.out.println(article);
        }
    }
}
