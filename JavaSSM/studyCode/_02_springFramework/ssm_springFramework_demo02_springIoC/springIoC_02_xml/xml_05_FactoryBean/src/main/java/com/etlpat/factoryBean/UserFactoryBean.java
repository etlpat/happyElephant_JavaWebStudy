package com.etlpat.factoryBean;

import com.etlpat.javaBean.User;
import org.springframework.beans.factory.FactoryBean;


// FactoryBean接口
//
//  (1)FactoryBean概念
//      FactoryBean接口是SpringIoC容器规定的【标准化工厂】。
//      它用于配置复杂的Bean对象，可以将复杂对象的创建过程写作在FactoryBean的getObject方法中！
//
//
//  (2)FactoryBean<T>接口提供三种方法：
//      ①语法：T getObject()
//        功能：是【工厂方法】，返回此工厂创建的对象的实例。该返回值会被存储到IoC容器！
//
//      ②语法：Class<?> getObjectType()
//        功能：返回 getObject() 创建的对象的类型，如果事先不知道类型，则返回 null。
//
//      ③语法：boolean isSingleton()
//        功能：如果此 FactoryBean 返回单例，则返回 true ，否则返回 false。
//             此方法的默认实现返回 true。 （注意，lombok插件使用，可能影响效果）
//


// UserFactoryBean工厂，实现FactoryBean标准化工厂接口
//  注意：接口FactoryBean<User>，泛型表示该工厂制造的对象类型是User。
public class UserFactoryBean implements FactoryBean<User> {

    // (1)getObject()是工厂方法，用于实例化对象
    @Override
    public User getObject() throws Exception {
        return new User();
    }


    // (2)getObjectType()返回实例化对象的类型
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
