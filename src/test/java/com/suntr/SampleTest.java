package com.suntr;

import com.suntr.dao.IUserDao;
import com.suntr.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by suntr on 5/14/2017.
 */
public class SampleTest {


    public static void main(String[] args) throws IOException{
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Resources.getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        //String statement = "com.suntr.UserMapper.getName";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        //User user = session.selectOne(statement, 2);
        //System.out.println(user);

        IUserDao userMapper = session.getMapper(IUserDao.class);
        User user = userMapper.getOneUserById(5);
        System.out.println(user);

        List<User> users = userMapper.getAllUsers();
        for(User u: users){
            System.out.println(u);
        }
        User user1 = userMapper.getOneUserByName("cccdd");
        userMapper.deleteOneUser(user1);
        session.commit();
        user1 = new User();
        userMapper.addOneUser(user1);
        session.commit();

        userMapper.modifyUser(user);
        session.commit();

        userMapper.deleteOneUser(user);
        userMapper.deleteOneUserByName("aaaa");
        session.commit();

    }
}
