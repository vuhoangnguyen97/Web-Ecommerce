<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Database.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DTO.*" %>
<%@ page import="java.sql.*"%>

<!-- Khách Hàng vào thì in câu này-->
<c:if test="${sessionScope.member != null}">
	<h1> Bạn không có quyền truy cập trang này!</h1>
</c:if>

<!-- Nhân viên chưa đăng nhập vào thì in câu này -->
<c:if test="${sessionScope.member == null}">
	<c:if test="${sessionScope.staff != null}">
		<!DOCTYPE html>
		<html>
		<head>
		    <meta charset="utf-8" />
		    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		    <title>Quản Lý Sản Phẩm</title>
		    <link rel="icon" href="images/Logo.png" type="image/png" sizes="16x16">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" type="text/css" media="screen" href="QLHH.css" />
			<script src="QLHH.js"></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		    <%!
		    Connection db = Database.connect();
		    Statement stm = null;
		    ResultSet rs = null;
		    String query = "SELECT * FROM san_pham";
		    int soDongTrang = 5, tongSoTrang, trang = 1, viTriDau; // xài cục bộ trong mỗi trang này
		    // nên khai báo trực tiếp
		    
		%>
		<%
		    // lần đầu load trang
		    if(rs == null){
		        stm = db.createStatement(); // tạo kết nói csdl
		        rs = stm.executeQuery(query); // thực thi lệnh truy vấn sql ( 47 results)
		        rs.last();  
		        // quét tới cuối db
		        int tongSoDong = rs.getRow(); // 47 dòng 
		        tongSoTrang = tongSoDong/soDongTrang + (tongSoDong%soDongTrang != 0 ? 1 : 0);//Neu tongsoDong chia sodongtrang ma khong du thi khong add 1 trang moi, neu có dư thì sẽ add 1 trang mới
		        
		    }
		    /*<a href="....?trang=1">*/ // "trang" là Parameter
		    if(request.getParameter("trang") != null)
		        trang = Integer.parseInt(request.getParameter("trang"));
		    viTriDau = (trang-1)*5;  // TRANG 1 (1-1)*5
		    int stt = viTriDau+1;
		    rs = stm.executeQuery(query + " limit " + viTriDau + "," + soDongTrang) ;
		%>
		
		</head>
		<body>
		    <div class="top">
		        <div class="container">
		            <div id="logo">
		                <h3>Quản Lý Sản Phẩm</h3>
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
		                <a href="quan-ly-thanh-vien" target="blank">
		                    <input type="button" class="QLTV" value="Quản Lý Thành Viên">
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
                    	<input type="button" class="QLNV" id="searchCC" value="Tìm kiếm nâng cao">
            		</div>
		
		            <div class="search">
		                <form action="timSPTheoTen" method="POST" class="fSearch">
		                    <input type="search" name="txtTen" placeholder="Tìm kiếm sản phẩm" id="txtSearch" size="30">
		                    <input type="submit" value="" id="btSearch">
		                </form>
		            </div>
		            <script>
		            	
		            </script>
		            
		            <div class="searchCC">
		                <div class="brand">
		                    <strong>Tìm theo hãng:</strong>
		                    <select id="hang" onchange="changeFunc()">
		                        <option value="#"> --Chọn hãng-- </option>
		                        <option value="Apple">Apple</option>
		                        <option value="Samsung">Samsung</option>
		                        <option value="Sony">Sony</option>
		                        <option value="Beats">Beats</option> 
		                        <option value="Nokia">Nokia</option>
		                        <option value="Oppo">Oppo</option>
		                        <option value="Asus">Asus</option>
		                        <option value="HTC">HTC</option>
		                        <option value="Vivo">Vivo</option>
		                        <option value="Philips">Philips</option>
		                        <option value="Osmia">Osmia</option>
		                        <option value="Cosano">Cosano</option>
		                        <option value="Solid">Solid</option>
		                        <option value="eValu">eValu</option>
		                        <option value="eSaver">eSaver</option>
		                        
		                    </select>
		                </div>
		    
		                <div class="price">
		                    <strong>Tìm theo giá:</strong>
		                    <select id="gia" onchange="changeFuncPrice();">
		                        <option value="#">-- Mức Giá --</option>
		                        <option value="1">Dưới 1 triệu</option>
		                        <option value="2">1 - 3 triệu</option>
		                        <option value="3">3 - 7 triệu</option>
		                        <option value="4">7 - 10 triệu</option>
		                        <option value="5">Trên 10 triệu</option>
		                    </select>
		                </div>
            		</div>
            		
            		

		            
                    
		    </div>
		    </div>
		    
		    <br>
            <br>
		    
		    <div class="main">
		        <div class="container">
		            <div class="table">
		                <p class="title">DANH SÁCH SẢN PHẨM</p>
		                <form action="" method="POST" id="ask1">
		                <table id="sp">
		                    <thead>
		                        <tr>
		                            <th>Mã sản phẩm</th>
		                            <th>Tên sản phẩm</th>
		                            <th>Hãng sản xuất</th>
		                            <th>Giả sản phẩm</th>
		                            <th>Tình trạng</th>
		                            <th>Tính năng</th>
		                            <th>Camera trước</th>
		                            <th>Camera sau</th>
		                            <th>Dung lượng pin</th>
		                            <th>Màu sắc</th>
		                            <th>Bảo mật</th>
		                            <th></th>
		                            <th></th>
		                        </tr>
		                    </thead>
		
		                    <tbody>
		                    	<% int id = 0; %>
		                        <%while(rs.next()){
		                        	id = Integer.parseInt(rs.getString("ma_san_pham"));
	                        	%>
			                        <tr class="odd">	                            
									    <td><%=rs.getString("ma_san_pham") %></td>
									    <td><a href="DocCTSanPham?id=<%=rs.getString("ma_san_pham")%>"><%=rs.getString("ten_san_pham") %> </a></td>
									    <td><%=rs.getString("hang_san_xuat") %></td>
									    <td><%=rs.getInt("gia_san_pham") %></td>
									    <td><%=rs.getString("tinh_trang") %></td>
									    <td><%=rs.getString("tinh_nang") %></td>
									    <td><%=rs.getString("camera_truoc") %></td>
									    <td><%=rs.getString("camera_sau") %></td>
									    <td><%=rs.getString("dung_luong_pin") %></td>
									    <td><%=rs.getString("mau_sac") %></td>
									    <td><%=rs.getString("bao_mat") %></td>
			                            <td class="SX">
			                                <a href="DocCTSanPham?id=<%=rs.getString("ma_san_pham")%>">
			                                	<input type="button" value="Sửa" class="xoa">
			                                </a>
			                            </td>
			                            <td class="SX">
			                                	<input type="button" value="Xóa" class="xoa" onclick="xoa()">
			                                <!--<a href="#" onclick="xoa()">Xóa</a>  -->
			                            </td>
			                        </tr>
			 					 <%}rs.close();%>
		                    </tbody>
		                </table>
		                
		                <div id="myModal" class="modal">
                        <div class="modal-content">
                            <span class="close1" onclick="dong()">&times;</span>
                            <table id="alert">
                                <tr>
                                    <th colspan="2">Bạn có muốn xóa sản phẩm không?</th>
                                </tr>

                                <tr>
                                    <td>
                                    	<a href="XoaSanPham?id=<%=id%>">
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
		                
		                </form>
		            </div>
		
		            <div class="pagination-bar">
		                <div class="container">
		                    <div class="pagination">
		                        <a href="#">&laquo;</a>
		                        <%for(int i=1; i<=tongSoTrang; i++){ %>				
		                            <a href="quan-ly-san-pham.jsp?trang=<%=i%>"><%= i %></a>
		                        <%}%>
		                        <a href="#">&raquo;</a>
		                    </div>
		                </div>
		            </div>
		
		            <div class="bt">
		                <a href="them-san-pham.jsp" target="_blank">
		                    <input type="submit" value="Thêm sản phẩm" id="btthem" class="btThem">
		                </a>
		                <!--<input type="submit" value="Sửa sản phẩm" id="btxoa" class="btReset">-->
		            </div>
		        </div>
		    </div>
		    
		    <div class="footer">
				        <div class="container">
				            <div class="btanhien">
				                <input type="button" value="Góp Ý" id="btGopY" onclick="on()">
				            </div>
				            <div class="fMess" id="fMess">
				                <div id="live-chat">
				                    <header class="clearfix">
				                        <div class="chat-close"><strong>X</strong></div>
				
				                        <h4>Góp Ý</h4>
				                     
				                    </header>
				
				                    <div class="chat">
				                        <form action="GopY" method="POST" name="fChat" id="fChat">
				                            <table class="tChat">
				                                <tr class="dong">
				                                    <th>
				                                        To Email:
				                                    </th>
				                                    <td>
				                                        <input type="email" name="txtNguoiNhan" placeholder="Nhập email người nhận" class="txt" id="txt">
				                                    </td>
				                                </tr>
				
				                                <tr class="dong">
				                                    <th>
				                                        From Email:
				                                    </th>
				                                    <td>
				                                        <input type="email" name="txtNguoiGui" placeholder="Nhập email của bạn" class="txt" id="txt1">
				                                    </td>
				                                </tr>
				                                
				                                <tr class="dong">
				                                    <th>
				                                        Tiêu Đề:
				                                    </th>
				                                    <td>
				                                        <input type="text" name="txtTieuDe" placeholder="Nhập email của bạn" class="txt" id="txt3">
				                                    </td>
				                                </tr>
				
				                                <tr class="dong">
				                                    <th>
				                                        Password:
				                                    </th>
				                                    <td>
				                                        <input type="password" name="txtPassword" placeholder="Nhập mật khẩu của bạn" class="txt" id="txt2">
				                                    </td>
				                                </tr>
				
				                                <tr class="dong">
				                                    <th>
				                                        Nội dung:
				                                    </th>
				                                    <td>
				                                        <textarea placeholder="Nhập nội dung" name="txtNoiDung" class="txtarea" rows="20" cols="25"></textarea>
				                                    </td>
				                                </tr>
				
				                                <tr>
				                                    <td colspan="2">
				                                        <div class="btMess">
				                                            <input type="submit" value="Gửi" class="btGui">
				                                            <input type="button" value="Xóa" class="btXoa" onclick="reset()">
				                                        </div>
				                                    </td>
				                                </tr>
				
				                            </table>
				                        </form>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </div>
		
		    <script>
		    (function() {

	            $('#live-chat header').on('click', function() {
	        
	                $('.chat').slideToggle(300);
	        
	            });
	
	            $('.chat-close').on('click', function(e) {
	
	            e.preventDefault();
	            $('#live-chat').fadeOut(300);
	
	            });

        	});

		    $(document).ready(function(){
	            $("#searchCC").click(function(){
	                $(".searchCC").fadeToggle();
	            });
	        });
		    
		    function changeFunc() {
                var selectBox = document.getElementById("hang");
                var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                window.open("timSPTheoHang?brand="+selectedValue);
            }
		     
            function changeFuncPrice() {
                var selectBox = document.getElementById("gia");
                var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                window.open("timSPTheoGia?options="+selectedValue);
            }

		    function reset() {
		        var form = document.getElementById("fChat");

		        form.reset();
		    }

		    function on(){
		    	var modal =  document.getElementById("fMess");

		    	if(modal.style.display == "none")
		    		modal.style.display = "block";
		    	else
		    		modal.style.display = "none";
		    }



    </script>
		</body>
		</html>
	</c:if>
	<c:if test="${sessionScope.staff == null}">
		<jsp:include page="trang-nhan-vien"/>
	</c:if>
</c:if>
    
