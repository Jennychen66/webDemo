package com.kkb.seriveImpl;

import com.kkb.service.BaseService;

// 如何让Person 和Dog 类能同时 被 proxy 监听呢 ？ 就是动态代理

public class Dog implements BaseService{

    @Override
    public void eating(String food) {
        System.out.println("ken" + food);

    }

    @Override
    public void wcing() {
        System.out.println("santuili");

    }
    
}
