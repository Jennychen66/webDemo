package com.kkb.seriveImpl;

import com.kkb.service.BaseService;
// 接口类的实现方法， 不需要考虑次要业务
public class Person implements BaseService{

    @Override
    public void eating(String food) {
        System.out.println("eating quickly " + food);

    }

    @Override
    public void wcing() {
        System.out.println("for adding ");

    }
    
    
}
