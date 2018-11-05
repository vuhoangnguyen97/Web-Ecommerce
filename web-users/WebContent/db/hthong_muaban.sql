-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2017 at 07:23 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hthong_muaban`
--

-- --------------------------------------------------------

--
-- Table structure for table `gio_hang`
--

CREATE TABLE IF NOT EXISTS `gio_hang` (
  `idgio_hang` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `ho_user` varchar(45) NOT NULL,
  `ten_user` varchar(45) NOT NULL,
  `sdt` int(11) NOT NULL,
  `diaChi` varchar(45) NOT NULL,
  `quan` varchar(45) NOT NULL,
  `phuong` varchar(45) NOT NULL,
  `chi_tiet` text NOT NULL,
  PRIMARY KEY (`idgio_hang`,`iduser`),
  KEY `user_giohang_idx` (`iduser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `gio_hang`
--

INSERT INTO `gio_hang` (`idgio_hang`, `iduser`, `email`, `ho_user`, `ten_user`, `sdt`, `diaChi`, `quan`, `phuong`, `chi_tiet`) VALUES
(12, 6, 'darkevil9712@gmail.com', 'vu', 'vu', 1234567890, '123 nguyen trai', '5', '3', 'iPhone 7 plus 32Gb - Số lượng 1 - Thành tiền 22,490,000<br/>'),
(13, 6, 'darkevil9712@gmail.com', 'vu', 'vu', 1234567890, '123 nguyen trai', '5', '3', 'Nokia 216 - Số lượng 1 - Thành tiền 760,000<br/>iPhone 7 plus 32Gb - Số lượng 1 - Thành tiền 22,490,000<br/>');

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

