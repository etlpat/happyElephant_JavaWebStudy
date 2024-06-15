package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


// HttpSession
//
// (1)HttpSession介绍
//  HttpSession是将一次会话的信息保存在服务端的技术。
//  HttpSession对象存放在服务器中，超过会话对象的失效时间，该对象才会自动销毁。
//  当服务端创建HttpSession对象时，会将该对象的id，即JSESSIONID以Cookie的形式传入浏览器中。
//  （该Cookie对象为："JSESSIONID":"HttpSession对象的ID值"）
//  之后浏览器每次访问资源，都会携带该Cookie信息，使得服务器可以找到本次会话的HttpSession对象。
//  （只要浏览器中还保存着该会话的Cookie信息(ID)，那么浏览器就可以访问到该会话对象）
//
//
//
// (2)HttpSession相关语法
//  ①创建/获取HttpSession对象
//      语法：req.getSession()
//      功能：若当前会话不存在Session对象，则创建新Session对象；否则，返回旧Session对象
//          （创建新Session对象时，会把该对象的id，即JSESSIONID以Cookie的形式传入浏览器）
//
//  ②获取session对象的id
//      语法：session.getId()
//
//  ③判断session对象是否为新的
//      语法：session.isNew()
//
//  ④为session对象增加/修改域属性
//      语法：session.setAttribute(String name, Object value)
//      功能：若Session对象中不存在该属性名，则创建新属性并为其赋值；否则修原有改属性的值
//
//  ⑤获取session对象中域属性名对应的值
//      语法：session.getAttribute(String name)
//
//  ⑥移除session对象中的域属性
//      语法：session.removeAttribute(String name)
//
//  注意事项（域对象的语法）：
//      HttpSession对象也是域对象（会话域）
//      会话域属性：同一次会话中，相同客户端的多次请求，都能访问到会话域属性。
//      所有域对象(应用域/会话域/请求域)，操作域属性的语法都相同，即：
//          增/改：setAttribute
//          删：removeAttribute
//          查：getAttribute
//
//
//
// (3)HttpSession对象的特点
//  ①HttpSession对象的时效性
//      HttpSession对象是有时效性的，默认超时限制是30分钟。
//      30分钟超时限制：计时30分钟，若30分钟内会话对象未被访问过则自动销毁；若会话对象被访问过则重新开始计时。
//  ②浏览器访问session对象的注意事项
//      浏览器的关闭不会使HttpSession对象销毁。（session对象在服务器中，与浏览器无关）
//      但是浏览器关闭后，记录之前HttpSession对象ID的Cookie信息就会消失，导致浏览器无法找到之前的会话对象。
//      HttpSession对象的销毁只取决于时效时间，和浏览器中的Cookie对象无关。
//  ③会话域（可以访问会话的时间）
//      <1>在HttpSession对象的时效时间内。
//      <2>客户端存放该session对象id的Cookie没有丢失。
//      只要符合<1>、<2>两点，就能访问到该会话对象，这个范围就是一个会话域。
//      会话域：可以跨请求，但是不能跨客户端。
//  ④总结
//      session对象是否销毁仅取决于其时效时间。
//      浏览器想要访问到session对象，不仅需要session对象还未销毁，还需要浏览器中保存着存放会话id的cookie信息。


@WebServlet("/myServlet1")

public class myServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // (1)创建/获取HttpSession对象
        HttpSession session = req.getSession();

        // (2)获取session对象的id
        System.out.println(session.getId());

        // (3)判断session对象是否为新的
        System.out.println(session.isNew());

        // (4)为session对象增加/修改属性
        session.setAttribute("username", username);
        session.setAttribute("password", password);

        // (5)获取session对象中属性名对应的值
        System.out.println(session.getAttribute("username"));
        System.out.println(session.getAttribute("password"));

//        // (6)移除session对象的属性
//        session.removeAttribute("username");
//        session.removeAttribute("password");


        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("成功创建session对象");
    }
}
