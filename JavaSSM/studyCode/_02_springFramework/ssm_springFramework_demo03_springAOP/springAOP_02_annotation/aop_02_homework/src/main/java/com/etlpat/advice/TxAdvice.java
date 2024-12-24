package com.etlpat.advice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


// 创建事务增强类（用于切入事务增强代码）

// (1)配置类为切面类，并在java配置类中开启AspectJ注解许可
@Component
@Aspect
public class TxAdvice {
    // (2)创建增强方法，并填写业务逻辑
    // (3)为增强方法添加位置注解，并设置切点表达式
}
