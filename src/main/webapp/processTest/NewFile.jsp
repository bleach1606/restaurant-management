
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String text = (String) request.getAttribute("TEST");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<button onclick="mot()">click me</button>
		<script>
			function mot() {
				var req = new XMLHttpRequest();
				req.open("GET", "https://httpbin.org/get", false);
			}
		</script>
	</div>

	<% for(int i = 1; i <= 2; i++) {for(int j = 1; j <= 4; j++) {%> 
		<div style="border: 1px solid black;border-radius:20px ;width: 24%; float: left; height: 300px;">
			<img alt="jjjj" src="/webapp/1.png" width="100%" height= "200px";>
			<p> Des: ....</p>
			<p> Price: 100000</p>
		</div>
		<%}%><br>
	<%}%>
	
</body>
</html>