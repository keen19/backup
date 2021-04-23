<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: keen1
  Date: 2020/3/4
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
    <%--
    foreach:相当于java代码的for语句
        1.完成重复的操作
          *属性
            begin:开始值
            end:结束值
            var：临时变量
            step：步长
        2.遍历容器
        <List<User> list;
        for(User user:list){

        }
            *属性
                items：容器对象
                var：容器中的元素的临时变量
                varStatus：循环状态对象
                index：容器中的元素的索引，从0开始
                count：循环次数，从1开始
    --%>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>

<hr><%--换行分割线--%>
    <%
        List list=new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list",list);
    %>
<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str}<br>
</c:forEach>
</body>
</html>
