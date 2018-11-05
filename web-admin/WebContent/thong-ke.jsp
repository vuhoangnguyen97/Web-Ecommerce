<%@page import="serverConnections.serverCount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.*" %>
<%@ page import="DAO.*" %>
<%@ page import="org.jfree.chart.plot.*" %>
<%@ page  import="org.jfree.chart.*" %>
<%@ page import="org.jfree.chart.axis.*" %>
<%@ page  import="org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>
<%@ page import="org.jfree.chart.plot.PlotOrientation" %>
<%@ page  import="org.jfree.data.category.DefaultCategoryDataset" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.member != null}">
	<h1> Bạn không có quyền truy cập trang này!</h1>
</c:if>
<c:if test="${sessionScope.member == null}">
	<c:if test="${sessionScope.staff == null}">
		<jsp:include page="trang-nhan-vien.jsp"/>
	</c:if>
	<c:if test="${sessionScope.staff != null}">
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>	
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<title>Thống kê</title>
				<link rel="icon" href="images/bieudo.ico" type="image/ico" sizes="16x16">
			</head>
			<body>
			<%
				int count = serverCount.count();
				if(count>=151){
					out.print("<script>alert('Server đang quá tải')</script>");
				}
			%>
			<h2>Số lượt kết nối server hiện tại là: <%=serverCount.count()%> </h2>
			
			<%
				Font font3 = new Font("Dialog", Font.PLAIN, 15); 
				List<SanPham> dsSanPham = SanPhamDAO.dsSanPhamMuaNhieuNhat();
				List<DonHang> dsTopUser = DonHangDAO.dsTopNguoiDungMuaNhieu();
				List<SanPham> dsSanPhamBanCham = SanPhamDAO.dsSanPhamMuaItNhat();
		
				DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
			    //line_chart_dataset.addValue( 15 , "Số lượt mua" , "1970" );
			    for(SanPham sp : dsSanPham){
				   line_chart_dataset.addValue( sp.getSoLuotMua() , "Số lượt mua" , sp.getTenSanPham());
			    }
			    
			    JFreeChart lineChartObject = ChartFactory.createLineChart(
			            "Biểu đồ top 10 sản phẩm mua nhiều nhất","Sản phẩm",
			            "Số lượt mua",
			            line_chart_dataset,PlotOrientation.VERTICAL,
			            true,true,false);
			    
			    CategoryPlot plot = lineChartObject.getCategoryPlot();
			    ValueAxis axis = plot.getRangeAxis();
			    
			    CategoryAxis categoryAxis = plot.getDomainAxis();
		
			    
			    axis.setTickLabelFont(font3);
			    categoryAxis.setTickLabelFont(font3);
				
				//JFreeChart chart = ChartFactory.createPieChart("Biểu đồ thống kê", data, true, false, false );
				//ChartUtilities.saveChartAsPNG(new File(getServletContext().getRealPath(".") + "/piechart.png"), chart, 500,300);
			 	File lineChart = new File(getServletContext().getRealPath(".") + "/linechart.png"); 
		      	ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, 1400 ,600);
		      	
		      	//---------------------------------------------------------------
		      	
		      	DefaultCategoryDataset line_chart_dataset_user = new DefaultCategoryDataset();
			    //line_chart_dataset.addValue( 15 , "Số lượt mua" , "1970" );
			    for(DonHang dh : dsTopUser){
			    	line_chart_dataset_user.addValue(dh.getDiem() , "Điểm tích lũy" , dh.getTen_user());
			    }
			    
			    JFreeChart lineChartObjectUser = ChartFactory.createLineChart(
			            "Biểu đồ top 10 khách hàng có điểm cao nhất","Tên khách hàng",
			            "Điểm tích lũy",
			            line_chart_dataset_user,PlotOrientation.VERTICAL,
			            true,true,false);
			    
			    CategoryPlot plotUser = lineChartObject.getCategoryPlot();
			    ValueAxis axisUser = plotUser.getRangeAxis();
			    
			    CategoryAxis categoryAxisUser = plotUser.getDomainAxis();
		
			    
			    axisUser.setTickLabelFont(font3);
			    categoryAxisUser.setTickLabelFont(font3);
				
				//JFreeChart chart = ChartFactory.createPieChart("Biểu đồ thống kê", data, true, false, false );
				//ChartUtilities.saveChartAsPNG(new File(getServletContext().getRealPath(".") + "/piechart.png"), chart, 500,300);
			 	File lineChartUserFile = new File(getServletContext().getRealPath(".") + "/linechartuser.png"); 
		      	ChartUtilities.saveChartAsJPEG(lineChartUserFile ,lineChartObjectUser, 600 ,600);
		      	
		      	//--------------------------------------------------
		      	
			%>
			
			
		
			<img style="padding-left: 15px;" src="linechart.png" width="1400" height="600">
			<img style="padding-left: 15px; padding-top: 45px;" src="linechartuser.png" width="600" height="600">
			
			<script>
			    setTimeout(function () {
			       window.location.reload();
			    }, 1000);
			</script>
			</body>
		</html>
	</c:if>
</c:if>