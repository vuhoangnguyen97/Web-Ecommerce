<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form name="paypalForm" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
 <input type="hidden" name="cmd" value="_xclick" />
 <input type="hidden" name="business" value="1551010084nguyen-facilitator@ou.edu.vn" />
 <input type="hidden" name="password" value="Vuhoangnguyen1997" />
 
 <input type="hidden" name="item_name" value="Bill:" />
 <input type="hidden" name="amount" value="${usd}"/>
 <input type="hidden" name="rm" value="1" />
 <input type="hidden" name="return" value="http://localhost:8081/web-mobile/PayPalController" />
 <input type="hidden" name="cancel_return" value="http://localhost:8080/PaypalGS/paypalResponseCancel.jsp" />
 <input type="hidden" name="cert_id" value="AUto2kIFoFUBohXTAbmnQICEOAPxW3MZGCilm3LV9A6Yd9JUN-Gd2m_p0kWZTVlsKiE0b3N4N0wAt7Uw" />
 <input type="image" name="submit" border="0"
  src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
  alt="Buy Now">
  <img alt="" border="0" width="1" height="1"
  src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >
</form>