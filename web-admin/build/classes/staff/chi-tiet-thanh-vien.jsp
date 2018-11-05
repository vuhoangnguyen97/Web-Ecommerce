<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Chi Tiết Thành Viên</title>
    <link rel="stylesheet" type="text/css" media="screen" href="Views/staff/CTTV.css" />
    <script type="text/javascript" src="Views/staff/CTTV.js"></script>
</head>
<body>

        <div class="top">
                <div class="container">
                    <div id="logo">
                        <h3>Chi Tiết Thành Viên</h3>
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


        <div class="main">
                <div class="container">
                    <div class="thongtin">
                        <div class="tensp">
                            <p> Thành Viên ${chitiet.ten_user}</p>
                        </div>
                        <table class="table">
                            <tr>
                                <th>Mã khách hàng:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp" value="${chitiet.iduser}" disabled>
                                </td>
                            </tr>
        
                            <tr>
                                <th>Username:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp1" value="${chitiet.username}" disabled>
                                </td>
                            </tr>
        
                            <tr>
                                <th>Password:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp2" value="${chitiet.password}" disabled>
                                </td>
                            </tr>
        
                            <tr>
                                <th>Tên khách hàng:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp3" value="${chitiet.ten_user}" disabled>
                                </td>
                            </tr>
        
                            <tr>
                                <th>Số điện thoại:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp4" value="${chitiet.sdt}" disabled>
                                </td>
                            </tr>
        
                            <tr>
                                <th>Email:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp5" value="${chitiet.email}" disabled>
                                </td>
                            </tr>
        
                            <tr>
                                <th>Địa chỉ:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp7" value="${chitiet.dia_chi}" disabled>
                                </td>
                            </tr>
        
                            <tr>
                                <th>Phường:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp8" value="${chitiet.phuong}" disabled>
                                </td>
                            </tr>

                            <tr>
                                <th>Quận:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp9" value="${chitiet.quan}" disabled>
                                </td>
                            </tr>

                            <tr>
                                <th>Thành phố:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp10" value="${chitiet.thanh_pho}" disabled>
                                </td>
                            </tr>

                            <tr>
                                <th>Quốc Gia:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp11" value="${chitiet.nuoc}" disabled>
                                </td>
                            </tr>

                            <tr>
                                <th>Zipcode:</th>
                                <td>
                                    <input type="text" class="txtsp" id="txtsp12" value="${chitiet.zip_code}" disabled>
                                </td>
                            </tr>
                            
                            <tr>
                                <th>Điểm:</th>
                                <td>
                                    <input type="text" class="txtsp" value="${chitiet.diem}" disabled>
                                </td>
                            </tr>
                            
                            <tr>
                                <th>Loại thẻ:</th>
                                <td>
                                    <input type="text" class="txtsp" value="${chitiet.loai_the}" disabled>
                                </td>
                            </tr>
        
                            <tr>
                                <td colspan="2">
                                    <form action="#" method="POST" id="fix">
                                        <input type="button" value="Edit" id="btfix" onclick="show()">
                                <input type="button" value="Save" id="btsave" onclick="show1()">
                                    </form>
                                </td>
                            </tr>
                        </table>
                        
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
                
                
                <div id="myModal1" class="modal">
                <div class="modal-content">
                    <form action="#" method="POST" id="ask2">
                        <span class="close1" onclick="dong()">&times;</span>
                        <table id="alert1">
                                <tr>
                                        <th colspan="2">Bạn có muốn lưu không?</th>
                                    </tr>
    
                                    <tr>
                                        <td>
                                            <input type="button" value="Có" id="yes" class="btask" onclick="bt1(); luu(); luu2(); dong1();">
                                        </td>
    
                                        <td>
                                            <input type="button" value="Không" id="no" class="btask" onclick="dong1()">
                                        </td>
                                    </tr>
                        </table>
                    </form>
                </div>
            </div>
                        
                    </div>
                </div>
        </div>

    
</body>
</html>