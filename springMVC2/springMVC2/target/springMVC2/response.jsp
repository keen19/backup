<%--
  Created by IntelliJ IDEA.
  User: keen1
  Date: 2020/8/17
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script >
        //页面加载,绑定单击事件
        $(function () {
            $("#btn").click(function () {
                alert("hello");
            });
        })
    </script>
</head>
<body>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
