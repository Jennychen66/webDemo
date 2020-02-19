package com.kkb.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import com.kkb.until.KKBGenericServlet;

public class twoServlet extends KKBGenericServlet{

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("two sevlet is running ...");

    }
    
}
