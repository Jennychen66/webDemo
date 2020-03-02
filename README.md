# webDemo
Mybits and Servlet learning

Mybaits and Hibernate 比较:
1. Hibernate: 杜绝开发人员亲自试用JDBC，杜绝亲自试用sql命令
              Hibernate 无法进行SQL 优化
              Hibernate 缓存依赖过大，一级缓存如何同步二级缓存
2. Mybatis : 杜绝开发人员亲自试用JDBC，认为开发人员专注于SQL优化，Mybatis对于缓存依赖非常低

如何看框架源码 ：
    1. 框架都是对某一种老技术的封装，需要对被开发的老技术牢记于心
    2. 按照老技术的流程反观改框架
    3. 看框架中内部某一个类的时候，一定要观察类的继承关系（子类的作用跟父类是一模一样的）
    
JDBC的开发流程：
    加载驱动类：  Class.forName("com.mysql.jdbc.Driver")
    建立连接通道： Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kkb","username","password"
                )
                con.setAutoCommit(false);
    数据库操作对象  PreparedStatement ps = con.preparedStatement(sql)
                   ps.setInt();
                   ps.setString();
                   try{
                       int num = ps.excuteUpdate(); DML 语句
                   ResultSet rs = ps.excuteQuery(); DQL 语句
                   ps.excuteBatch(); 批处理
                   con.commit();
                   }catch(Exception ex){
                       //处理事务的回滚
                       con.rollback();
                   }
                   // 销毁
                   con.close();
                   
# 读已提交， 读未提交，重复读，序列化
【ref】 https://blog.csdn.net/JIESA/article/details/51317164
# Mybaits 层次结构图
【ref】 https://www.cnblogs.com/smile361/p/9199717.html                   
    
一点一点为某个对象赋值的模式 就叫做 ： 建造者模式
如果某个对象包含大量属性，那么如何创造改对象呢？ --> 建造者模式 （创建该种对象的的唯一优选模式）
《研磨设计模式》

MyBaits 中最引以为傲的接口式编程 ： 就是用的代理模式
首先有一个interface, 不需要写实现类的接口，有抽象行为  ---》 返回的是监控对象
SQL 映射mappper 与 interface 中的方法对象



