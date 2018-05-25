<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/25
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/email/send.do" method="get">
        发送邮件地址：<input type="text" name="mailto"/>
        发送标题：<input type="text" name="title"/>
        发送内容：<input type="text" name="content"/>
        <input type="submit">
    </form>
</body>
</html>
