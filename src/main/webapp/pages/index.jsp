<%--
  Created by IntelliJ IDEA.
  User: Rubo
  Date: 12/27/2019
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (request.getAttribute("abcd")!=null){response.getWriter().println(request.getAttribute("abcd"));}

    if (request.getAttribute("abll")!=null){response.getWriter().println(request.getAttribute("abll"));}
%>



<form method="post" action="/login">
    Username :  <input type="text" name="username"><br/>
    Password :  <input type="password" name="pass"><br/>
    <input type="submit" name="Sign in">
</form>

<a href="pages/registr.jsp">for registration</a>
</body>
</html>
