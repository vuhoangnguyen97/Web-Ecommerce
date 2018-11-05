package JavaBeans;

public class sanPhamMua extends sanPham {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int soLuongMua;

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	
	public int getThanhTien() {
		return soLuongMua*getGiaSanPham();
	}

	public sanPhamMua() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
