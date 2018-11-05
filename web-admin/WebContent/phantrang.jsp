<%@page import="Database.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DTO.*" %>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
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
		<table border="1" style="margin:auto;width:600px;">
			<caption>THÔNG TIN SỮA</caption>
			  <tr>
			    <th>STT</th>
			    <th>Tên sữa</th>
			    <th>Tên hãng</th>
			    <th>Tên loại</th>
			    <th>Trọng lượng</th>
			    <th>Đơn giá</th>
			  </tr>
			  
			  <%while(rs.next()){ %>
				  <tr>
				    <td><%=stt++%></td>
				    <td><%=rs.getString("ma_san_pham") %></td>
				    <td><%=rs.getString("ten_san_pham") %></td>
				    <td><%=rs.getString("hang_san_xuat") %></td>
				    <td><%=rs.getInt("gia_san_pham") %></td>
				    <td><%=rs.getString("tinh_trang") %></td>
				  </tr>
			  <%}%>
			  
		</table>
		<p style="text-align: center;">
			<%for(int i=1; i<=tongSoTrang; i++){ %>				
				<a href="phantrang.jsp?trang=<%=i%>"><%= i %></a>
			<%}%>
		</p>
		
	</body>
</html>