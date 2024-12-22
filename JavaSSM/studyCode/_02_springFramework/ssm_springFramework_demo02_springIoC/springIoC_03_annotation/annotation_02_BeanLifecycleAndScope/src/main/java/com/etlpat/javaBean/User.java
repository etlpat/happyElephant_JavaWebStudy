package com.etlpat.javaBean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


// 使用注解，设置组件的【作用域】和【生命周期】
//  P.S.组件作用域和生命周期的基本规则，与之前xml中所学规则完全相同。


@Component// 将user声明为IoC容器的组件

// (1)@Scope注解，设置组件的【作用域】
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)// 设置组件作用域为 - 单例【默认值】
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)// 设置组件作用域为 - 多例

public class User {

    // (2)注解设置组件的【生命周期】
    // ①@PostConstruct注解，设置该方法为初始化方法。
    //   注意：初始化方法命名随意，但是必须public、void且无参。
    @PostConstruct
    public void init() {
        System.out.println("User组件初始化");
    }


    // ②@PreDestroy注解，设置该方法为销毁方法
    //   注意：销毁方法命名随意，但是必须public、void且无参。
    @PreDestroy
    public void destroy() {
        System.out.println("User组件销毁");
    }
}
