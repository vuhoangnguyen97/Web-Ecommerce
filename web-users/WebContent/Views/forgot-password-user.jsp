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
	  					<div class="titulo">Khôi phục mật khẩu</div>
						<form name="form-khoi-phuc" onsubmit="return xacThucKhoiPhuc()"  action="quenMatKhauServlet" method="post">
							<input type="text" name="txtUsername" title="Username required" placeholder="Tên Đăng Nhập" data-icon="U">
							<input type="text" name="txtEmail" title="Email required" placeholder="Email khôi phục" data-icon="x">
							<br/><br/><br/>
							<button class="enviar">Khôi phục</button>
						</form>
						<script type="text/javascript">
							function xacThucKhoiPhuc() {
								var username_input = document.forms["form-khoi-phuc"]["txtUsername"].value;
								var email_input = document.forms["form-khoi-phuc"]["txtEmail"].value;
								var check_email = email_input.indexOf("@");
							    var check_email_dot = email_input.lastIndexOf(".");
							    
								if (username_input == "" || email_input == "") {
						        	alert("Không được để trống");
							        return false;
							    }
							 	// check email regex
							    else if (check_email<1 || check_email_dot<check_email+2 || check_email_dot+2 >= email_input.length) {
							        alert("Email bạn không hợp lệ");
							        return false;
							    }							}
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
      