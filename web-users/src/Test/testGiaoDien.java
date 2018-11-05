package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

@Test
public class testGiaoDien {
	
	@Test
	public void moTrangChu() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://localhost:8081/web-mobile/trang-chu");
			//driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
	}
	
	@Test
	public void moTrangDangNhap() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		try {
			ChromeOptions options =	 new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://localhost:8081/web-mobile/dang-nhap");
			//driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
	}
	
	@Test
	public void moTrangDangKy() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		try {
			ChromeOptions options =	 new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://localhost:8081/web-mobile/dang-ky");
			//driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
	}
	
	@Test
	public void testNutSearch() {
		System.setProperty("webdriver.chrome.driver", "F:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		try {
			ChromeOptions options =	 new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://localhost:8081/web-mobile/trang-chu");
			driver.findElement(By.className("search-submit")).click();
			//driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
	}
	
	@Test
	public void testNutGioHang() {
		System.setProperty("webdriver.chrome.driver", "F:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		try {
			ChromeOptions options =	 new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://localhost:8081/web-mobile/trang-chu");
			driver.findElement(By.className("cart-icon")).click();
			//driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	@Test
	public void userLoginSuccess() {
		System.setProperty("webdriver.chrome.driver", "F:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		try {
			ChromeOptions options =	 new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://localhost:8081/web-mobile/dang-nhap");
			String username = "test";
			String password = "test";
			driver.findElement(By.name("txtUsername")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.className("enviar")).click();
			//driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
	}
	
	@Test
	public void userLoginFail() {
		System.setProperty("webdriver.chrome.driver", "F:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		try {
			ChromeOptions options =	 new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://localhost:8081/web-mobile/dang-nhap");
			String username = "test123";
			String password = "test456";
			driver.findElement(By.name("txtUsername")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.className("enviar")).click();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
	}
	
	@Test
	public void userDangKiSuccess() {
		System.setProperty("webdriver.chrome.driver", "F:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		try {
			ChromeOptions options =	 new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("http://localhost:8081/web-mobile/dang-ky");
			String username = "test123";
			String password = "test456";
			String password_repeat = "test456";
			String ho = "nguyễn";
			String ten = "tèo";
			String sdt = "0122445566";
			String email = "abc@def.com";
			String diachi = "123 ngo quyen";
			String quan = "phu nhuan";
			String phuong = "5";
			String thanh_pho = "hcm";
			String quoc_qua = "vn";
			String zipcode = "88888";
			driver.findElement(By.name("txtUsername")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.name("txtPasswordRepeat")).sendKeys(password_repeat);
			driver.findElement(By.name("txtHo")).sendKeys(ho);
			driver.findElement(By.name("txtTen")).sendKeys(ten);
			driver.findElement(By.name("txtSDT")).sendKeys(sdt);
			driver.findElement(By.name("txtEmail")).sendKeys(email);
			driver.findElement(By.name("txtDiaChi")).sendKeys(diachi);
			driver.findElement(By.name("txtQuan")).sendKeys(quan);
			driver.findElement(By.name("txtPhuong")).sendKeys(phuong);
			driver.findElement(By.name("txtThanhPho")).sendKeys(thanh_pho);
			driver.findElement(By.name("txtQuocGia")).sendKeys(quoc_qua);
			driver.findElement(By.name("txtZipCode")).sendKeys(zipcode);
			
			driver.findElement(By.className("enviar")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}	
	}
}
