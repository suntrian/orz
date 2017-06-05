package com.suntr.controller;

import com.suntr.model.User;
import com.suntr.service.IUserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * Created by suntrian on 17-6-5.
 * 系统启动后做一些初始化操作
 */
public class InitialController implements InitializingBean, ServletContextAware{

    @Resource
    private IUserService userService;

    @Override
    public void setServletContext(ServletContext servletContext) {
        //User user = userService.getOneUserById(1);
        //servletContext.setAttribute("user", user.getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
