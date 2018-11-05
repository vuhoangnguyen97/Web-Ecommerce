<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="JavaBeans.*" %> 
<%@page import="BusinessLogics.*" %>

<!DOCTYPE html>
<html>
<head>
      <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
      <meta name="description" content="Hệ Thống bàn hàng trực tuyến hàng đầu VN hay đến với chúng tôi để sở hữu những sản phẩm chất lượng với giá hấp dẫn">
      <meta name="author" content="Nhóm phát triển, Back-End: Nguyên">
      <meta name="keywords" content="apple, iphone, samsung, dien thoai, gia re, mua hang, phu kien">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="shortcut icon" href="images/favicon.png">
      <title>Welcome to Dienthoaionline.com - Hệ thống bán điện thoại trực tuyến toàn quốc</title>
      <meta name="keywords" content="dienthoaionline , dien thoai sach tay , hang free cho khong">
      <link href="css/bootstrap.css" rel="stylesheet">
      <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100' rel='stylesheet' type='text/css'>
      <link href="css/font-awesome.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>
      <link href="css/sequence-looptheme.css" rel="stylesheet" media="all"/>
      <link href="css/style.css" rel="stylesheet">
      <script type="text/javascript" src="http://gc.kis.scr.kaspersky-labs.com/1B74BD89-2A22-4B93-B451-1C9E1052A0EC/main.js" charset="UTF-8"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" type="text/css" href="popupsosanh.css">
    </head>   
<body id="home">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <span class="title">Chọn Sản Phẩm Cần So Sánh</span>
                <table class="table table-responsive">
                    <form action="compareProduct" method="POST" class="form-control">
                        <tbody>
                            <tr>
                                <td>
                                    <select name="cboSanPhamCanSoSanh" id="select-left">
                                        <option value="${spCanSoSanh.ma_san_pham}">${spCanSoSanh.tenSanPham}</option>
                                        
                                    </select>
                                </td>
                                <td>
                                    <select name="cboSanPhamSoSanh" id="select-right">
                                    	<c:forEach items="${dsSanPhamTheoHang}" var="spSoSanh">
                                    		<option value="${spSoSanh.ma_san_pham}">${spSoSanh.tenSanPham}</option>
                                    	</c:forEach>  
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td id="btnSS" colspan="2">
                                    <input type="submit"  class="btn btn-success" value="So Sánh">
                                </td>
                            </tr>
                        </tbody>
                        
                    </form>
                </table>
            </div>
        </div>
    </div>
    
        
</body>
</html>