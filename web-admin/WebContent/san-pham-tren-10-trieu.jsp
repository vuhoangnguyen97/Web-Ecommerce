<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chi tiết sản phẩm</title>
    <link rel="icon" href="images/Logo.png" type="image/png" sizes="16x16">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="CTSearchGia.css" />
    <script src="CTSearchGia.js"></script>
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
            		<h4>Tìm được tổng cộng <strong><font color="red">${dssp_tren10Trieu.size()} sản phẩm</font></strong> </h4>
            	</div>
                <div class="search">
                    
                </div>

                <div class="float">
                    <c:forEach items="${dssp_tren10Trieu}" var="sp">
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

            
    
</body>
</html>

</body>
</html>