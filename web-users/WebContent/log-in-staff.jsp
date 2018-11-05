<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>nhân viên đăng nhập</title>
  <jsp:include page="./staff/Views/icon.jsp"></jsp:include>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  
      <link rel="stylesheet" href="./staff/css/style.css">

  
</head>

<body>
  <div class="container">
  <div class="login">
  	<h1 class="login-heading">
      <strong>Nhân viên.</strong> đăng nhập.</h1>
      <form method="post" action="nhanVienDangNhap">
        <input type="text" name="user" placeholder="Username" required="required" class="input-txt" />
          <input type="password" name="password" placeholder="Password" required="required" class="input-txt" />
          <div class="login-footer">
             <a href="#" class="lnk">
              <span class="icon icon--min">ಠ╭╮ಠ</span> 
              Quên mật khẩu ?
            </a>
            <button type="submit" class="btn btn--right">Đăng nhập</button>
    
          </div>
      </form>
  </div>
</div>
  
    <script  src="js/index.js"></script>

</body>
</html>
    