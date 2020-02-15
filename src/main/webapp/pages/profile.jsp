<%@ page import="am.basic.web.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Rubo
  Date: 12/27/2019
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user= (User) session.getAttribute("ttg"); %>
<%=user.getName()%>
<%=user.getSurname()%>
<%=user.getUsername()%>
<%=user.getAge()%>
<%
    response.getWriter().println(user.getPassword());
%>
<a href="/logout">LOGOUT</a>
</body>
</html>
