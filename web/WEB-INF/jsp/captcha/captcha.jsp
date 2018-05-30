<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/28
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%--1.2、测试验证码--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="/js/jquery-2.1.0.min.js"></script>

    <script>
        $(function(){

            var $captchaImage = $("#captchaImage");

            // 更换验证码
            $captchaImage.click(function() {
                $captchaImage.attr("src", "/captcha/captcha.do?captchaId=${captchaId}&timestamp=" + (new Date()).valueOf());
            });
        })
    </script>

</head>
<body>
    验证码图文  <img id="captchaImage" class="captchaImage" src="/captcha/captcha.do?captchaId=${captchaId}" alt="" title="" /><br/>
    <form action="/captcha/submit.do" method="get">
        <input type="hidden" name="captchaId" value="${captchaId}"/>
        <input type="text" name="captcha"/>
        <input type="submit">
    </form>
</body>

</html>
