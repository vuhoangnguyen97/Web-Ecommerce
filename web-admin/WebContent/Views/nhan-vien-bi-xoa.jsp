<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:forEach items = "${dsnv}" var = "nv">
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close1" onclick="dong()">&times;</span>
            <table id="alert">
                <tr>
                    <th colspan="2">Bạn có muốn xóa sản phẩm không?</th>
                </tr>

                <tr>
                    <td>
                    	<a href="XoaNhanVien?id=${nv.idnhan_vien}">
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
    
    
</c:forEach>