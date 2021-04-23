<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: keen1
  Date: 2020/3/4
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //在域中存储数据
    session.setAttribute("name","keen");
    request.setAttribute("name","aaa");
    List list=new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);

    Map  map=new HashMap();
    map.put("name","李四");
    map.put("age","22");
    request.setAttribute("map",map);
%>
${sessionScope.name}<br>
${list}<br>
${list[0]}<br>

${map.age};
${map["age"]};

</body>
</html>
