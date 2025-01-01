package com.etlpat;

// springMVC
//
// (1)SpringMVC涉及组件理解
//  1.DispatcherServlet:  SpringMVC提供，我们需要使用web.xml配置使其生效，它是整个流程处理的核心，所有请求都经过它的处理和分发！[ CEO ]
//  2.HandlerMapping:  SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效，它内部缓存handler(controller方法)和handler访问路径数据，被DispatcherServlet调用，用于查找路径对应的handler！[秘书]
//  3.HandlerAdapter: SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效，它可以处理请求参数和处理响应数据数据，每次DispatcherServlet都是通过handlerAdapter间接调用handler，他是handler和DispatcherServlet之间的适配器！[经理]
//  4.Handler: handler又称处理器，他是Controller类内部的方法简称，是由我们自己定义，用来接收参数，向后调用业务，最终返回响应结果！[打工人]
//  5.ViewResovler: SpringMVC提供，我们需要进行IoC配置使其加入IoC容器方可生效！视图解析器主要作用简化模版视图页面查找的，但是需要注意，前后端分离项目，后端只返回JSON数据，不返回页面，那就不需要视图解析器！所以，视图解析器，相对其他的组件不是必须的！[财务]
//
//
// (2)配置分析
//  1.DispatcherServlet，设置处理所有请求！
//  2.HandlerMapping,HandlerAdapter,Handler需要加入到IoC容器，供DS调用！
//  3.Handler自己声明（Controller）需要配置到HandlerMapping中供DS查找！


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}