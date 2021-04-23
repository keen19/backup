<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: keen1
  Date: 2020/3/4
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%-- c:if标签
        1.属性：
        *test 必须属性，接收boolean表达式
            *表达式为true，则显示if标签体内容，false则不显示
            *一般情况下，test属性值会结合el表达式一起使用
            --%>
<c:if test="true">
    <h1>我是真的。。。</h1>
</c:if>
<br>
<%
    List list = new ArrayList();
    list.add("aaa");
    request.setAttribute("list", list);

    request.setAttribute("number", 3);
%>
<c:if test="${not empty list}">
    遍历集合
</c:if>
<c:if test="${number %2 == 0}">
    ${number}为偶数
</c:if>
</body>
</html>
