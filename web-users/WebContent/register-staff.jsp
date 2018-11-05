<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <jsp:include page="./staff/Views/icon.jsp"></jsp:include>
  <title>nhân viên đăng ký</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  
      <link rel="stylesheet" href="./staff/css/style.css">

  
</head>

<body>
  <div class="container">
  <div class="login">
  	<h1 class="login-heading">
      <strong>Nhân viên.</strong> đăng ký.</h1>
      <form method="post" action="nhanVienDangKy" name="register_staff" onsubmit="return xacNhanDangKy()">
        <input type="text" name="user" placeholder="Username" required="required" class="input-txt" />
         <input type="password" name="password" placeholder="Password" required="required" class="input-txt" />
         <input type="password" name="txtpassword" placeholder="Lặp lại password" required="required" class="input-txt" />
         <input type="text" name="hoNhanVien" placeholder="Họ" required="required" class="input-txt" />
         <input type="text" name="nameNhanVien" placeholder="Tên" required="required" class="input-txt" />
         <input type="email" name="emailNhanVien" placeholder="Email" required="required" class="input-txt" />
         <input type="text" name="sdtNhanVien" placeholder="Số điện thoại" required="required" class="input-txt" />
          <div class="login-footer">
             
            <button type="submit" class="btn btn--right">Đăng ký</button>
    
          </div>
      </form>
      <script type="text/javascript">
      		function xacNhanDangKy() {
      			var password_input = document.forms["register_staff"]["password"].value;
      			var password_repeat = document.forms["register_staff"]["txtpassword"].value;
      			
      			if(password_input != password_repeat){
      				alert("Password không giống nhau!");
      		        return false;
      			}
			}
      </script>
  </div>
</div>
  
    <script  src="./staff/js/index.js"></script>

</body>
</html>
    