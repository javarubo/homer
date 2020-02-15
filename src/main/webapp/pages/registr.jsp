<%--
  Created by IntelliJ IDEA.
  User: Rubo
  Date: 12/27/2019
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>
<%
    if (request.getAttribute("abab")!=null){response.getWriter().println(request.getAttribute("abab")); }

    if (request.getAttribute("ab")!=null){response.getWriter().println(request.getAttribute("ab")); }

%>


<h2>Registration Info</h2>

<form method="post" action="/registration">

    <input type="text" placeholder="NAME" name="name"><br/><br/><br/>
    <input type="text" placeholder="SURNAME" name="surname">   <br/><br/><br/>
    <input type="text" placeholder="USERNAME" name="username">   <br/><br/><br/>
    <input type="text" placeholder="AGE" name="age">   <br/><br/><br/>
    <input type="password" placeholder="PASSWORD" name="password">   <br/><br/><br/>

    <select name="gender">
        <option disabled="disabled" selected="selected">GENDER</option>
        <option>Male</option>
        <option>Female</option>
    </select>
    <select name="class">
        <option disabled="disabled" selected="selected">CLASS</option>
        <option>Class 1</option>
        <option>Class 2</option>
        <option>Class 3</option>
    </select>  *Not required <br/><br/><br/>

    <input type="text" placeholder=" CODE" name="code">
    <button type="submit">Submit</button>
</form>



</body>
</html>