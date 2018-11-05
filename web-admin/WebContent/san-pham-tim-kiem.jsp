<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chi Tiết Sản Phẩm</title>
    <link rel="icon" href="images/Logo.png" type="image/png" sizes="16x16">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="CTSearch.css" />
    <script src="main.js"></script>
</head>
<body>

        <div class="top">
                <div class="container">
                    <div id="logo">
                        <h3>Chi Tiết Sản Phẩm</h3>
                    </div>
        
                    <div id="nameNV"> 
                        <p>Xin chào </p>
                        <!--Tên nhân viên lấy từ CSDL-->
                        <p>${sessionScope.staff.ten_nhan_vien}</p>
                       	<!--<p>Admin</p>-->
                        <div class="dangxuat">
                            <a href="DangXuat" class="logout">Đăng xuất</a>
                        </div>
                    </div>
                </div>
        </div>


        <div class="main">
            <div class="container">
            	<div class="count">
            		<h4>Tìm được tổng cộng <strong><font color="red">${dssp_ten.size()} sản phẩm</font></strong> </h4>
            	</div>
                <div class="float">
                <c:forEach items="${dssp_ten}" var="sp">
                    <form action="DocCTSanPham?id=${sp.ma_san_pham}" method="POST">
                        <div class="onesp">
                            <div class="thumbnail">
                                <a href="DocCTSanPham?id=${sp.ma_san_pham}">
                                	<img src="data:image/jpeg;base64,${sp.hinh_anh}" class="hinhsp" alt="Hinh=san-pham">
                                </a>
                            </div>

                            <div class="text">
                                <div class="tensp">
                                    ${sp.tenSanPham}
                                </div>

                                <div class="price"><f:formatNumber type="number" value="${sp.giaSanPham}" /> ₫</div>

                                <div class="edit">
                                    <a href="DocCTSanPham?id=${sp.ma_san_pham}">
                                        <input type="button" value="Sửa" id="btSua">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </form>
                 </c:forEach>
                </div>
            </div>
            </div>

            
        </div>
    
</body>
</html>


<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
                	<c:forEach items="${dssp_ten}" var="sp">
   	                  <form action="themGioHang?id=${sp.ma_san_pham}" method="post">    
		                  <div class="col-md-4 col-sm-6">
		                    	<div class="products">
	                                <div class="offer">Trả Góp 0%</div>
	                                <div class="thumbnail"><a href="ChiTietSanPhamServlet?id=${sp.ma_san_pham}"><img src="data:image/jpeg;base64,${sp.hinh_anh}" class="kichthuoc"></a></div>
	                                <div class="productname">${sp.tenSanPham}</div>
	                                <h4 class="price"><f:formatNumber type="number" value="${sp.giaSanPham}" /> ₫</h4>
	                                <div class="button_group"><button class="button add-cart" type="submit">Mua</button><button class="button compare" type="button"><i class="fa fa-exchange"></i></button><button class="button wishlist" type="button"><i class="fa fa-heart-o"></i></button></div>
	                           	</div>
		                  </div>
		              </form>    
                  </c:forEach>
                  </div>
</body>
</html>-->

