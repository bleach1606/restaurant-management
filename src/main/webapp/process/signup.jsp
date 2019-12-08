<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="../Css/signup.css">
</head>
<body>
<div class="container" >
    <div class="div-signup">


        <form action="signup" method="post" id="signup">
            <div class="label"><span>Sign Up</span></div>
            <span class="text">Họ và tên</span><br><br>
            <input type="text" name="name" ><br><br>
            <span class="text">Vai trò</span><br><br>
            <select name="position">
                <option>ADMIN</option>
                <option>LE_TAN</option>
                <option>NV_KHO</option>

            </select><br><br>
            <span class="text">Địa chỉ</span><br><br>
            <input type="text" name="address" ><br><br>
            <span class="text">Tên đăng nhập</span><br><br>
            <input type="text" name="username" ><br><br>
            <span class="text">Mật khẩu</span><br><br>
            <input type="password" name="password"><br><br>
            <div class="wrap-button">
                <button><span>Đăng Kí</span></button>
            </div>

        </form>
    </div>
</div>
</body>
</html>