package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// Cookie
//
// (1)Cookie概述
//  Cookie是一种客户端会话技术。
//  Cookie是由服务端产生，存放在浏览器中的一小份数据。
//  浏览器获取到Cookie后，之后每次访问服务器时，都会将这一小份数据携带到服务器中。
//
//
//
// (2)Cookie相关语法
//  ①创建Cookie对象
//      语法：Cookie cookie = new Cookie(String name, String value);
//      注意：Cookie是键值对形式的信息（键和值都是字符串）
//
//  ②获取Cookie的键和值
//      语法：cookie.getName();
//           cookie.getValue();
//      功能：获取Cookie对象的键和值
//
//  ③设置Cookie属性
//      语法1：cookie.setMaxAge(int seconds);
//      功能：设置cookie对象在浏览器中存在的秒数（浏览器关闭时cookie对象仍会存在）
//      注意：若不设置秒数，关闭浏览器时cookie对象自动销毁
//
//      语法2：cookie.setPath("资源的路径");
//      功能：设置提交路径，使得该cookie对象仅在请求指定的资源路径时才提交
//      注意：若不设置路径，cookie对象会提交到任意路径的请求头中
//
//  ④将Cookie对象通过HttpServletResponse传给浏览器
//      语法：resp.addCookie(Cookie cookie);
//      功能：该方法将Cookie对象添加到响应头中传送给浏览器
//      （Cookie在响应头中的形式为：Set-Cookie: key1=value1 [有多组该信息]）
//
//  ⑤通过HttpServletRequest获取浏览器传来的Cookie信息
//      语法：Cookie[] cookies = req.getCookies();
//      功能：该方法获取请求头中传来的所有Cookie对象，存放到数组中（若无对象，则数组为null）
//      （Cookie在请求头中的形式为：Cookie: key1=value1; key2=value2;...）
//
//
//
// (3)Cookie特点【重点】
//  1.Cookie对象在服务器中创建，通过响应报文（响应头）传送到浏览器中。
//  2.浏览器收到Cookie对象后，会保存该对象。
//    之后浏览器每次访问服务器时，都会将其保存的Cookie对象通过请求报文（请求头）传送给服务器。
//  3.Cookie根据时效性，分为会话级Cookie和持久化Cookie。
//      会话级Cookie：浏览器开启时，Cookie对象永久存在；当浏览器关闭后该对象被清除。
//      持久化Cookie：该Cookie设置了明确的存在时间。无论浏览器是否关闭，到时间后该对象都会被清除。
//    注意：创建的Cookie对象默认是会话级Cookie，但是可以通过setMaxAge方法将其设置为持久化Cookie。
//  4.浏览器中的Cookie默认会向项目中任意路径提交。可通过setPath方法指定Cookie的提交路径。


@WebServlet("/myServlet1")

public class myServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // (1)创建Cookie对象
        Cookie cookie1 = new Cookie("key1", "value1");
        Cookie cookie2 = new Cookie("key2", "value2");
        Cookie cookie3 = new Cookie("key3", "value3");


        // (2)设置Cookie相关属性
        cookie2.setMaxAge(20);// 设置cookie2存在的时间为60秒
        cookie3.setMaxAge(60);
        cookie3.setPath("/demo08_cookie01_Web_exploded/myServlet2");// 设置请求路径，使得cookie3仅在访问该路径时提交


        // (3)将Cookie对象传给浏览器（通过响应对象传送给浏览器）
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
    }
}
