package com.etlpat.javaBean;

import org.springframework.stereotype.Component;


// 注解
//
// 1.注解介绍
//  和XML配置文件一样，注解本身并不能执行，注解本身仅仅只是做一个标记，
//      具体的功能是框架检测到注解标记的位置，然后针对这个位置按照注解标记的功能来执行具体操作。
//  本质上：所有一切的操作都是 Java 代码来完成的，XML 和注解只是告诉框架中的 Java 代码如何执行。
//
//
// 2.通过注解配置ioc容器的步骤
//  ①在组件类上添加ioc注解
//  ②配置注解所生效的包的xml信息
//  ③创建ioc容器对象，并指定配置信息；通过ioc容器获取组件对象。
//
//
// 3.spring提供的组件标记注解
//  Spring 提供了以下多个注解，这些注解可以直接标注在 Java 类上，将它们定义成 Spring Bean。
//  ____________________________________________________________________________________________________________________
//  |   注解          | 说明
//  |① @Component   | 该注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），--
//  |                |  --@Component可以作用在应用的任何层次，例如 Service 层、Dao 层等。 使用时只需将该注解标注在相应类上即可。
//  |② @Repository  | 该注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
//  |③ @Service     | 该注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
//  |④ @Controller  | 该注解通常作用在控制层（如SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
//  注意事项：
//      通过查看源码我们得知，【以上四种注解的源码实现完全相同】！
//      @Controller、@Service、@Repository这三个注解，均为@Component注解的【别名】。
//      注意：虽然它们本质上一样，但是为了代码的可读性、程序结构严谨！我们肯定不能随便胡乱标记。
//
//
// 4.注解的使用语法
//  语法1：@Component
//        功能：指定spring容器创建该类的组件，组件id【默认为类名首字母小写后的值】。
//  语法2：@Component(value = "user")
//        功能：指定spring容器创建该类的组件，组件id为value设置的值。
//  语法3：@Component("user")
//        功能：指定spring容器创建该类的组件，并设置组件id。（注解中，value关键字可省略）
//  注意：
//      以上三种注解写法，均等价于xml中，<bean id="user", class="com.etlpat.javaBean.User">
//


//@Component//  语法1：不指定id，则id的值【默认为类名首字母小写后的值】
//@Component(value = "user")//  语法2：使用value指定id的值
@Component("user")//    语法3：value关键字可省略，直接指定id的值
public class User {
}
