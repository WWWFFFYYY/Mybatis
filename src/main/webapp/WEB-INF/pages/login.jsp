<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/4
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    用户名：<input type="text" name="name"><br>
    密码：<input type="text" name="password"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="登录"><br>
    <b>${msg}<b>
</form>
</body>
</html>
