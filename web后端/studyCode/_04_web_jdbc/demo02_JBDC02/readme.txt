案例：用JDBC实现对数据库的增删查改
要求：操作名为jdbc的MySQL数据库

JDBC的DAO设计模式：
    1.先创建一个JavaBean，用于表示数据库的行对象。
      （该java普通类，要求成员变量与数据库的字段一一对应）

    2.创建jdbcUtil类（jdbc工具类）
      该类中包括“①数据库连接方法”和“②资源释放方法”
        ①数据库连接方法：加载驱动、连接数据库
        ②资源释放方法：关闭数据库连接，释放资源

    3.创建DAO类（Data Access Object）
      该类用于专门实现DB的CRUD
      CRUD方法，内部建议都要有完整的JDBC流程（从加载驱动、连接数据库，到关闭连接），这样耦合性小。
        ①增：传入JavaBean，返回boolean值
        ②删：传入id(主键)，返回boolean值
        ③查找个人：传入id(主键)，返回JavaBean
        ④查询全部结果：参数为空，返回null，直接输出
        ⑤改：传入JavaBean，返回boolean值

    4.创建测试类
      改类的main方法用于测试输出JDBC的功能。