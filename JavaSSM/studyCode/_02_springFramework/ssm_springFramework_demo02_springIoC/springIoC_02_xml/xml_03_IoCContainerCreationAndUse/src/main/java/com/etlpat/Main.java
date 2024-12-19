package com.etlpat;

import com.etlpat.javaBean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    /**
     * 1.用于创建IoC容器，并读取配置文件
     */
    // IoC容器体系：
    // 接口：
    //   BeanFactory（父接口）
    //   ApplicationContext（子接口）
    //
    // 实现类：
    //  （注意：以下全是ApplicationContext接口的实现类）
    //   ClassPathXmlApplicationContext     读取类路径下的xml配置方式
    //   FileSystemXmlApplicationContext    读取指定文件位置的xml配置方式
    //   AnnotationConfigApplicationContext 读取java配置类方式的ioc容器
    //   WebApplicationContext              web项目专属的配置ioc容器

    /**
     * 1.1 直接new容器，并通过构造器指定配置xml信息【常用】
     */
    public ClassPathXmlApplicationContext createIoc1() {
        // ioc容器的构造器，可以传入 一个/多个 xml文件名
        return new ClassPathXmlApplicationContext("xml_03.xml");
    }

    /**
     * 1.2 先用无参构造器new容器，再用set方法指定xml配置文件，再刷新
     */
    public ClassPathXmlApplicationContext createIoc2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        // 可设置一个/多个xml文件
        applicationContext.setConfigLocations("xml_03.xml");
        // 刷新时，调用ioc/di的流程
        applicationContext.refresh();

        return applicationContext;
    }


    /**
     * 2.通过IoC容器，获取组件Bean对象
     * （方法：容器对象.getBean(XXX);）
     */
    /**
     * 2.1 通过<id>获取，返回类型是Object，需强转
     */
    public User getBeanFromIoC1(ApplicationContext applicationContext) {
        // 注意：仅通过<id>获取对象，返回类型为Object，需要强转
        return (User) applicationContext.getBean("user1");
    }


    /**
     * 2.2 通过<id, 类型>获取
     */
    public User getBeanFromIoC2(ApplicationContext applicationContext) {
        // 通过<id, 类型>，可以返回指定类型的对象
        // TODO: 类名.class 可以获取该类对应的 Class对象，用于java反射。
        return applicationContext.getBean("user2", User.class);
    }


    /**
     * 3.3 通过<类型>获取
     */
    public String getBeanFromIoC3(ApplicationContext applicationContext) {
        // TODO: 通过类型获取Bean对象，必须保证该类型仅有一个对象！
        // TODO: 若通过类型获取对象，但是ioc容器中有多个类型的该对象，会抛出NoUniqueBeanDefinitionException异常。
        // TODO: 可以通过父类/接口类型，来获取子类对象。（但是要保证只有一个该类型的子类/实现类）（ioc容器通过instanceof关键字来判别）

//        return applicationContext.getBean(User.class).toString();// 报错，NoUniqueBeanDefinitionException（该类对象不唯一）
        return applicationContext.getBean(String.class);
    }


    public static void main(String[] args) {
        Main main = new Main();

        // 创建IoC容器
        ClassPathXmlApplicationContext ioc1 = main.createIoc1();
        ClassPathXmlApplicationContext ioc2 = main.createIoc2();

        // 通过容器，获取Bean镀锡
        User user1 = main.getBeanFromIoC1(ioc1);
        System.out.println(user1);

        User user2 = main.getBeanFromIoC2(ioc1);
        System.out.println(user2);

        String str = main.getBeanFromIoC3(ioc1);
        System.out.println(str);

    }
}