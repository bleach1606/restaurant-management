<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form style="text-align: center;" id="form">
			UserName : <input type="text" value="" name="username" id ="username"> <br><br><br>
			PassWord : <input type="password" value="" name="password" id="password"> <br><br><br>
			<input type="submit" value="submit" id="submit"> <br>
		</form>
		<p id="result"></p>
	</body>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$("#submit").click(function(){
				var username = $('#username').val();
				var password = $('#password').val();
				var myvar = encodeURI(JSON.stringify({username: username, password: password}));
				// console.log(myvar);
				alert(myvar + "  is post encodeURI");// đúng đến đây
				$.ajax({
					url: encodeURI('http://localhost:8080/table'),
					type: 'POST',
					data: myvar,
					dataType: 'json',
					contentType: 'application/x-www-form-urlencoded',
					success: function (data) {
						var json = JSON.stringify(data);
						alert(json + " " + data.username + " " + data.password);
						$("#result").html(data.username + " " + data.password);
					},
					error: function (data)	 {
						alert(data())
					}
				});
				// alert(myvar + "  is post 2");
			})
		});
	</script>
</html>