CREATE TABLE IF NOT EXISTS `nhan_vien` (
  `idnhan_vien` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ho_nhan_vien` varchar(45) NOT NULL,
  `ten_nhan_vien` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sdt` int(15) NOT NULL,
  PRIMARY KEY (`idnhan_vien`,`username`,`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `nhan_vien`
--

INSERT INTO `nhan_vien` (`idnhan_vien`, `username`, `password`, `ho_nhan_vien`, `ten_nhan_vien`, `email`, `sdt`) VALUES
(1, 'admin', 'admin', 'Vũ ', 'Nguyên', 'darkevil9712@gmail.com', 123456789);

-- --------------------------------------------------------

--
-- Table structure for table `phu_kien`
--

CREATE TABLE IF NOT EXISTS `phu_kien` (
  `idphu_kien` int(11) NOT NULL AUTO_INCREMENT,
  `ten_phu_kien` varchar(45) NOT NULL,
  `loai_phu_kien` varchar(45) NOT NULL,
  `hinh_phu_kien` varchar(45) NOT NULL,
  `hang_phu_kien` varchar(45) NOT NULL,
  `gia_phu_kien` int(11) NOT NULL,
  PRIMARY KEY (`idphu_kien`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `phu_kien`
--

INSERT INTO `phu_kien` (`idphu_kien`, `ten_phu_kien`, `loai_phu_kien`, `hinh_phu_kien`, `hang_phu_kien`, `gia_phu_kien`) VALUES
(1, 'Ốp lưng Galaxy J7 Prime Nhựa hình thú', 'ốp lưng', 'galaxyj7.jpg', 'Osmia', 30000),
(2, 'Ốp lưng iPhone 7 Nhựa dẻo hình thú', 'ốp lưng', 'iphone7.jpg', 'Cosano', 30000),
(3, 'Ốp lưng iPhone 6 - 6s Nhựa Silicon Hươu vàng', 'ốp lưng', 'iphone6.jpg', 'đang cập nhật', 30000),
(4, 'Ốp lưng Galaxy Note 8 Nhựa dẻo', 'ốp lưng', 'note8.jpg', 'Osmia', 190000),
(5, 'Ốp lưng Galaxy S8 Nhựa dẻo', 'ốp lưng', 's8.jpg', 'Solid', 70000),
(6, 'Pin sạc dự phòng 5.000 mAh', 'sạc dự phòng', 'sac1.jpg', 'eValu', 120000),
(7, 'Pin sạc dự phòng 7.500 mAh', 'sạc dự phòng', 'sac2.jpg', 'eSaver', 250000),
(8, 'Pin sạc dự phòng Polymer 5.000 mAh', 'sạc dự phòng', 'sac3.jpg', 'eValu', 350000),
(9, 'Pin sạc dự phòng 10.000 mAh', 'sạc dự phòng', 'sac4.jpg', 'eValu', 300000),
(10, 'Pin sạc dự phòng Polymer 5.000 mAh', 'sạc dự phòng', 'sac5.jpg', 'eSaver', 250000),
(11, 'Tai nghe Apple Airpods', 'tai nghe', 'apple.jpg', 'Apple', 5000000),
(12, 'Tai nghe Sony XBA-Z5', 'tai nghe', 'sony.jpg', 'Sony', 11200000),
(13, 'Tai nghe Sony MDR-EX750BT', 'tai nghe', 'sony2.jpg', 'Sony', 2500000),
(14, 'Tai nghe Beats Studio 3.0 Wireless', 'tai nghe', 'beats.jpg', 'Beats', 7500000),
(15, 'Tai nghe Beats Tour 2017', 'tai nghe', 'beats1.jpg', 'Beats', 2000000);

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE IF NOT EXISTS `san_pham` (
  `ma_san_pham` int(10) NOT NULL AUTO_INCREMENT,
  `ten_san_pham` varchar(100) NOT NULL,
  `hang_san_xuat` varchar(45) NOT NULL,
  `gia_san_pham` int(50) NOT NULL,
  `tinh_trang` varchar(20) NOT NULL,
  `hinh_anh_mo_phong` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `camera_truoc` text NOT NULL,
  `camera_sau` text NOT NULL,
  `dung_luong_pin` text NOT NULL,
  `tinh_nang` text NOT NULL,
  `bao_mat` text NOT NULL,
  `mau_sac` text NOT NULL,
  PRIMARY KEY (`ma_san_pham`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=48 ;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`ma_san_pham`, `ten_san_pham`, `hang_san_xuat`, `gia_san_pham`, `tinh_trang`, `hinh_anh_mo_phong`, `camera_truoc`, `camera_sau`, `dung_luong_pin`, `tinh_nang`, `bao_mat`, `mau_sac`) VALUES
(1, 'iPhone 7 plus 32Gb', 'Apple', 22490000, 'còn hàng', 'ip7plus.jpg', '7 MP', '12 MP Camera kép', '2900 mAh', 'Bảo mật nâng cao :	Mở khóa bằng vân tay <br/>\nTính năng đặc biệt	Chống nước, chống bụi <br/>\n3D Touch <br/>\nGhi âm	Có, microphone chuyên dụng chống ồn <br/>\nRadio	Không <br/>\nXem phim	H.265, 3GP, MP4, AVI, WMV, H.264(MPEG4-AVC), DivX, WMV9, Xvid <br/>\nNghe nhạc	Lossless, Midi, MP3, WAV, WMA, AAC, eAAC+ <br/>', 'vân tay', 'Đen, Đỏ, Vàng đồng'),
(2, 'iPhone 6', 'Apple', 7690000, 'còn hàng', 'ip6.jpg', '', '', '', '', '', ''),
(3, 'Nokia 216', 'Nokia', 760000, 'còn hàng', 'nokia216.jpg', '', '', '', '', '', ''),
(4, 'Nokia 150 ', 'Nokia', 650000, 'hết hàng', 'nokia150.jpg', '', '', '', '', '', ''),
(5, 'Nokia 105', 'Nokia', 350000, 'còn hàng', 'nokia105.jpg', '', '', '', '', '', ''),
(6, 'Nokia 3', 'Nokia', 3000000, 'còn hàng', 'nokia3.jpg', '', '', '', '', '', ''),
(7, 'Asus Zenphone Go', 'Asus', 2990000, 'hết hàng', 'asusgo.jpg', '', '', '', '', '', ''),
(8, 'Samsung Galaxy J2', 'Samsung', 2490000, 'hết hàng', 'galaxyj2.jpg', '', '', '', '', '', ''),
(9, 'Asus Zenphone 2 Go', 'Asus', 1990000, 'còn hàng', 'asus2.jpg', '', '', '', '', '', ''),
(10, 'Nokia 230', 'Nokia', 1250000, 'hết hàng', 'nokia230.jpg', '', '', '', '', '', ''),
(12, ' Samsung Galaxy Note 8', 'Samsung', 22490000, 'còn hàng', 'sgn8.jpg', '8MP', '2 camera 12MP', '3300mAh', 'Chống nước, chống bụi', 'Mở khóa bằng khuôn mặt, Quét mồng mắt, Mở khóa bằng vân tay', 'Đen'),
(13, 'Samsung Galaxy S8', 'Samsung', 18490000, 'còn hàng', 'sgs8.jpg', '8MP', '12MP', '3000mAh', 'Chống nước, chống bụi, Mặt kính 2.5D', 'Quét mồng mắt, Mở khóa bằng vân tay', 'Xanh dương, Đen'),
(14, 'Samsung Galaxy C9 Pro', 'Samsung', 11490000, 'còn hàng', 'sgc9.jpg', '16MP', '16MP', '4000mAh', 'Không', 'Mở khóa bằng vân tay', 'Đen, Vàng đồng'),
(15, 'Samsung Galaxy Note ', 'Samsung', 9990000, 'còn hàng', 'sgn5.png', '5MP', '16MP', '3000mAh', 'Mặt kính 2.5D', 'Mở khóa bằng vân tay', 'Vàng đồng'),
(16, 'Samsung Galaxy A7', 'Samsung', 9990000, 'còn hàng', 'sga7.jpg', '16MP', '16MP', '3600mAh', 'Mặt kính 2.5D, Chống nước, Chống bụi', 'Mở khóa bằng vân tay', 'Đen, Vàng đồng'),
(17, 'Samsung Galaxy A5', 'Samsung', 7990000, 'còn hàng', 'sga5.jpg', '16MP', '16MP', '3000mAh', 'Mặt kính 2.5D, Chống nước, Chống bụi', 'Mở khóa bằng vân tay', 'Đen, Vàng đồng'),
(18, 'Oppo F3 Plus', 'Oppo', 10690000, 'còn hàng', 'of3+.jpg', '16MP và 8MP', '16MP', '4000mAh', 'Mở ứng dụng nhanh bằng vân tay, hình vẽ', 'Mở khóa bằng vân tay', 'Đen, Vàng đồng'),
(19, 'Oppo F3', 'Oppo', 6990000, 'còn hàng', 'of3.jpg', '16MP và 8MP', '13MP', '3200mAh', 'Chạm 2 lần sáng màn hình', 'Mở khóa bằng vân tay', 'Đen, Vàng đồng, Vàng hồng'),
(20, 'Oppo A71', 'Oppo', 4690000, 'còn hàng', 'oa71.jpg', '5MP', '13MP', '3000mAh', 'Chạm 2 lần sáng màn hình', 'Không', 'Đen, Vàng đồng'),
(21, 'Oppo A37', 'Oppo', 3290000, 'còn hàng', 'oa37.jpg', '5MP', '8MP', '2630mAh', 'Chạm 2 lần sáng màn hình', 'Không', 'Vàng đồng, Vàng Hồng'),
(22, 'HTC U11', 'HTC', 16990000, 'còn hàng', 'hu11.png', '16MP', '12MP', '3000mAh', 'Mặt kính 2.5D, Chống nước, Chống bụi', 'Mở khóa bằng vân tay', 'Xanh dương, Bạc'),
(23, 'HTC U Ultra', 'HTC', 14990000, 'còn hàng', 'huu.jpg', '16MP', '12MP', '3000mAh', 'Mặt kính 2.5D', 'Mở khóa bằng vân tay', 'Xanh dương, đen'),
(24, 'HTC U Play', 'HTC', 8990000, 'còn hàng', 'huu.jpg', '16MP', '16MP', '2500mAh', 'Mặt kính 2.5D', 'Mở khóa bằng vân tay', 'Xanh dương, đen'),
(25, 'HTC 10 EVO', 'HTC', 5990000, 'còn hàng', 'h10e.jpeg', '8MP', '16MP', '3200mAh', 'Chống nước, Chống bụi', 'Mở khóa bằng vân tay', 'Bạc, Xám'),
(26, 'HTC One ME', 'HTC', 4990000, 'còn hàng', 'hom.png', '4 Ultra Pixel', '20MP', '2840mAh', 'HTC BoomSound', 'Mở khóa bằng vân tay', 'Vàng đồng, Trắng và Vàng Đồng'),
(27, 'HTC One A9s', 'HTC', 4990000, 'còn hàng', 'hoa9s.jpg', '5MP', '13MP', '2300mAh', 'Sạc pin nhanh', 'Mở khóa bằng vân tay', 'Bạc, Vàng đồng'),
(28, 'Vivo V7+', 'Vivo', 7990000, 'còn hàng', 'vv7+.jpg', '24MP', '16MP', '3225mAh', 'Đang cập nhật', 'Mở khóa bằng vân tay', 'Đen, Vàng đồng'),
(29, 'Vivo V5s', 'Vivo', 6690000, 'còn hàng', 'vv5s.png', '20MP', '13MP', '3000mAh', 'Mặt kính 2.5D', 'Mở khóa bằng vân tay', 'Vàng đồng, Vàng Hồng'),
(30, 'Vivo Y53', 'Vivo', 3390000, 'còn hàng', 'vy53.png', '5MP', '8MP', '2500mAh', 'Không', 'Không', 'Đen, Vàng đồng'),
(32, 'Philips E181', 'Philips', 690000, 'còn hàng', 'philipsE181.jpg', 'VGA', 'không', '3100mAh', '2G, Bluetooth, pin lâu, 2 sim', 'không', 'đen, vàng'),
(33, 'Ốp lưng Galaxy J7 Pro', 'Osmia', 30000, 'còn hàng', 'galaxyj7.jpg', 'không', 'không', '0', 'Làm bằng nhựa dẻo <br/> Giúp bảo vệ điện thoại tốt hơn', 'không', '/'),
(34, 'Ốp lưng iPhone 7 Nhựa', 'Cosano', 30000, 'còn hàng', 'iphone7.jpg', 'không', 'không', '0', 'Làm bằng nhựa dẻo <br/>\r Giúp bảo vệ điện thoại tốt hơn', 'không', '/'),
(35, 'Ốp lưng iPhone 6', 'đang cập nhật', 30000, 'còn hàng', 'iphone6.jpg', 'không', 'không', '0', 'Làm bằng nhựa dẻo <br/> Giúp bảo vệ điện thoại tốt hơn', 'không', '/'),
(36, 'Ốp lưng Galaxy Note 8', 'Osmia', 190000, 'còn hàng', 'note8.jpg', 'không', 'không', '0', 'Làm bằng nhựa dẻo <br/> Giúp bảo vệ điện thoại tốt hơn', 'không', '/'),
(37, 'Ốp lưng Galaxy S8 Nhựa', 'Solid', 70000, 'còn hàng', 's8.jpg', 'không', 'không', '0', 'Làm bằng nhựa dẻo <br/> Giúp bảo vệ điện thoại tốt hơn', 'không', '/'),
(38, 'Pin sạc dự phòng 5000mAh', 'eValu', 120000, 'còn hàng', 'sac1.jpg', 'không', 'không', 'không', 'Dung lượng pin 5000mAh <br/> Tương thích mọi loại điện thoại', 'không', '/'),
(39, 'Pin sạc dự phòng 7500mAh', 'eSaver', 250000, 'còn hàng', 'sac2.jpg', 'không', 'không', 'không', 'Dung lượng pin 7500mAh <br/> Tương thích mọi loại điện thoại', 'không', '/'),
(40, 'Pin sạc dự phòng Polymer', 'eValu', 350000, 'còn hàng', 'sac3.jpg', 'không', 'không', 'không', 'Dung lượng pin 5000mAh <br/> Tương thích mọi loại điện thoại', 'không', '/'),
(41, 'Pin sạc dự phòng 10.000mAh', 'eValu', 300000, 'còn hàng', 'sac4.jpg', 'không', 'không', 'không', 'Dung lượng pin khủng 10.000mAh <br/> Tương thích mọi loại điện thoại', 'không', '/'),
(42, 'Pin sạc dự phòng Polymer', 'eSaver', 250000, 'còn hàng', 'sac5.jpg', 'không', 'không', 'không', 'Dung lượng pin 5000mAh <br/> Tương thích mọi loại điện thoại', 'không', '/'),
(43, 'Tai nghe Apple Airpod', 'Apple', 5000000, 'còn hàng', 'apple.jpg', 'không', 'không', '0', 'Tai nghe không dây của Apple chính hãng <br/> Tương thích với các đời iPhone chạy iOS 8 trở lên', 'không', '/'),
(44, 'Tai nghe Sony XBA-Z5', 'Sony', 11200000, 'còn hàng', 'sony.jpg', 'không', 'không', '0', 'Tai nghe khủng của Sony, <br/> Chuyên về âm thanh và phân tích các dải tần số âm thanh <br/> Giúp hài lòng các tín đồ về âm nhạc', 'không', '/'),
(45, 'Tai nghe Sony MDR-EX', 'Sony', 2500000, 'còn hàng', 'sony2.jpg', 'không', 'không', '0', 'Tai nghe khủng của Sony, <br/> Chuyên về âm thanh và phân tích các dải tần số âm thanh <br/> Giúp hài lòng các tín đồ về âm nhạc', 'không', '/'),
(46, 'Tai nghe Beats Studio', 'Beats', 7500000, 'còn hàng', 'beats.jpg', 'không', 'không', '0', 'Tai nghe Headphone đến từ Mỹ <br/> Thương hiệu đã được Apple liên kết để tạo ra những sản phẩm tai nghe chất lương <br/> ', 'không', '/'),
(47, 'Tai nghe Beats Tour ', 'Beats', 2000000, 'còn hàng', 'beats1.jpg', 'không', 'không', '0', 'Tai nghe In-Ear đến từ Mỹ <br/> Thương hiệu đã được Apple liên kết để tạo ra những sản phẩm tai nghe chất lương <br/> ', 'không', '/');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ho_user` varchar(45) NOT NULL,
  `ten_user` varchar(45) NOT NULL,
  `sdt` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dia_chi` varchar(45) NOT NULL,
  `quan` varchar(45) NOT NULL,
  `phuong` varchar(45) NOT NULL,
  `thanh_pho` varchar(45) NOT NULL,
  `nuoc` varchar(45) NOT NULL,
  `zip_code` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`,`username`,`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `ho_user`, `ten_user`, `sdt`, `email`, `dia_chi`, `quan`, `phuong`, `thanh_pho`, `nuoc`, `zip_code`) VALUES
(1, 'nguyenvana', '123456789', 'nguyen', 'van a', 123456789, 'nguyenvana@yahoo.com', '123 nguyen trai', '5', '3', 'ho chi minh', 'vietnam', '88888'),
(6, 'test', 'test', 'vu', 'nguyen', 1234567890, 'darkevil9712@gmail.com', '123 nguyen trai', '5', '3', 'hcm', 'vietnam', '88888'),
(7, 'abcdef', '123456789', 'Vu', 'Nguyen', 1234567890, 'darkevil9712@gmail.com', '123 nguyen trai', '5', '3', 'hcm', 'vietnam', '88888'),
(8, 'abcdefghi', '123456789', 'vu', 'nguyen', 1234567898, 'darkevil9712@gmail.com', '123 nguyen trai', '5', '3', 'hcm', 'vietnam', '88888');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gio_hang`
--
ALTER TABLE `gio_hang`
  ADD CONSTRAINT `user_giohang` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
