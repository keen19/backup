<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: keen1
  Date: 2020/3/3
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% //设置响应的消息体的数据格式以及编码
    response.setContentType("text/html;charset=utf-8");
    //1.获取所有Cookie
    Cookie[] cookies=request.getCookies();
    boolean flag=false;//没有Cookie为lastTime
    //2.遍历Cookie
    if (cookies!=null&&cookies.length>0) {
        for (Cookie cookie : cookies) {
            //3.获取cookie的名称
            String name=cookie.getName();
            //4.判断名称是否是：lasttime
            if ("lastTime".equals(name)){
                //有 该Cookie，不是第一次访问
                flag=true;//有lastTime的Cookie
                //创建Date对象
                Date date=new Date();
                //设置时间模板
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                //应用模板
                String str_date = sdf.format(date);
                System.out.println("编码前："+str_date);
                //URL编码
                str_date= URLEncoder.encode(str_date,"utf-8");
                System.out.println("编码后："+str_date);
                //设置Cookie的value为时间
                cookie.setValue(str_date);
                //设置Cookie的存活时间
                cookie.setMaxAge(60 * 60 * 24 * 30);
                //添加Cookie
                response.addCookie(cookie);
                //响应数据
                //获取Cookie的value,时间
                String value=cookie.getValue();
                System.out.println("解码前："+value);
                //URL解码：
                value= URLDecoder.decode(value,"utf-8");
                System.out.println("解码后："+value);


                response.getWriter().write("<h1>欢迎回来，您上次的访问时间为："+value+"</h1>");
                break;
            }
        }
    }
    if (cookies == null || cookies.length == 0 || flag==false) {
        //第一次访问
        //设置Cookie的value
        //获取当前时间的字符串，重新设置Cookie的值，重新发送Cookie
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        System.out.println("编码前："+str_date);
        //URL编码
        str_date=URLEncoder.encode(str_date,"utf-8");
        System.out.println("编码后："+str_date);
        Cookie cookie=new Cookie("lastTime",str_date);
        //设置Cookie的存活时间
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);
        response.getWriter().write("<h1>首次访问</h1>");
    }
    %>

</body>
</html>
