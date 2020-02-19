package com.kkb.until;
// 代理监听对象，扮演能吃和拉的对象, 

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import java.lang.Class;

import com.kkb.seriveImpl.Person;
import com.kkb.service.BaseService;

public class ProxyFactory{
    
    public static BaseService newInstance(){
        // 在newInstance 中若要考虑这么多种 不同类型， 那么就需要做重载
        
        
        // 0. 创建被索要类型的实例对象, 把改对象给代理对象，让他去把xiaoming 囚禁起来
        BaseService xiaoming = new Person();
        
        // 拥有一个代理实现类对象
        InvocationHandler agent = new Agent(xiaoming);
        // 申请、注册一个对特定行为进行监控的对象（代理对象）
        /**
         * loader, 指向被监控的类对象在内存中的地址
         * interfaces,被监控类中所实现的接口（只监控特定方法，一般会放到一个接口中，这个接口中所实现的方法就是需要被监控的主要业务行为）
         *  h, 交给代理实现类来处理
         */
        Class class_array[] ={BaseService.class};
    //     // 会假扮BaseService对象，返回给开发人员
    //    BaseService serv =  (BaseService)Proxy.newProxyInstance(BaseService.class.getClassLoader(), class_array, agent);
    
    // 有Person实现类之后，监听的类就变成了 Person; 监控的方法就变成了 Person 中实现的方法; 仍然是由agent 来实现
    BaseService serv =  (BaseService)Proxy.newProxyInstance(Person.class.getClassLoader(), class_array, agent);
       
    
    // 目前返回的并不是xiaoming 而是一个假的监听对象
       return serv;
        
    }
    
    public static BaseService newInstance(Class classfile) throws 
            InstantiationException, IllegalAccessException {
        
        // 在newInstance 中若要考虑这么多种 不同类型， 那么就需要做重载, classfile 就是用户想要监听的对象
        
        
        // 0. 创建被索要类型的实例对象, 把改对象给代理对象，让他去把xiaoming 囚禁起来
        BaseService neededSrv = (BaseService)classfile.newInstance();
        // 根据反射机制，调用默认构造方法
        
        // 拥有一个代理实现类对象
        InvocationHandler agent = new Agent(neededSrv);
        // 申请、注册一个对特定行为进行监控的对象（代理对象）
        /**
         * loader, 指向被监控的类对象在内存中的地址
         * interfaces,被监控类中所实现的接口（只监控特定方法，一般会放到一个接口中，这个接口中所实现的方法就是需要被监控的主要业务行为）
         *  h, 交给代理实现类来处理
         */
        Class class_array[] ={BaseService.class};
    //     // 会假扮BaseService对象，返回给开发人员
    //    BaseService serv =  (BaseService)Proxy.newProxyInstance(BaseService.class.getClassLoader(), class_array, agent);
    
    // 有Person实现类之后，监听的类就变成了 Person; 监控的方法就变成了 Person 中实现的方法; 仍然是由agent 来实现
    BaseService serv =  (BaseService)Proxy.newProxyInstance(classfile.getClassLoader(), class_array, agent);
       
    
    // 目前返回的并不是xiaoming 而是一个假的监听对象
       return serv;
        
    }
}
