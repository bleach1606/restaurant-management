<%--
  Created by IntelliJ IDEA.
  User: v
  Date: 12/9/19
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-Servlet Upload file</title>
</head>
<body>
<h2>Demo JSP-Servlet Upload File</h2>
<form method="post" action="UploadFileServlet" enctype="multipart/form-data">
    Select file to upload: <input type="file" name="file" size="60" /><br /><br />
    <input type="submit" value="Upload" />
</form>
</body>
</html>