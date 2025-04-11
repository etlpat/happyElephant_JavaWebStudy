package com.etlpat;

import org.junit.jupiter.api.Test;


// ThreadLocal
//
//  功能：ThreadLocal提供线程局部变量
//      ①存取变量的方法：set()/get()
//      ②使用ThreadLocal存储的数据是线程安全的
//      ③用完记得调用remove方法释放，防止内存泄漏
//
//  原理：ThreadLocal为每个线程提供独立的空间来存储变量。
//       因此，不同线程存储的变量相互独立，互不干扰。


public class ThreadLocalTest {

    @Test
    public void testThreadLocal() {
        ThreadLocal threadLocal = new ThreadLocal();

        // 开启线程1
        new Thread(() -> {
            threadLocal.set("threadLocal变量1");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }, "线程1").start();

        // 开启线程2
        new Thread(() -> {
            threadLocal.set("threadLocal变量2");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }, "线程2").start();

    }
}
