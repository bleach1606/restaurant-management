<%@ page import="modul.NguyenLieu" %>
<%@ page import="modul.User" %><%--
  Created by IntelliJ IDEA.
  User: v
  Date: 11/21/19
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nguyên liệu</title>
</head>
<body>
<%
    if(request.getAttribute("user") != null) {
        User user = (User) request.getAttribute("user");
%>
    <h1> Nguyen lieu : </h1>
    <div>ID: <%= user.toString()%></div>
<%
    } else {
%>
        <h1> no nguyenlieu </h1>
<% } %>
</body>
</html>
