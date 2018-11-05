<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Database.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DTO.*" %>
<%@ page import="java.sql.*"%>



<!DOCTYPE html>
<html lang="en">

<head>
    <title>Quản lý thẻ thành viên</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="QLThe.css">
    <link rel="icon" href="images/Logo.png" type="image/png" sizes="16x16">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	
	
	

</head>

<body>

    <nav class="navbar" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>                        
                </button>
                <a class="navbar-brand" href="cong-viec.jsp">Trang Quản Lý Admin</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="quan-ly-san-pham">Sản Phẩm</a></li>
                    <li><a href="quan-ly-nhan-vien">Nhân Viên</a></li>
                    <li><a href="quan-ly-thanh-vien">Thành Viên</a></li>
                    <li><a href="quan-ly-don-hang">Đơn Hàng</a></li>
                    <li>
                        <button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-cog"></span>Admin<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="admin">
                            <li style="padding: 10px;
                            font-size: 14px;
                            font-weight: bold;">Xin Chào, ${sessionScope.staff.ten_nhan_vien}</li>
                           
                            <li><a href="chiTietNhanVien?id=${sessionScope.staff.idnhan_vien}">My Profile</a></li>
                            
                            <li><a href="DangXuat">Đăng Xuất</a></li>
                        </ul>
            </div>
            </li>
            </ul>
        </div>
        </div>
    </nav>

    <div class="container text-center">
        <div class="row content">
            <div class="col-sm-11">
                <h3 class="text-center">Danh Sách Các Loại Thẻ</h3>
                </h3>
            </div>
            <div class="col-sm-7">
                <div class="table-responsive-sm">
                    <table class="table">
                        <form action="" method="POST" class="form-control">
                            <thead>
                                <th class="text-center">Mã thẻ: </th>
                                <th class="text-center">Loại thẻ: </th>
                                <th class="text-center">Điểm hiện có: </th>
                                <th class="text-center">Số lượng: </th>
                            </thead>

                            <tbody>
                             	<c:forEach items="${ds_the}" var="the">
	                                <tr>
	                                    <td class="text-center">${the.id_the_tich_diem}</td>
	                                    <td class="text-center">${the.loai_the}</td>
	                                    <td class="text-center">${the.diem}</td>
	                                    <td class="text-center">${the.so_luong}</td>
	                                </tr>
                                </c:forEach>
                            </tbody>
                        </form>
                    </table>
                </div>
            </div>
            <div class="col-sm-5 sidenav">
                    <button type="button" class="addToggle" id="addToggle" data-toggle="collapse" data-target="#modal">
                        Thêm thẻ
                    </button>

                    <div class="modal" id="modal">
                        <table class="table-responsive">
                            <form action="themLoaiThe" method="POST" name="addThe" accept-charset="UTF-8">
                                <tr>
                                    <th>Mã thẻ: </th>
                                    <td>
                                        <input type="text" name="txtMaLoaiThe" class="txtadd" placeholder="Nhập mã thẻ...">
                                    </td>
                                </tr>

                                <tr>
                                    <th>Tên thẻ: </th>
                                    <td>
                                        <input type="text" name="txtLoaiThe" class="txtadd" placeholder="Nhập tên thẻ...">
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <input type="submit" class="btf" id="btThem" value="Thêm">
                                    </td>
                                    <td>
                                        <input type="button" class="btf" id="btReset" value="Reset">
                                    </td>
                                </tr>
                            </form>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <footer class="container-fluid text-center">
        <p>Trụ sở chính: 371 Nguyễn Kiệm, Q.Gò Vấp</p>
    </footer>



</body>

</html>