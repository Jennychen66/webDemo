package com.kkb.control;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class oneServlet implements Servlet {
    //oneServlet implements servlet 的时候，需要把接口中的所有方法全部实现一遍，但是重要的方法只有service一个， 增加了开发oneServlet的复杂度， 这就用到了适配器设计模式，用一个抽象类，隔离OneServlet 和 Servlet 之间的关系

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }
    
    
}
