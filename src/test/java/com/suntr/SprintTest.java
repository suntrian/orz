package com.suntr;

import com.suntr.dao.IUserDao;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by suntr on 5/18/2017.
 */
public class SprintTest {

    private static ApplicationContext context;
    private static IUserDao userMapper;

    @BeforeClass
    public static void getSesstion(){
        context = new ClassPathXmlApplicationContext("spring-mvc.xml");        //spring use
        //context = new ClassPathXmlApplicationContext("ApplicationContext.xml");     //springMVC use
        userMapper = (IUserDao)context.getBean("userMapper");
    }

    @Test
    public void testGetAllArticlesByUserId(){
        List<Article> articles = userMapper.getUserArticlesByUserId(11);
        for (Article article:articles){
            System.out.println(article);
        }
    }

}
