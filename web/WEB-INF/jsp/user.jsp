<%--
  Created by IntelliJ IDEA.
  User: jiangyixuan
  Date: 2018/3/2
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>

</body>
<%
    String name = (String) request.getAttribute("name");
    Integer age = (Integer) request.getAttribute("age");
    out.println("user.jsp成功接收到姓名:" + name + "年龄:" + age);
%>
</body>
</html>
