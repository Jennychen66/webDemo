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

# Mybatis 中的 executor(执行器) : 
1. 每一个SQLSession 对象都会分配一个【执行器对象】，主要负责： 
    connection 获取，statement对象的管理方案
2. statement对象的管理方案: 
    1) 简单管理方案： 一个statement 接口对象，只执行一次，执行完毕之后会将statement接口对象
                    进行销毁
    2) 可重用方案： 用一个map集合，关键字就是一条SQL语句，对应的内容就是数据库操作对象，等到
                SqlSession 再次受到相同命令时，会在该map中找到对应的Statement接口使用
                map.put("select * from order",Statement1)
    3) 批处理管理方案： 将多个Statement 中所包含的SQL语句，交给一个Statement 对象输送到数据库，
                       形成批处理操作
# MySQL 中有查询缓存，只有512M
# MyBaits 更新缓存， 更新的是某查询语句所涉及的表的所有缓存
# MyBaits 中的Executor 继承结构是典型的适配器模式 
  https://www.cnblogs.com/cxuanBlog/p/11178489.html
                    
# 乐观锁
    1. 不是数据库中真实存在的锁
    2. 只是一种假设情况，认为多线程查询过程中不会出现问题，只有在多线程对表进行修改时有可能出现线程问题
    
# 乐观锁实现方案
    1. 在表中增加一个字段（数据行被修改的次数）
       当两个会话（线程）在查询时得到当前数据行的全部数据； 当其中一个会话对数据进行修改时，自动更新修改次数，同时在更新语句中被修改的数据要作为定位条件，此时另一个会话要进行更新会导致更新失败
       update dept set dname ? where deptno = ? and modifyCount = ?
       
       两个会话对同一条数据进行更新的时候，第二个session 不会有机会完成更新， 只有等以一个session 结束之后再update一遍，session2才会更新 （因为数据行被修改次数加1了，第二个session拿到的数据跟真实情况不同， 需要更新）
    2. 在表中增加一个字段（时间戳）
                       
    



