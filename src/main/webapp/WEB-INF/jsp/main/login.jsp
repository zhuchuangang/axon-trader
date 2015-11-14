
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String base=request.getContextPath();%>
<!DOCTYPE  html>
<html lang="zh-cn">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
</head>
<head>
    <title>登录</title>
</head>
<body>
<form id="login-form" action="${base}/main?method=login" method="post">
    <p>用户名:</p>
  <input name="username" type="text"/>
    <p>密&nbsp;码:</p>
  <input name="password" type="password"/>
    <br/> <br/>
  <input type="submit" value="提交"/>
</form>
</body>
</html>
