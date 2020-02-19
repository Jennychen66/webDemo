package com.kkb.control;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.kkb.control.*;

//1. 代理模式  Mybatis： 引以为豪的是接口式编程， 讲课过程中不会碰静态代理

//2. 代理设计模式是解决什么问题？ 
// 权限控制，代码增强，耦合，按需注入，AOP 是代理的简化版本， 拦截是代理的一个产品
// teacher： 将次要业务和主要业务做一个解耦合处理

//3. 次要业务和主要业务： 次要业务： 起辅助功能，辅助主要业务顺利实现；在项目中次要业务往往大量重复出现，跟编程理念相冲突； 主要业务就是当前项目中的主要任务；
//4. //次要业务对开发效率影响： 
// Mybatis 是对JDBC的封装；JDBC: 就是个搬运工， 搬运SQL命令到数据库中执行， 并返回结果；JDBC的开发步骤： 1）加载当前的驱动类； 2） 去建立连接通道 3）去建立数据库的操作对象 4） 推送SQL 命令到数据库中执行并返回处理结果 5）销毁con,statement,rs;  在上面的过程中，只有4 是主要功能，其他都是次要业务

//5. 代理模式的本质是 ： 行为的监听   代理对象$proxy InvocationHandler
   // <input type="button" onclick="fun1"> button 上会产生被click 的行为，fun1就是invocationHandler 的接口，
// 6. 代理模式的组成： 
//  1) 接口：声明需要被监听的行为
//  2) 代理实现类（InvocationHandler ）:次要业务的实现；将次要业务和主要业务做绑定执行
//  3) 代理对象: 监听对象 

// 7. 实现个简单业务： 饭前便后要洗手 
   // 【主要业务】： 吃饭，大便
   // 【次要业务】：洗手
// 8. 代理模式 --- 实现 MyBatis 中接口式编程 （简化JDBC开发步骤）


// 设计模式是针对大类问题提出的通用解决方案， 切入点不同， 则对当前的设计模式出现理解偏差，随着编程经验的加深，理解的方向也不同， 《研磨设计模式》
// Sevlet 中是有 模板设计模式和适配器设计模式，具体的设计模式在不同场景下

public class ThreeServlet extends KKBHttpServlet {
    public void doGet(ServletRequest arg0, ServletResponse arg1){
        System.out.println("ThreeServlet is running");
    }
}
