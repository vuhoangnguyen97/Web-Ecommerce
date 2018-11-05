<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="images/favicon.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>ThÃªm Sáº£n Pháº©m</title>
    <script src="ThemSP.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="ThemSP.css" />
</head>
<body>
        <div class="top">
                <div class="container">
                    <div id="logo">
                        <h3>ThÃªm Sáº£n Pháº©m</h3>
                    </div>
        
                    <div id="nameNV"> 
                        <p>Xin chÃ o </p>
                        <!--TÃªn nhÃ¢n viÃªn láº¥y tá»« CSDL-->
                        <p>${sessionScope.staff.ten_nhan_vien}</p>
                        <div class="dangxuat">
                            <a href="#" class="logout">ÄÄng xuáº¥t</a>
                        </div>
        
                    </div>
                </div>
        </div>


        <div class="main">
            <div class="container">
                <div class="mainform">
                    <form action="ThemSPController" method="POST" class="fSanpham" id="fSanpham" enctype="multipart/form-data">
                        <div id="left">
                            <table class="bang1">
                            <tr>
                                <th>MÃ£ sáº£n pháº©m:</th>
                                <td>
                                    <input type="text" name="txtMaSanPham" class="txtsp" id="txtsp" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>TÃªn sáº£n pháº©m:</th>
                                <td>
                                    <input type="text" name="txtTenSanPham" class="txtsp" id="txtsp1" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>HÃ£ng sáº£n xuáº¥t:</th>
                                <td>
                                    <input type="text" name="txtHangSanXuat" class="txtsp" id="txtsp2" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>TÃ¬nh tráº¡ng:</th>
                                <td>
                                    <input type="text" name="txtTinhTrang" class="txtsp" id="txtsp3" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>GiÃ¡:</th>
                                <td>
                                    <input type="text" name="txtGiaSanPham" class="txtsp" id="txtsp10" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>Camera trÆ°á»c:</th>
                                <td>
                                    <input type="text" name="txtCameraTruoc" class="txtsp" id="txtsp4" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>Camera sau:</th>
                                <td>
                                    <input type="text" name="txtCameraSau" class="txtsp" id="txtsp5" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>Dung lÆ°á»£ng pin:</th>
                                <td>
                                    <input type="text" name="txtDungLuongPin" class="txtsp" id="txtsp6" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>TÃ­nh nÄng:</th>
                                <td>
                                    <input type="text" name="txtTinhNang" class="txtsp" id="txtsp9" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>MÃ u sáº¯c:</th>
                                <td>
                                    <input type="text" name="txtMauSac" class="txtsp" id="txtsp7" value="">
                                </td>
                            </tr>

                            <tr>
                                <th>Báº£o máº­t:</th>
                                <td>
                                    <input type="text" name="txtBaoMat" class="txtsp" id="txtsp8" value="">
                                </td>
                                
                            </tr>

                        </table>

                            <div class="btsub">
                                <input type="button" value="ThÃªm" id="btthem">
                                <input type="button" value="Reset" id="btreset" onclick="reset()">
                            </div>
                        </div>
                        
                        <div id="right">
                            <img id="hinhsp" class="hinhanh" name="txtHinhSanPham">
                            <input type="file" value="Resize Image" id="upImage" onclick="ResizeImage()">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="footer">
            <div class="container"></div>
        </div>
    <script>
        $("input").change(function(e) {

        for (var i = 0; i < e.originalEvent.srcElement.files.length; i++) {
        
        var file = e.originalEvent.srcElement.files[i];
        
        var img = document.getElementById("hinhsp");
        var reader = new FileReader();
        reader.onloadend = function() {
             img.src = reader.result;
        }
        reader.readAsDataURL(file);
        $("hinhsp   ").after(img);  
    }
});

    </script>
</body>
</html>