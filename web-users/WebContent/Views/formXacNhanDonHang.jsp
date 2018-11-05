<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container_fullwidth">
        <div class="container">
          <div class="row">
            <jsp:include page="/Views/menu-ben-trai.jsp"></jsp:include>
            <div class="col-md-9">
              <div class="checkout-page">
               
                  <div class="checkout-page">
                <ol class="checkout-steps">
                  <li class="steps">
                    <div class="step-title">
                      <a href="xemGioHangServlet">
                      Thông tin đơn hàng
                    </a>
                    </div>
                  </li>
                  <li class="steps active">
                    <a class="step-title">
                      Địa chỉ giao hàng của quý khách
                    </a>
                    <div class="step-description">
                      <form action="phuongThucThanhToan" method="post" accept-charset="UTF-8">
                        <div class="row">
                          <div class="col-md-6 col-sm-6">
                            <div class="your-details">
                              
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Email
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" value="${sessionScope.member.email}" name="txtEmail">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Họ
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" value="${sessionScope.member.ho_user}" name="txtHo">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Tên
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" value="${sessionScope.member.ten_user}" name="txtTen">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  SDT
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" value="${sessionScope.member.sdt}" name="txtSDT">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Chọn loại thẻ:
                                  <strong class="red">
                                    *
                                  </strong>
                                  
                                </label>
                                <select name="optionPayment" id="optionPayment" class="form" id="sel1"  style="
								    padding-left: 167px;
								" onchange="changeFunc(value);">
                                  <option value="1">Thẻ Paypal</option>
                                  <option value="2" onclick="alert('Cổng thanh toán này sẽ xuất hiện sau') return false;">Thẻ Onepay</option>
                                  <option value="3">Ship COD</option>
                              </select>
                              </div>
                              	<script type="text/javascript">
								   function changeFunc($i) {
								     if($i == 2){
									     alert('Cổng thanh toán OnePay vẫn đang trong quá trình phát triển.\n Vui lòng thử lại sau.');
									     $('#optionPayment').val('1').change();
									     
								     }
								   }
  								</script>
                              
                            </div>
                          </div>
                          <div class="col-md-6 col-sm-6">
                            <div class="your-details">
                              
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Địa chỉ:
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" class="input namefild" value="${sessionScope.member.dia_chi}" name="txtDiaChi">
                              </div>
                              
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Tỉnh/Thành phố
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" style="
								    padding-left: 180px;
								" class="input namefild" value="${sessionScope.member.thanh_pho}" name="txtThanhPho">
                              </div>
                              <div class="form-row">
                                <label class="lebel-abs">
                                  Quận/Huyện
                                  <strong class="red">
                                    *
                                  </strong>
                                </label>
                                <input type="text" style="
								    padding-left: 160px;
								" class="input namefild" value="${sessionScope.member.quan}" name="txtQuan">
                              </div>
                              <div class="pass-wrap">
                                <div class="form-row">
                                  <label class="lebel-abs">
                                 Phường/xã
                                    <strong class="red">
                                      *
                                    </strong>
                                  </label>
                                  <input type="text" class="input namefild" value="${sessionScope.member.phuong}" name="txtPhuong" style="
									    padding-left: 160px;
									">

                                </div>
                              </div>
                              <button formaction="phuongThucThanhToan">Xác nhận</button>
					
                              </div> 
                            </div>
                          </div>
                        </form></div>
                      
                    </li></ol></div>
                  
                  
                
              </div>
    
              </div>
              </div>
            </div>
            </div>
          <div class="clearfix">
          </div>
          
        </div>