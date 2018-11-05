<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<li class="option-cart">
  <a href="#" class="cart-icon">cart <span class="cart_no">02</span></a>
  <ul class="option-cart-item">
  <c:forEach items="${spm}" var="spham_mua">
     <li>
        <div class="cart-item">
           <div class="image"><img src="images/products/thum/products-01.png" alt=""></div>
           <div class="item-description">
              <p class="name">IPhone 7Plus</p>
              <p>Số Lượng: <span class="light-red">01</span></p>
           </div>
           <div class="right">
              
              <a href="#" class="remove"><img src="images/remove.png" alt="remove"></a>
           </div>
        </div>
     </li>
  </c:forEach>
     
     <li><button class="checkout" onclick="location.href='checkout.html'">Thanh Toán</button></li>
  </ul>
</li>