package com.etlpat.javaBean;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// 使用注解，进行依赖注入DI
//
// (1)使用注解对【基本类型】进行DI
//  注解：@Value
//  语法：
//      ①@Value("常量")：直接赋值
//      ②@Value("${key}")：引入properties变量
//      ③@Value("${key:defaultValue}")：引入properties变量，并赋默认值
//
//
// (2)使用注解对【引用类型】进行DI
//  注解：@Autowired \ @Qualifier \ @Resource
//  语法：
//      ①@Autowired：直接进行自动装配
//      ②@Autowired+@Qualifier(value="IoC中组件id")：自动装配，并指定要装配组件的id
//      ③@Resource(name="IoC中组件id")：自动装配，并指定要装配组件的id（等价于②）
//


@Component
public class User {
    //TODO: 1【使用@注解对基本类型进行DI】

    //TODO:1.1 使用@Value("常量")，直接赋值
    @Value("18")
    private int age;

    //TODO:1.2 使用@Value("${key}")，引入properties变量
    @Value("${jdbc.username}")
    private String username;

    //TODO:1.3 使用@Value("${key:defaultValue}")，引入properties变量，并赋默认值
    //注意：当properties文件中不包含该key，则该变量值为defaultValue默认值
    @Value("${jdbc.password:000000}")
    private String password;


    //TODO: 2【使用@注解对引用类型进行DI】

    //TODO:2.1 @Autowired自动装配注解 -- 直接装填属性
    //
    //  (1)@Autowired注解执行流程：
    //      ①在ioc容器中查找符合类型的组件对象。
    //        查找标准：
    //          Ⅰ若无类型匹配对象 -- 报错。
    //          Ⅱ若仅有1个类型匹配对象 -- 选择该对象。
    //          Ⅲ若有多个类型匹配对象 -- 则将组件id与变量名进行匹配：
    //              -若存在 组件id==变量名 -- 则选择该对象。
    //              -若不存在 组件id==变量名 -- 报错。
    //      ②直接将其设置给当前属性（DI）。
    //
    //  (2)重点细节：
    //      ①@Autowired注解不仅可以添加在属性上，也可以添加在构造器/Setter方法上，为它们传参。
    //      ②@Autowired注解有required属性，默认为true，表示必须在ioc容器中找到匹配组件，否则报错！
    //          佛系装填：设置required=false，表示不是必须存在匹配项，若找不到则自动填为false。
    //          注意：尽量不要使用佛系装填，若使用则易出现空指针异常！
    //
    @Autowired
    private UserText userText;


    //TODO:2.2 @Autowired和@Qualifier注解联合使用
    //
    //  (0)英文翻译
    //      Autowired：自动装配
    //      Qualifier：限定符
    //
    //  (1)使用规则
    //      当一个属性对应IoC容器中多个组件时，可以通过@Qualifier指定要装配的组件的id。
    //      语法：
    //          @Autowired
    //          @Qualifier(value="容器中指定组件的id")
    //      功能：
    //          @Autowired自动配置属性时，若遇到一个属性匹配多个IoC容器中的组件，
    //          则用@Qualifier注解，唯一指定一个bean的id，将其装配给该属性。
    //
    //  (2)注意事项
    //      @Qualifier注解不能单独使用，该注解必须配合@Autowired一同使用。
    //
    @Autowired
    @Qualifier(value = "userPictureA")// 指定ioc容器中bean的id，将其配置给下方属性。
    private UserPicture userPicture;


    //TODO:2.3 补充：@Resource
    //功能：@Resource(name="IoC中组件id") == @Autowired + @Qualifier(value="IoC中组件id")
    //
    @Resource(name = "userBookB")
    private UserBook userBook;


    @Override
    public String toString() {
        return "User{" +
                "age=" + age + '\n' +
                ", username='" + username + '\'' + '\n' +
                ", password='" + password + '\'' + '\n' +
                ", userText=" + userText + '\n' +
                ", userPicture=" + userPicture + '\n' +
                ", userBook=" + userBook +
                '}';
    }
}
