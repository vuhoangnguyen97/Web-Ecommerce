<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="container_fullwidth">
	<div class="container">
	<div class="row">
		<jsp:include page="/Views/menu-ben-trai.jsp"></jsp:include>
		<div class="col-md-9">
              <div class="checkout-page">
                <ol class="checkout-steps">
                  <li class="steps">
                    <div class="step-title">
                    	<a href="dang-nhap.jsp">
                      		01. Bạn đã có tài khoản ?
                      	</a>
                    </div>
                  </li>
                  <li class="steps active">
                    <a href="dang-ky.jsp" class="step-title">
                      02. Thành viên mới ?
                    </a>
                    <div class="step-description">
                      <form name="form-dang-ky" action="dangKyServlet" method="POST" onsubmit="return xacThucDangKy()">
                        <div class="row">
                          <div class="col-md-6 col-sm-6">
                            <div class="your-details">
                              <h5>
                                Đăng ký thành viên
                              </h5>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Username 
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" style="padding-left: 130px;" class="input namefild" name="txtUsername">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Mật khẩu 
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="password" class="input namefild" name="txtPassword">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Lập lại mật khẩu: 
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input style="padding-left: 190px;"  type="password" class="input namefild" name="txtPasswordRepeat">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Họ: 
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" name="txtHo">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Tên: 
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" name="txtTen">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Số điện thoại: 
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input style="
    								padding-left: 160px;
                                "	 type="text" class="input namefild" name="txtSDT">
                              </div>
                              <div class="pass-wrap">
                                <div class="form-row">
                                  <label class="lebel-abs">
                                    Email: 
                                    <strong class="red">
                                      *
                                    </strong>
                                  </label>
                                  <input type="email" class="input namefild" name="txtEmail">
                                </div>
                              </div>
                              
                            </div>
                          </div>
                          <div class="col-md-6 col-sm-6">
                            <div class="your-details">
                              <h5>
                                Địa chỉ giao hàng
                              </h5>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Địa chỉ
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" name="txtDiaChi">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Quận
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" name="txtQuan">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Phường
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" name="txtPhuong">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Thành phố:
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input style="padding-left: 140px" type="text" class="input namefild" name="txtThanhPho">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Quốc gia: 
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input style="padding-left: 130px" type="text" class="input namefild" name="txtQuocGia">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Zip code: 
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input style="padding-left: 120px" type="text" class="input namefild" name="txtZipCode">
                              </div>
                              
                              <button class="enviar">
                                Đăng ký
                              </button>
                            </div>
                          </div>
                        </div>
                      </form>
                      <script type="text/javascript">
                      		function xacThucDangKy() {
                      			var username_input = document.forms["form-dang-ky"]["txtUsername"].value;
								var password_input = document.forms["form-dang-ky"]["txtPassword"].value;
								var password_repeat = document.forms["form-dang-ky"]["txtPasswordRepeat"].value;
								var ho_input = document.forms["form-dang-ky"]["txtHo"].value;
								var ten_input = document.forms["form-dang-ky"]["txtTen"].value;
								var soDienThoai_input = document.forms["form-dang-ky"]["txtSDT"].value;
								var email_input = document.forms["form-dang-ky"]["txtEmail"].value;
								var diaChi_input = document.forms["form-dang-ky"]["txtDiaChi"].value;
								var thanhPho_input = document.forms["form-dang-ky"]["txtThanhPho"].value;
								var quocGia_input = document.forms["form-dang-ky"]["txtQuocGia"].value;
								var zipCode_input = document.forms["form-dang-ky"]["txtZipCode"].value;
								// variable telephone regex: 
								var regEx = /^0(1\d{9}|9\d{8})$/;
                      			var regExUser = /[~`!#$%\^&*+=\-\[\]\\';,/{}|\\":<>\?]/;
								// check empty 
								var check_email = email_input.indexOf("@");
							    var check_email_dot = email_input.lastIndexOf(".");
							    if (username_input == "" || password_input == "" ||
						    		password_repeat == "" || ho_input == "" ||
						    		ten_input == "" || soDienThoai_input == "" ||
						    		email_input == "" || diaChi_input == "" ||
						    		thanhPho_input == "" || quocGia_input == "" ||
						    		zipCode_input == "") {
							        	alert("Không được để trống");
								        return false;
							    }
								// check password 
							    else if(password_input != password_repeat){
							    	alert("Mật khẩu nhập lại không giống nhau");
							    	return false;
							    }
								// check email regex
							    else if (check_email<1 || check_email_dot<check_email+2 || check_email_dot+2 >= email_input.length) {
							        alert("Email bạn không hợp lệ");
							        return false;
							    }
							    // check phone regex
							    else if(regEx.test(soDienThoai_input) == false){
							    	alert("Số điện thoại không hợp lệ");
							    	return false;
							    }
							    else if(password_input.length <= 6){
							    	alert("Mật khẩu yếu, yêu cầu phải lớn hơn 6 ký tự");
							    	return false;
							    }
							}
					  </script>
                    </div>
                  </li>
                  
                </ol>
              </div>
            </div>
		</div>
          <div class="clearfix">
          </div>
          <jsp:include page="/Views/lien-ket-thuong-hieu.jsp"></jsp:include>
        </div>
      </div>
     