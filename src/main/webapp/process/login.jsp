<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="../Css/login.css">
</head>
<body>
<%! String mess = "";%>
<% mess= (String)request.getAttribute("message") ;%>

<div class="container" >
    <div class="div-login">
        <form action="/Login" method="post" id="login">
            <div class="label"><span>LOGIN</span></div>
            <span class="text">Tên đăng nhập</span><br><br>
            <input type="text" name="username" value="admin" ><br><br>
            <span class="text">Mật khẩu</span><br><br>
            <input type="password" name="password" value="123456"><br><br>
            <div class="wrap-button">
                <button><span>Đăng nhập</span></button>
            </div>
            <div class="signup"><span>Bạn chưa có tài khoản?</span></div>
            <div class="btnSignup"><a href="http://localhost:8080/Signup1/signup.jsp">Click Here</a></div>
        </form>

    </div>

</div>

</body>
</html>