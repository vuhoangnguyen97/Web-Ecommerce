<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản Lý Sản Phẩm</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="QLHH.css" />
    <script src="QLHH.js"></script>
    <%! int soDongTrang = 5, tongSoTrang, trang = 1, viTriDau; %>
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
                <p>Admin</p>
                <div class="dangxuat">
                    <a href="#" class="logout">Đăng xuất</a>
                </div>

            </div>
        </div>
    </div>

    <div class="trangkhac">
        <div class="container">
            
        <div class="dieuhuong">
            <a href="quan-ly-thanh-vien.jsp" target="blank">
                <input type="button" class="QLTV" value="Quản Lý Thành Viên">
            </a>
        </div>

        <div class="dieuhuong">
            <a href="quan-ly-don-hang.jsp" target="blank">
                <input type="button" class="QLDH" value="Quản Lý Đơn Hàng">
            </a>
        </div>

        </div>




    </div>
    
    <div class="main">
        <div class="container">
            <div class="table">
                <p class="title">DANH SÁCH SẢN PHẨM</p>
                <table id="sp">
                    <thead>
                        <tr>
                            <th>Mã sản phẩm</th>
                            <th>Tên sản phẩm</th>
                            <th>Hãng sản xuất</th>
                            <th>Giả sản phẩm</th>
                            <th>Tình trạng</th>
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
                        <jsp:include page="DocSanPham"/>
                    </tbody>
                </table>
            </div>
            <%            	
            	Integer tongSoDong = (Integer) session.getAttribute("size") ; 
            	int sum = (int) tongSoDong;
           	%>
			<% 
				tongSoTrang = sum/soDongTrang + (sum%soDongTrang != 0 ? 1 : 0); 
				if(request.getParameter("trang") != null)
					trang = Integer.parseInt(request.getParameter("trang"));
				viTriDau = (trang-1)*5;  // TRANG 1 (1-1)*5
				int stt = viTriDau+1;
				//rs = stm.executeQuery(query + " limit " + viTriDau + "," + soDongTrang) ;
            %>
            
            <div class="pagination-bar">
                <div class="container">
                    <div class="pagination">
                        <a href="#">&laquo;</a>
                        <%for(int i=1; i<=sum; i++){ %>				
							<a href="index.jsp?trang=<%=i%>"><%= i %></a>
						<%}%>
                        <a href="#">&raquo;</a>
                    </div>
                </div>
            </div>
            
            <div class="bt">
                <input type="submit" value="Thêm sản phẩm" id="btthem" class="btThem">
                <input type="submit" value="Sửa sản phẩm" id="btxoa" class="btReset">
            </div>
        </div>
    </div>

    
    

    <div class="formnhap"></div>
        <div class="container">
            <div id="myModal" class="modal">
                <!--Nội dung form-->
                <div class="modal-content">
                <form action="#" method="POST" id="nhapsp">
                <span class="close">&times;</span>
                <p>Nhập sản phẩm</p>
                <table id="themsp">

                    <tr>
                        <th>Mã sản phẩm:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <th>Tên sản phẩm:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <th>Hãng sản xuất:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <th>Tình trạng:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <th>Camera trước:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <th>Camera sau:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <th>Dung lượng pin:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <th>Màu sắc:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <th>Bảo mật:</th>
                        <td>
                            <input type="text" class="txtsp">
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <div class="bt" id="btf1">
                                <input type="submit" value="Gửi" id="btguif1" class="btReset">
                                <input type="submit" value="Nhập lại" id="btresetf1" class="btReset">
                            </div>
                        </td>
                    </tr>

                </table> 
                
                </form>
                </div>
            </div>

            <div id="myModal1" class="modal">
                    <!--Nội dung form-->
                    <div class="modal-content">
                    <form action="#" method="POST" id="nhapsp1">
                    <span class="close1">&times;</span>
                    <p>Nhập nội dung cần sửa</p>
                    <table id="suasp">

            <tr>
                <th>Mã sản phẩm:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <th>Tên sản phẩm:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <th>Hãng sản xuất:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <th>Tình trạng:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <th>Camera trước:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <th>Camera sau:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <th>Dung lượng pin:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <th>Màu sắc:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <th>Bảo mật:</th>
                <td>
                    <input type="text" class="txtsp">
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <div class="bt" id="btf2">
                        <input type="submit" value="Gửi" id="btguif2" class="btReset">
                        <input type="submit" value="Nhập lại" id="btresetf2" class="btReset">
                    </div>
                </td>
            </tr>

        </table>>  
                    </form>
                    </div>
            </div>
        </div>
    </div>

    <script>
    var modal = document.getElementById('myModal');
    var modal1 = document.getElementById('myModal1');
    var bt = document.getElementById("btthem");
    var btxoa = document.getElementById("btxoa");
    var span = document.getElementsByClassName("close")[0];
    var span1 = document.getElementsByClassName("close1")[0];


    bt.onclick = function(){
        modal.style.display = "block";
    }

    span.onclick = function(){
        modal.style.display = "none";
    }

    window.onclick = function(){
        if(event.target == modal){
            modal.style.display = "none";
        }
        else if(event.target == modal1){
            modal1.style.display = "none";
        }
    }

    btxoa.onclick = function(){
        modal1.style.display = "block";
    }

    span1.onclick = function(){
        modal1.style.display = "none";
    }




    
</script>

</body>
</html>