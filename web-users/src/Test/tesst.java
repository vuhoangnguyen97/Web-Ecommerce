package Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import BusinessLogics.gioHangBL;
import BusinessLogics.sanPhamBL;
import BusinessLogics.theTichDiemDAO;
import BusinessLogics.userBL;
import Controller.phuongThucThanhToan;
import Encrypt.encrypt;
import JavaBeans.sanPham;
import JavaBeans.sanPhamMua;
import JavaBeans.theKhachHang;
import JavaBeans.user;
import Payment.Utils;
import Payment.onePayPayment;

public abstract class tesst {

	public static void main(String[] args) {		
		gioHangBL gioHang = new gioHangBL();
		gioHang.them(5, 1);
		double tongTien = gioHang.tongTien();
		String url = phuongThucThanhToan.urlOnePay(tongTien);
		
		System.out.println(url);
	}

}
