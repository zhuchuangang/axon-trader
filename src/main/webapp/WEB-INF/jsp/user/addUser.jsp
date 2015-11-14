<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String base = request.getContextPath();%>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<form action="${base}/user/add" method="post">
    姓名<br/>
    <input type="text" name="name"/><br/>
    用户名<br/>
    <input type="text" name="username"/><br/>
    密码<br/>
    <input type="password" name="password"><br/>
    <br/>
    <input type="submit" value="新增"/>
</form>
</body>
</html>
