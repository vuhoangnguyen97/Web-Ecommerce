<%@page import="DAO.ThanhVienDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Database.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DTO.*" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<c:if test="${sessionScope.member != null}">
	<h1> Bạn không có quyền truy cập trang này!</h1>
</c:if>
<c:if test="${sessionScope.member == null}">
	<c:if test="${sessionScope.staff == null}">
		<jsp:include page="trang-nhan-vien"/>
	</c:if>
	<c:if test="${sessionScope.staff != null}">
		<!DOCTYPE html>
		<html>
		<head>
		    <meta charset="utf-8" />
		    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		    <title>Quản Lý Thành Viên</title>
		    <link rel="icon" href="images/Logo.png" type="image/png" sizes="16x16">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" type="text/css" media="screen" href="QLTV.css" />
		    <script src="QLTV.js"></script>
		    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		    <%!
				    Connection db = Database.connect();
				    Statement stm = null;
				    ResultSet rs = null;
				    String query = "SELECT `iduser`, `username`, `password`, `ho_user`, `ten_user`, `sdt`, `email`, `dia_chi`, `quan`, `phuong`, `thanh_pho`, `nuoc`, `zip_code`,`diem_tich_luy`,`loai_the` FROM `user` INNER JOIN the_tich_diem ON the_tich_diem.id_the_tich_diem =  user.id_the_tich_diem INNER JOIN loai_the ON loai_the.id_loai_the = the_tich_diem.id_loai_the";	    
				    
				    
				    // nên khai báo trực tiếp
				    
			%>
		</head>
		<body>
		    
		    <div class="top">
		        <div class="container">
		            <div id="logo">
		                <h3>Quản Lý Thành Viên</h3>
		            </div>
		
		            <div id="nameNV"> 
		                <p>Xin chào </p>
		                <!--Tên nhân viên lấy từ CSDL-->
		                <p>${sessionScope.staff.ten_nhan_vien}</p>
		                <div class="dangxuat">
		                    <a href="DangXuat" class="logout">Đăng xuất</a>
		                </div>
		
		            </div>
		        </div>
		    </div>
		
		    <div class="trangkhac">
		        <div class="container">
		            
		        <div class="dieuhuong">
		            <a href="quan-ly-san-pham" target="blank">
		                <input type="button" class="QLSP" value="Quản Lý Sản Phẩm">
		            </a>
		        </div>
		
		        <div class="dieuhuong">
		            <a href="quan-ly-don-hang" target="blank">
		                <input type="button" class="QLDH" value="Quản Lý Đơn Hàng">
		            </a>
		        </div>
		        
		        <div class="dieuhuong">
		            <a href="quan-ly-nhan-vien" target="blank">
		                <input type="button" class="QLNV" value="Quản Lý Nhân Viên">
		            </a>
		        </div>
		        
		        <div class="dieuhuong">
		            <a href="thongKeThe" target="_blank">
		                <input type="button" class="QLNV" id="searchCC" value="Quản lý thẻ thành viên">
		            </a>
		        </div>
		
		        </div>
		
		
		
		
		    </div>
		
		    <div class="main">
		        <div class="container">
		            <!--bảng này để đổ dữ liệu từ dưới CDSL lên-->
		            <div class="table">
		                <table id="table1">
		                    <p class="title1">DANH SÁCH KHÁCH HÀNG </p>
		                    <thead>
		                        <tr>
		                            <th>Mã khách hàng</th>
		                            <th>Username</th>
		                            <th>Password</th>
		                            <th>Tên khách hàng</th>
		                            <th>Số điện thoại</th>
		                            <th>Email</th>
		                            <th>Địa chỉ</th>
		                            <th>Quận</th>
		                            <th>Phường</th>
		                            <th>Thành phố</th>
		                            <th>Quốc giá</th>
		                            <th>Zip code</th>
		                            <th>Điểm</th>
		                            <th>Loại thẻ</th>
		                            <th></th>
		                            <th></th>
		                        </tr>
		                    </thead>
		                    
		                    <tbody>
		                        
		                        <% int id = 0; %>
				                        <%
				                        	stm = db.createStatement();
				                        	rs = stm.executeQuery(query);
				                        	while(rs.next()){
				                        	id = Integer.parseInt(rs.getString("iduser"));
			                        	%>
					                        <tr class="odd">	                            
											    <td><%=rs.getString("iduser") %></td>
											    <td><%=rs.getString("username") %> </a></td>
											    <td><%=rs.getString("password") %></td>
											    <td><a href="DocCTThanhVien?id=<%=rs.getString("iduser")%>"><%=rs.getString("ten_user") %></td>
											    <td><%=rs.getInt("sdt") %></td>
											    <td><%=rs.getString("email") %></td>
											    <td><%=rs.getString("dia_chi") %></td>
											    <td><%=rs.getString("quan") %></td>
											    <td><%=rs.getString("phuong") %></td>
											    <td><%=rs.getString("thanh_pho") %></td>
											    <td><%=rs.getString("nuoc") %></td>
											    <td><%=rs.getString("zip_code") %></td>
											    <td><%=rs.getInt("diem_tich_luy") %></td>
											    <td><%=rs.getString("loai_the") %></td>
											    
					                            <td class="SX">
					                                <a href="DocCTThanhVien?id=<%=rs.getString("iduser")%>">
					                                	<input type="button" value="Sửa" class="xoa">
					                                </a>
					                            </td>
					                            <td class="SX">
					                                	<input type="button" value="Xóa" class="xoa" onclick="xoa()">
					                                <!--<a href="#" onclick="xoa()">Xóa</a>  -->
					                            </td>
					                        </tr>
					 					 <%}
				                        	
					 					 %>
		
		                    </tbody>
		                </table>
		            </div>
		            
		            
		            
		            <div id="myModal" class="modal">
						        <div class="modal-content">
						            <span class="close1" onclick="dong()">&times;</span>
						            <table id="alert">
						                <tr>
						                    <th colspan="2">Bạn có muốn xóa sản phẩm không?</th>
						                </tr>
						
						                <tr>
						                    <td>
						                    	
						                    	<a href="XoaThanhVien?id=<%=id%>">
						                        	<input type="button" value="Có" id="yes" class="btask" onclick="dong()">
						                        </a>
						                    </td>
						
						                    <td>
						                  <input type="button" value="Không" id="no" class="btask" onclick="dong()">
						                    </td>
						                </tr>
						            </table>
						        </div>
						    </div>
		
		            <!--Nút Update này để load lại dữ liệu từ CSDL-->
		            <div class="update">
		                <form action="quan-ly-thanh-vien.jsp" method="GET">
		                    <input type="submit" value="Cập nhật danh sách" id="btsub">
		                </form>
		            </div>
		        </div>
		    </div>
			
		</body>
		</html>
	</c:if>
</c:if>