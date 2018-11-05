<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Database.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DTO.*" %>
<%@ page import="java.sql.*"%>
<c:if test="${sessionScope.member != null}">
	<h1> Bạn không có quyền truy cập trang này!</h1>
</c:if>
<c:if test="${sessionScope.member == null}">
	<c:if test="${sessionScope.staff == null}">
		<jsp:include page="trang-nhan-vien"/>
	</c:if>
	<c:if test="${sessionScope.staff != null}">
		<!DOCTYPE html>
		<html lang="en">
			<head>
			    <meta charset="UTF-8">
			    <meta name="viewport" content="width=device-width, initial-scale=1.0">
			    <meta http-equiv="X-UA-Compatible" content="ie=edge">
			    <title>Quản Lý Nhân Viên</title>
			    <link rel="icon" href="images/Logo.png" type="image/png" sizes="16x16">
			    <link rel="stylesheet" type="text/css" media="screen" href="QLNV.css" />
			    <script src="QLNV.js"></script>
			    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
			    <%!
					    Connection db = Database.connect();
					    Statement stm = null;
					    ResultSet rs = null;
					    String query = "SELECT * FROM nhan_vien INNER JOIN chuc_vu ON nhan_vien.ma_chuc_vu = chuc_vu.ma_chuc_vu order by idnhan_vien asc";
					    
					    // nên khai báo trực tiếp
					    
				%>
			</head>
			<body>
			        <div class="top">
			                <div class="container">
			                    <div id="logo">
			                        <h3>Quản Lý Nhân Viên</h3>
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
			                    <a href="quan-ly-thanh-vien" target="blank">
			                        <input type="button" class="QLTV" value="Quản Lý Thành Viên">
			                    </a>
			                </div>
			        
			                </div>
			        
			        
			        
			        
			            </div>
			        
			            <div class="main">
			                <div class="container">
			                    <!--bảng này để đổ dữ liệu từ dưới CDSL lên-->
			                    <div class="table">
			                        <table id="table1">
			                            <p class="title1">DANH SÁCH NHÂN VIÊN</p>
			                            <thead>
			                                <tr>
			                                    <th>Mã Nhân Viên</th>
			                                    <th>Username</th>
			                                    <th>Password</th>
			                                    <th>Họ</th>
			                                    <th>Tên</th>
			                                    <th>Chức Vụ</th>
			                                    <th>Email</th>
			                                    <th>Số Điện Thoại</th>
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
					                        	id = Integer.parseInt(rs.getString("idnhan_vien"));
				                        	%>
						                        <tr class="odd">	                            
												    <td><%=rs.getString("idnhan_vien") %></td>
												    <td><%=rs.getString("username") %> </a></td>
												    <td><%=rs.getString("password") %></td>
												    <td><%=rs.getString("ho_nhan_vien") %></td>
												    <td><a href="chiTietNhanVien?id=<%=rs.getString("idnhan_vien")%>"><%=rs.getString("ten_nhan_vien") %></td>
												    <td><%=rs.getString("chuc_vu") %></td>
												    <td><%=rs.getString("email") %></td>
												    <td><%=rs.getInt("sdt") %></td>
												    
						                            <td class="SX">
						                                <a href="chiTietNhanVien?id=<%=rs.getString("idnhan_vien")%>">
						                                	<input type="button" value="Sửa" class="xoa">
						                                </a>
						                            </td>
						                            <td class="SX">
						                                	<input type="button" value="Xóa" class="xoa" onclick="xoa()">
						                                <!--<a href="#" onclick="xoa()">Xóa</a>  -->
						                            </td>
						                        </tr>
						 					 <%}%>
			                            </tbody>
			                        </table>
			                    </div>
			                    
			                    
			                    
			                    <!--
			                    	<jsp:include page="nhanVienBiXoa"/>
			                    -->
			                    
			                    <div id="myModal" class="modal">
							        <div class="modal-content">
							            <span class="close1" onclick="dong()">&times;</span>
							            <table id="alert">
							                <tr>
							                    <th colspan="2">Bạn có muốn xóa sản phẩm không?</th>
							                </tr>
							
							                <tr>
							                    <td>
							                    	
							                    	<a href="XoaNhanVien?id=<%=id%>">
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
			                        <form action="#" method="GET">
			                            <a href="them-nhan-vien" target="_blank">
			                                <input type="button" value="Thêm Nhân Viên" id="btsub">
			                            </a>
			                        </form>
			                    </div>
			                </div>
			            </div>
			</body>
		</html>
	</c:if>
</c:if>
