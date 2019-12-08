<%@ page import="java.util.ArrayList" %>
<%@ page import="modul.Table" %><%--
  Created by IntelliJ IDEA.
  User: v
  Date: 11/24/19
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%! ArrayList<Table> listTable = null;%>

<%

    if(request.getAttribute("listTable") != null) {
        listTable = (ArrayList<Table>) request.getAttribute("listTable");
    }
%>

    <h1> List table : </h1>
<% for(Table x : listTable) { %>
        <div style="border: 1px solid black;border-radius:20px ;width: 24%; float: left; height: 300px;">
            <img alt="jjjj" src="/webapp/1.png" width="100%" height= "200px";>
            <p> <%= x.getNameTable()%></p>
            <p> <%= x.getQuantitySeat()%></p>
            <p> <%= x.getStatus()%></p>
            <p> <%= x.getDescription()%></p>
        </div>
<% } %> <br>
</body>
</html>