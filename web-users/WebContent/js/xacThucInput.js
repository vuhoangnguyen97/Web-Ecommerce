function xacThuc() {
    var email_input = document.forms["formEmail"]["email"].value;
    var check_email = email_input.indexOf("@");
    var check_email_dot = email_input.lastIndexOf(".");
    if (email_input == null) {
        alert("Không được để trống");
        return false;
    }
    else if (check_email<1 || check_email_dot<check_email+2 || check_email_dot+2 >= email_input.length) {
        alert("Email bạn không hợp lệ");
        return false;
    }
    
}

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
}

function xacThucDangNhap() {
	var username_input = document.forms["form-dang-nhap"]["txtUsername"].value;
	var password_input = document.forms["form-dang-nhap"]["txtPassword"].value;
    if (username_input == "" || password_input == "") {
    	alert("Không được để trống");
        return false;
    }
	
}

function xacThucTimKiem() {
    var san_pham = document.forms["formTimKiem"]["txtSanPham"].value;
    if (san_pham == "") {
        alert("Không được để trống");
        return false;
    }
}

