package com.kkb.until;
// 次要业务的合成 && 次要业务与主要业务的绑定执行

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.kkb.service.BaseService;

public class Agent implements InvocationHandler {
    
    // 被开发人员索要的真实对象
    private BaseService obj;
    
    public Agent(BaseService param){
        this.obj = param;
    }

    /*
    * proxy: 本次负责监听的对象： onClick
    * method : 被拦截的主要业务方法
    * args: 被拦截的主要业务方法所接收的实参
    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 次要业务与主要业务的绑定处理
        // 读取被拦截的方法名称
        String method_name = method.getName();
        if("eating".equals(method_name)){ // 饭前要洗手
            // 可以实现次要业务  前置、 后置、环绕
            wash();
            // obj: 
            method.invoke(obj, args);
        }else{ // 便后要洗手
            //System.out.println(method_name + " is running...");
            prey();
            method.invoke(obj, args);
            wash();
        }
        
        return null;
    }
    // 次要业务
    public void wash(){
        System.out.println("washing hand");
    }
    
    // 如果想要更改次要业务， 需要在Agent 里面更改，也可以提现出解耦合
    public void prey(){
        System.out.println("preying");
    }
}
 