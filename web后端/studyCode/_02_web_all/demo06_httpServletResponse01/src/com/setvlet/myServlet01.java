package com.setvlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// HttpServletResponse
//
// (1)HttpServletResponse介绍
//  HttpServletResponse是一个接口，其父接口是ServletResponse。
//  HttpServletResponse是在Tomcat中预先创建的，在调用service方法时传入。
//  HttpServletResponse对象会被转化为响应报文传给浏览器，我们可以通过该对象设置响应信息。
//
//
// (2)HttpServletResponse中的方法
//  <1>响应行相关的方法
//      setStatus(int status)   功能：设置状态码（若不设置默认为200）
//
//  <2>响应头相关的方法
//      setHeader(String name, String value)    功能：创建/修改响应头
//          （若响应头名不存在，则创建新的响应头并为其赋值；若响应头已存在，则修改其对应的值）
//      setContentType(String type)     功能：设置响应体的MIME类型
//      setContentLength(int length)    功能：设置响应体的长度，单位字节
//
//  <3>发送响应消息体相关的方法
//      getWriter()     功能：获取字符输出流，用于输出字符文本数据


@WebServlet("/myServlet1")

public class myServlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String str = "<h2>Hello World</h2>";// 要输出的数据

        // (1)响应行相关的方法
        httpServletResponse.setStatus(200);// 设置状态码

        // (2)响应头相关的方法
        httpServletResponse.setHeader("aaa", "aaa");// 设置响应头为指定的值
        httpServletResponse.setContentType("text/html");// 设置响应体类型
        httpServletResponse.setContentLength(str.getBytes().length);// 设置响应体长度（字节个数）
        //  注意：setContentLength需要响应体的字节长度，因此需要把str先转化为字节数组，再获取length（str.length获取的是字符长度，而非字节长度）

        // (3)获取输出流，将数据传输到响应体
        PrintWriter writer = httpServletResponse.getWriter();// 获取字符输出流，用于输出字符文本内容
        writer.write(str);
    }
}
