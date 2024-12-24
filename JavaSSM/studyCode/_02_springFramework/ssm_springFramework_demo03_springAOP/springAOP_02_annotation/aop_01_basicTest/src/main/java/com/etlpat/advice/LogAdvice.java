package com.etlpat.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


// AOP的增强类（通知类）
//
//
// 1.AOP增强类的配置步骤
//
//  (1)创建增强类，并补全增强类的注解
//      ①将增强类放入IoC容器：@Component
//      ②将增强类设为切面：@Aspect
//          （注意：切面=切点+增强代码）
//      ③（可选）设置切面优先级：@Order(数值)
//          （注意：数值越低，优先级越高）
//
//
//
//  (2)在配置文件中，开启AspectJ注解的支持
//      java配置类：@EnableAspectJAutoProxy
//      xml文件：<aop:aspectj-autoproxy />
//
//
//
//  (3)创建增强方法，定义增强代码
//      P.S.要根据切入位置，编写对应增强方法。
//
//      重点：在增强方法中，获取目标方法的信息：（均通过反射实现）
//          <1>任意位置的增强方法中：均可获取目标方法的[所属类信息/方法名/参数列表/...]
//              步骤①：在形参列表中添加(JoinPoint joinPoint) -> （JoinPoint对象，包含目标方法的相关信息）
//              步骤②：获取目标方法所属类的信息 -> joinPoint.getTarget().getClass().getSimpleName();
//                    获取目标方法名 -> joinPoint.getSignature().getName();
//                    获取目标方法参数列表 -> joinPoint.getArgs();
//
//          <2>仅@AfterReturning方法中：获取返回结果
//              步骤①：创建形参(Object returnValue)，用于接收返回值
//              步骤②：在注解中，为形参注入返回值 -> @AfterReturning(returning="returnValue")
//
//          <3>仅@AfterThrowing方法中：获取异常的信息
//              步骤①：创建形参(Throwable throwable)，用于接收异常信息
//              步骤②：在注解中，为形参注入异常信息 -> @AfterThrowing(throwing="throwable")
//
//
//
//  (4)使用注解，指定增强方法的切入位置。
//      <1>几种位置的增强方法
//          ①前置增强   @Before             位置：try{}中，目标方法前
//          ②返回增强   @AfterReturning     位置：try{}中，目标方法后
//          ③异常增强   @AfterThrowing      位置：catch{}中
//          ④最后增强   @After              位置：finally{}中
//          ⑤环绕增强   @Around             位置：包括以上四种全部位置
//
//      <2>不同注解对应的切入位置
//          try{
//              @Before-前置增强方法
//              目标方法();
//              @AfterReturning-返回增强方法
//          } catch() {
//              @AfterThrowing-异常增强方法
//          } finally {
//              @After-最后增强方法
//          }
//
//
//
//  (5)配置切点表达式
//      AOP切点表达式：（Pointcut Expression）用于匹配到固定的【目标方法】。
//      <1>语法
//          完全体：execution(public int com.etlpat.service.CalculatorImpl.add(int, int))
//             即：execution(访问修饰符 返回类型 类的全称.方法名(参数列表))
//
//      <2>简化规则
//          ①访问修饰符、返回类型
//              规则：二者要么一起写，要么一起省略为 *
//              如：execution(* com.etlpat.service.CalculatorImpl.add(int, int))
//          ②类的全称
//              规则：Ⅰ单层模糊 *
//                   Ⅱ多层模糊 ..
//                   Ⅲ类名部分模糊 *Impl
//              细节：类全称中..不能开头或结尾，但是可以 *..Main 或 com..*
//              如：execution(* com.etlpat..*.add(int, int))
//          ③方法名
//              规则：Ⅰ模糊 *
//                   Ⅱ方法名部分模糊 *Func
//              如：execution(* com.etlpat..*.*(int, int))
//          ④参数列表
//              规则：Ⅰ全部模糊 (..)
//                   Ⅱ部分模糊 (String..)或(..int)或(String..int)
//              如：execution(* com.etlpat..*.*(..))
//
//      <3>切点表达式练习
//          查询某包某类下，访问修饰符是公有，返回值是int的全部方法 -> execution(public int *..*.*(..))
//          查询某包下类中第一个参数是String的方法 -> execution(* *..*.*(String..))
//          查询全部包下，无参数的方法 -> execution(* *..*.*())
//          查询com包下，以int参数类型结尾的方法 -> execution(* com..*.*(..int))
//          查询指定包下，Service开头类的私有返回值int的无参数方法 -> execution(private int com.etlpat..Service*.*())
//


@Component// 把增强类放入IoC容器
@Aspect// 将增强类配置为切面
//@Order(10)// 指定切面优先级，数字越低，优先级越高
public class LogAdvice {

    @Before("execution(* com.etlpat.service.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 通过形参JoinPoint，获取目标方法相关信息
        // (1)获取目标方法所属类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("目标方法所属类名为：" + simpleName);
        // (2)获取目标方法名
        String name = joinPoint.getSignature().getName();
        System.out.println("目标方法名为：" + name);
        // (3)获取目标方法参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("目标方法参数列表为：" + args);

        System.out.println("方法开始了");
    }


    @AfterReturning(value = "execution(* com.etlpat.service.*.*(..))", returning = "returnValue")
    public void afterReturningAdvice(Object returnValue) {
        // 通过@AfterReturning注解的returning属性，使形参接收目标方法的返回结果
        System.out.println("目标方法返回结果为：" + returnValue);

        System.out.println("方法正常结束了");
    }


    @AfterThrowing(value = "execution(* com.etlpat.service.*.*(..))", throwing = "throwable")
    public void afterThrowingAdvice(Throwable throwable) {
        // 通过@AfterThrowing注解的throwing属性，使形参接收目标方法的错误信息
        System.out.println("目标方法的错误信息为：" + throwable);

        System.out.println("方法报错了");
    }


    @After("execution(* com.etlpat.service.*.*(..))")
    public void afterAdvice() {
        System.out.println("进入finally代码块");
    }
}
