<%--
  Created by IntelliJ IDEA.
  User: keen1
  Date: 2020/8/15
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    请求参数绑定--%>
<%--<a href="param/testParam?username=haha">请求参数绑定</a>--%>
<%-- 此处的input标签的name的值为JavaBean类的属性
     如果是引用User属性,则值为user.username--%>
    <%--<form action="param/saveAccount2" method="post">
        姓名: <input type="text" name="username"/><br/>
        密码: <input type="text" name="password"/><br/>
        金额: <input type="text" name="money"/><br>
&lt;%&ndash;        把数据封装到list集合中&ndash;%&gt;
        用户姓名: <input type="text" name="list[0].username"/><br/>
        用户年龄: <input type="text" name="list[0].age"/><br/>
&lt;%&ndash;        把数据封装到map集合中,并且设置key值为a&ndash;%&gt;
        用户姓名: <input type="text" name="map['a'].username"/><br/>
        用户年龄: <input type="text" name="map['a'].age"/><br/>
        <input type="submit" value="提交">
    </form>--%>
<form action="param/saveServlet" method="post">
    用户姓名: <input type="text" name="username"/><br/>
    用户年龄: <input type="text" name="age"/><br/>
    生日: <input type="text" name="date"/><br/>
    <input type="submit" value="提交">
</form>
</body>

</html>
