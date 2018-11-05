<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="clearfix">
        </div>
        <div class="page-index">
          
        </div>
      </div>
      <div class="clearfix">
      </div>
      <div class="container_fullwidth">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h5 class="title contact-title">
                Thông Tin Chúng Tôi
              </h5>
              <div class="clearfix">
              </div>
              <div class="map">
                <iframe width="600" height="350" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.6450921584938!2d106.6484466146373!3d10.838448761009953!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175299f0185a83d%3A0xfa5207911d01c449!2zMTIzIFF1YW5nIFRydW5nLCBwaMaw4budbmcgOCwgR8OyIFbhuqVwLCBI4buTIENow60gTWluaCwgVmlldG5hbQ!5e0!3m2!1sen!2sus!4v1507473441888">
                </iframe>
              </div>
              <div class="clearfix">
              </div>
              <div class="row">
                <div class="col-md-4">
                  <div class="contact-infoormation">
                    <h5>
                      Thông Tin Liên Lạc
                    </h5>
                    <p>
                     ĐienThoaiOline.com Hệ Thống bàn hàng trực tuyến hàng đầu VN hay đến với chúng tôi để sở hữu những sản phẩm chất lượng với giá hấp dẫn.
                     Nếu có thắc mắc hoặc có vấn đề về lỗi sản phẩm xin vui lòng liên hệ số điện thoại và gmail bên dưới hoặc gửi tin nhắn cho chúng tôi.
                    </p>
                    <ul>
                      <li>
                        <span class="icon">
                          <img src="images/message.png" alt="">
                        </span>
                        <p>
                          dienthoaigiare@gmail.com
                          <br>
                          dienthoaionline@gmail.com
                        </p>
                      </li>
                      <li>
                        <span class="icon">
                          <img src="images/phone.png" alt="">
                        </span>
                        <p>
                          029. 00 113 911
                          <br>
                          0909 113 911
                        </p>
                      </li>
                      <li>
                        <span class="icon">
                          <img src="images/address.png" alt="">
                        </span>
                        <p>
                          Số 123, Quang Trung, Gò Vấp
                          <br>
                          HoChiMinh, Vietnam
                        </p>
                      </li>
                    </ul>
                  </div>
                </div>
                <div class="col-md-8">
                  <div class="ContactForm">
                    <h5>
                      Liên Hệ
                    </h5>
                    <form name="formGopY" action="GopYServlet" method="POST" onsubmit="return xacThucGopY()">
                      <div class="row">
                        <div class="col-md-6">
                          <label>
                            Họ và Tên
                            <strong class="red">
                              *
                            </strong>
                          </label>
                          <input class="inputfild" type="text" name="name">
                        </div>
                        <div class="col-md-6">
                          <label>
                            Email
                            <strong class="red">
                              *
                            </strong>
                          </label>
                          <input class="inputfild" type="email" name="email">
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-12">
                          <label>
                            Lời nhắn
                            <strong class="red">
                              *
                            </strong>
                          </label>
                          <textarea class="inputfild" rows="8" name="message">
                          </textarea>
                        </div>
                      </div>
                      <button class="pull-right">
                        Gửi
                      </button>
                      
                    </form>
                    <script type="text/javascript">
	                      function xacThucGopY() {
	                      		var name_input = document.forms["formGopY"]["name"].value;
							    var email_input = document.forms["formGopY"]["email"].value;
							    var message_input = document.forms["formGopY"]["message"].value;
							   	if (email_input == "" || name_input == "" || message_input == "") {
							        alert("Không được để trống");
							        return false;
							    }
							    if (check_email<1 || check_email_dot<(check_email+2) || (check_email_dot+2) >= email_input.length) {
							        alert("Email bạn không hợp lệ");
							        return false;
							    }
							    
							}
                      </script>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="clearfix">
          </div>
