package com.etlpat.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


// 创建事务增强类（用于切入事务增强代码）

// (1)配置类为切面类，(2)并在java配置类中开启AspectJ注解许可
@Component
@Aspect
public class TxAdvice {
    // (3)创建增强方法，并填写业务逻辑
    // (4)为增强方法添加位置注解，(5)并设置切点表达式
    // 开启事务
    @Before("execution(* com.etlpat..*.*(..))")
    public void begin(JoinPoint joinPoint) {
        System.out.println("~~~~~~" + joinPoint.getSignature().getName() + "方法:开启my事务~~~~~~");
    }


    // 提交事务
    @AfterReturning(value = "execution(* com.etlpat..*.*(..))")
    public void commit(JoinPoint joinPoint) {
        System.out.println("~~~~~~" + joinPoint.getSignature().getName() + "方法:提交my事务~~~~~~");
    }


    // 回滚事务
    @AfterThrowing(value = "execution(* com.etlpat..*.*(..))", throwing = "throwable")
    public void rollback(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("报出异常为：" + throwable);
        System.out.println("~~~~~~" + joinPoint.getSignature().getName() + "方法:回滚my事务~~~~~~");
    }


    // finally
    @After("execution(* com.etlpat..*.*(..))")
    public void end(JoinPoint joinPoint) {
        System.out.println("~~~~~~" + joinPoint.getSignature().getName() + "方法:结束my事务~~~~~~");
    }

}
