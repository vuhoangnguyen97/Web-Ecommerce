<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container_fullwidth">
        <div class="container">
          <div class="row">
            <jsp:include page="/Views/menu-ben-trai.jsp"></jsp:include>
            <div class="col-md-9">
              <div class="checkout-page">
                <ol class="checkout-steps">
					<section class="login">
	  					<div class="titulo">Đăng Nhập</div>
						<form name="form-dang-nhap" onsubmit="return xacThucDangNhap()"  action="dangNhapServlet" method="post">
							<input type="text" name="txtUsername" title="Username required" placeholder="Tên Đăng Nhập" data-icon="U">
							<input type="password" name="txtPassword" title="Password required" placeholder="Mật Khẩu" data-icon="x">
							<div class="olvido">
								<div class="col"><a href="dang-ky.jsp" title="Ver Carásteres">Đăng Ký</a></div>
								<div class="col"><a href="quen-mat-khau.jsp" title="Recuperar Password">Quên mật khẩu</a></div>
							</div>
							<button class="enviar">Đăng Nhập</button>
						</form>
						<script type="text/javascript">
							function xacThucDangNhap() {
								var username_input = document.forms["form-dang-nhap"]["txtUsername"].value;
								var password_input = document.forms["form-dang-nhap"]["txtPassword"].value;
							    if (username_input == "" || password_input == "") {
						        	alert("Không được để trống");
							        return false;
							    }
								
							}
						</script>
					</section>
                  
                  
                  
                  
                </ol>
              </div>
            </div>
            </div>
            </div>
            </div>
          <div class="clearfix">
          </div>
          
        </div>
      