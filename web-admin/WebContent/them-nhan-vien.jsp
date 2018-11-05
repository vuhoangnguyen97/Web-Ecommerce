<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.member != null}">
	<h1> Bạn không có quyền truy cập trang này!</h1>
</c:if>
<c:if test="${sessionScope.member == null}">
	<c:if test="${sessionScope.staff == null}">
		<jsp:include page="trang-nhan-vien"/>
	</c:if>
	<c:if test="${sessionScope.staff != null}">
		<c:if test="${sessionScope.staff.ma_chuc_vu ==2}">
			<h1> Không có quyền truy cập</h1>
		</c:if>
		<c:if test="${sessionScope.staff.ma_chuc_vu ==1 || sessionScope.staff.ma_chuc_vu ==3}">
			<!DOCTYPE html>
			<html lang="en">
			<head>
			    <meta charset="UTF-8">
			    <meta name="viewport" content="width=device-width, initial-scale=1.0">
			    <meta http-equiv="X-UA-Compatible" content="ie=edge">
			    <link rel="shortcut icon" href="images/favicon.png">
			    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			    <title>Thêm Nhân Viên</title>
			    <link rel="stylesheet" type="text/css" media="screen" href="ThemNV.css" />
			    <script src="ThemNV.js"></script>
			</head>
			<body>
			        <div class="top">
			                <div class="container">
			                    <div id="logo">
			                        <h3>Thêm Nhân Viên</h3>
			                    </div>
			        
			                    <div id="nameNV"> 
			                        <p>Xin chào</p> 
			                        <!--Tên nhân viên lấy từ CSDL-->
			                        <p>${sessionScope.staff.ten_nhan_vien}</p>
			                        <div class="dangxuat">
			                            <a href="DangXuat" class="logout">Đăng xuất</a>
			                        </div>
			        
			                    </div>
			                </div>
			        </div>
			
			        <div class="main">
			                <div class="container">
			                    <div class="mainform">
			                        <form action="ThemNVController" method="POST" class="fSanpham" id="fSanpham" enctype="multipart/form-data">
			                            <div id="left">
			                                <table class="bang1">
			                                <tr>
			                                    <th>Mã Nhân Viên:</th>
			                                    <td>
			                                        <input type="text" name="txtMaNhanVien" class="txtsp" id="txtsp" value="">
			                                    </td>
			                                </tr>
			    
			                                <tr>
			                                    <th>Username:</th>
			                                    <td>
			                                        <input type="text" name="txtusername" class="txtsp" id="txtsp1" value="">
			                                    </td>
			                                </tr>
			    
			                                <tr>
			                                    <th>Password:</th>
			                                    <td>
			                                        <input type="password" name="txtpassword" class="txtsp" id="txtsp2" value="">
			                                    </td>
			                                </tr>
			    
			                                <tr>
			                                    <th>Họ:</th>
			                                    <td>
			                                        <input type="text" name="txtHoNhanVien" class="txtsp" id="txtsp3" value="">
			                                    </td>
			                                </tr>
			    
			                                <tr>
			                                    <th>Tên:</th>
			                                    <td>
			                                        <input type="text" name="txtTenNhanVien" class="txtsp" id="txtsp10" value="">
			                                    </td>
			                                </tr>
			                                
			                                <tr>
			                                    <th>Chức Vụ:</th>
			                                    <td>
			                                        <select class="fchucvu" name="txtMaChucVu">
			                                        	<!-- admin -->
			                                         	<c:if test="${sessionScope.staff.ma_chuc_vu==1}">
				                                         	<option value="1" >Admin</option>
				                                            <option value="2" >Nhân Viên</option>
				                                            <option value="3" >Moderator</option>
			                                         	</c:if>
			                                         	<!-- mod -->
			                                         	<c:if test="${sessionScope.staff.ma_chuc_vu==3}">		                                         	
				                                            <option value="2" >Nhân Viên</option>
			                                         	</c:if>
			                                            
			                                        </select>
			                                    </td>
			                                </tr>
			    
			                                <tr>
			                                    <th>Email:</th>
			                                    <td>
			                                        <input type="text" name="txtEmail" class="txtsp" id="txtsp4" value="">
			                                    </td>
			                                </tr>
			    
			                                <tr>
			                                    <th>Số điện thoại:</th>
			                                    <td>
			                                        <input type="text" name="txtsdt" class="txtsp" id="txtsp5" value="">
			                                    </td>
			                                </tr>
			    
			                            </table>
			    
			                                <div class="btsub">
			                                    <input type="submit" value="Thêm" id="btthem">
			                                    <input type="button" value="Reset" id="btreset" onclick="reset()">
			                                </div>
			                            </div>
			                            
			                            <div id="right">
			                                <img id="hinhsp" class="hinhanh">
			                                <input type="file" name="txtHinhNhanVien" value="Resize Image" id="upImage" onclick="ResizeImage()">
			                            </div>
			                        </form>
			                    </div>
			                </div>
			            </div>
			            
			     <script>
			        $("input").change(function(e) {
			
			        for (var i = 0; i < e.originalEvent.srcElement.files.length; i++) {
			        
			        var file = e.originalEvent.srcElement.files[i];
			        
			        var img = document.getElementById("hinhsp");
			        var reader = new FileReader();
			        reader.onloadend = function() {
			             img.src = reader.result;
			        }
			        reader.readAsDataURL(file);
			        $("hinhsp   ").after(img);  
			    }
			});
			
			    </script>
			</body>
			</html>
			
		</c:if>
	</c:if>
</c:if>
