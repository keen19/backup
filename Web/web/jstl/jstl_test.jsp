<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jstlTest.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: keen1
  Date: 2020/3/4
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
    <%
        List list=new ArrayList();
        list.add(new User("张三",23,new Date()));
        list.add(new User("李四",22,new Date()));
        list.add(new User("王五",21,new Date()));
        request.setAttribute("list",list);
    %>
<table align="center" border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>

    </tr>
    <%--数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birStr}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
