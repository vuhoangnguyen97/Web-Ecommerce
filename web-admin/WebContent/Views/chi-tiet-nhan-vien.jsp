<%@page import="DTO.chucVu"%>
<%@page import="DAO.chucVuDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.staff.ma_chuc_vu ==2}">
	<h1> Không có quyền truy cập</h1>
</c:if>
<c:if test="${sessionScope.staff.ma_chuc_vu ==1 || sessionScope.staff.ma_chuc_vu ==3}">    

    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chi Tiết Nhân Viên</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="CTNV.css" />
    <script src="CTNV.js"></script>
</head>
<body>
        <div class="top">
                <div class="container">
                    <div id="logo">
                        <h3>Chi Tiết Sản Phẩm</h3>
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
        
        <div class="hinhanh">
                <div class="container">
                    <div class="hinhsp">
                        
                        <!--Hình sản phẩm-->
                        <img src="data:image/jpeg;base64,${chitiet.hinh_anh}" class="kichthuoc">
                    </div>
                </div>
        </div>

        <div class="main">
                <div class="container">
                    <div class="thongtin">
                        <form action="suaNhanVienController" method="GET" class="fMain">
                            <div class="tensp">
                                <p>${chitiet.ho_nhan_vien}  ${chitiet.ten_nhan_vien}</p>
                            </div>
        
                            <!--Bảng thông tin chi tiết-->
                            <table class="table">
                                <tr>
                                    <th>Mã nhân viên:</th>
                                    <td>
                                    	<c:set var="id_nhanvien" value="${chitiet.idnhan_vien}"/>
                                    	<% int id = Integer.parseInt(pageContext.getAttribute("id_nhanvien").toString()); %>
                                        <input type="text" name="txtIDNhanVien" class="txtsp" id="txtsp" value="<%=id %>" disabled>
                                    </td>
                                </tr>
        
                                <tr>
                                    <th>Username:</th>
                                    <td>
                                        <input type="text" name="txtUsername" class="txtsp" id="txtsp1" value="${chitiet.username}" disabled>
                                    </td>
                                </tr>
        
                                <tr>
                                    <th>Password:</th>
                                    <td>
                                        <input type="password" name="txtPassword" class="txtsp" id="txtsp2" value="${chitiet.password}" disabled>
                                    </td>
                                </tr>
        
                                <tr>
                                    <th>Họ:</th>
                                    <td>
                                        <input type="text" name="txtHo" class="txtsp" id="txtsp3" value="${chitiet.ho_nhan_vien}" disabled>
                                    </td>
                                </tr>
        
                                <tr>
                                    <th>Tên:</th>
                                    <td>
                                        <input type="text" name="txtTen" class="txtsp" id="txtsp4" value="${chitiet.ten_nhan_vien}" disabled>
                                    </td>
                                </tr>
        
                                <tr>
                                    <th>Chức vụ:</th>
                                    <td>
                                    	
                                        <select class="fchucvu" id="fchucvu" name="txtMaChucVu" value="${chitiet.ma_chuc_vu}" disabled>
	                                        	<!-- admin -->
	                                         	<c:if test="${sessionScope.staff.ma_chuc_vu==1}"> <!-- sessionScope là account đang đăng nhập -->                                         		
	                                         		<c:if test="${chitiet.ma_chuc_vu==1}"> <!--  -->
	                                         			<option value="1" >${chitiet.chuc_vu}</option>
			                                            <option value="2" >Nhân viên</option>
			                                            <option value="3" >Moderator</option>
	                                         		</c:if>
	                                         		<c:if test="${chitiet.ma_chuc_vu==2}"> <!--  -->
	                                         			<option value="2" >${chitiet.chuc_vu}</option>
			                                            <option value="1" >Admin</option>
			                                            <option value="3" >Moderator</option>
	                                         		</c:if>
	                                         		<c:if test="${chitiet.ma_chuc_vu==3}"> <!--  -->
	                                         			<option value="3" >${chitiet.chuc_vu}</option>
			                                            <option value="2" >Nhân viên</option>
			                                            <option value="1" >Admin</option>
	                                         		</c:if>	                                         	
	                                         	</c:if>	                                         	
	                                         	<c:if test="${sessionScope.staff.ma_chuc_vu==3}">	                                         		
	                                         		<c:if test="${chitiet.ma_chuc_vu==2}">
	                                         			<option value="2" >${chitiet.chuc_vu}</option>			                                            
			                                            <option value="3" >Moderator</option>
	                                         		</c:if>
	                                         		<c:if test="${chitiet.ma_chuc_vu==3}">
	                                         			<option value="3" >${chitiet.chuc_vu}</option>		                                            
			                                            
	                                         		</c:if>
	                                         		<c:if test="${chitiet.ma_chuc_vu==1}">
	                                         			<option value="1" >${chitiet.chuc_vu}</option>	                                            
			                                            
	                                         		</c:if>
	                                         				                                         	
	                                         	</c:if>
	                                         	
	                                    </select>
                                    </td>
                                </tr>
        
                                <tr>
                                    <th>Email:</th>
                                    <td>
                                        <input type="text" name="txtEmail" class="txtsp" id="txtsp6" value="${chitiet.email}" disabled>
                                    </td>
                                </tr>
        
                                <tr>
                                    <th>Số điện thoại:</th>
                                    <td>
                                        <input type="text" name="txtSdt" class="txtsp" id="txtsp7" value="${chitiet.sdt}" disabled>
                                    </td>
                                </tr>
        
                                <tr>
                                    <td colspan="2">
                                        <form action="#" method="POST" id="fix">
                                            <!--<input type="button" value="Edit" id="btfix" onclick="bt1(); bt();">-->
                                            <!-- 
                                            	nếu ma chuc vu 1: 
                                             -->
                                            <c:if test="${sessionScope.staff.ma_chuc_vu ==1}">
                                            	<input type="button" value="Edit" id="btfix" onclick="show()">
                                            </c:if>
                                            <!-- 
                                                nếu ma chuc vu 2(nhanvien): không vô đc
                                                nếu ma chuc vu 3(mod): chỉ đc sẽ mã chuc vu số 2
                                             -->
                                             <c:if test="${sessionScope.staff.ma_chuc_vu ==3}">
                                             	<c:if test="${chitiet.ma_chuc_vu==2}">
                                    	        	<input type="button" value="Edit" id="btfix" onclick="show()">                                            	
                                             	</c:if>
                                             </c:if>
                                            <!--<input type="button" value="Save" id="btsave" onclick="luu(); luu2();">-->
                                            <input type="button" value="Save" id="btsave" onclick="show1()">
                                        </form>
                                    </td>
                                </tr>
                            </table>
        
                            <!--Popup Sửa đi trước-->
                            <div id="myModal" class="modal">
                                <div class="modal-content">
                                    <form action="#" method="POST" id="ask1">
                                            <span class="close1" onclick="dong()">&times;</span>
                                            <table id="alert">
                                                <tr>
                                                    <th colspan="2">Bạn có muốn sửa sản phẩm không?</th>
                                                </tr>
                
                                                <tr>
                                                    <td>
                                                        <input type="button" value="Có" id="yes" class="btask" onclick="bt1(); bt();">
                                                    </td>
                
                                                    <td>
                                                        <input type="button" value="Không" id="no" class="btask" onclick="dong()">
                                                    </td>
                                                </tr>
                                            </table>
                                    </form>
                                </div>
                            </div>
        
                            <!--Popup lưu đi sau-->
                            <div id="myModal1" class="modal">
                                <div class="modal-content">
                                        <span class="close1" onclick="dong()">&times;</span>
                                        <table id="alert1">
                                                <tr>
                                                        <th colspan="2">Bạn có muốn lưu không?</th>
                                                    </tr>
                    
                                                    <tr>
                                                        <td>
                                                            <input type="submit" value="Có" id="yes" class="btask" onclick="bt1(); luu(); luu2(); dong1();">
                                                        </td>
                    
                                                        <td>
                                                            <input type="button" value="Không" id="no" class="btask" onclick="dong1()">
                                                        </td>
                                                    </tr>
                                        </table>
                                </div>
                            </div>
                        </form>
                    </div>
           
                </div>
            </div>
</body>
</html>
</c:if>