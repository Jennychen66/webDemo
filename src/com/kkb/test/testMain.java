package com.kkb.test;

import com.kkb.seriveImpl.Dog;
import com.kkb.seriveImpl.Person;
import com.kkb.service.BaseService;
import com.kkb.until.ProxyFactory;
//拦截器/监听器是代理模式的简化版本，是代理模式的下游产品
// Java 代理模式的多级代理--》 MyBatis 
// 螳螂捕蝉，黄雀在后
// 蝉吃树脂，螳螂扑蝉，黄雀吃螳螂
// IOC 是反射，跟代理没关系 


public class testMain{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // // BaseService 只有接口，没有接口实现类啊 
        // // 接口不靠实现类也能new 出对象,靠代理实现
        
        // BaseService service = ProxyFactory.newInstance(); 
        // //ProxyFactory.newInstance() 返回的实际上是一个监听对象, 除了监听什么都做不了，
        // // 那如果用户真的想要调用 Service的eating 方法咋办呢， ProxyFactory 会告诉你去调用agent, 让他去调用 eating 方法
        
        // service.eating("apple");
        ////////
        
        // BaseService xiaoming = new Person(); // 丑陋的行为
        // // 想要得到 Person  类型的xiaoming 应该怎么做呢？ 要从代理工厂要
        // BaseService xiaoming1 = ProxyFactory.newInstance();
        // xiaoming1.eating("Chicken");
        
        BaseService wangcai = ProxyFactory.newInstance(Dog.class);
        wangcai.wcing();
        
    
    }
}

