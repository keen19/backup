<%--
  Created by IntelliJ IDEA.
  User: keen1
  Date: 2020/8/20
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:forward page="/emps"/>
<html>
<head>
    <title>Title</title>
    <%--    引入JQuery--%>
    <script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
    <%--    引入BootStrap样式--%>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="emps" ><button  type="button" class="btn btn-success"> 按钮</button></a>
</body>


</html>
