-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 16, 2020 lúc 01:24 SA
-- Phiên bản máy phục vụ: 5.7.14
-- Phiên bản PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thietbi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(10000) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(1, 5, 20, 'Điện Thoại OPPO RENO 3 (8GB/128GB)', 7590000, 2),
(2, 5, 21, 'Laptop HP, i7 7500U, 16GB, 256GB SSD', 25500000, 3),
(3, 24, 13, 'Dell Inspiron N3481/Core i3-7020U/4Gb', 9990000, 1),
(4, 25, 1, 'Samsung Galaxy M11 (32GB/3GB) ', 13960000, 4),
(5, 25, 14, 'Dell Precision M6700', 53980000, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `sodienthoai` int(11) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`) VALUES
(1, 'Nguyen Van A', 123456789, 'nguyenvana@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Điện Thoại', 'https://iconsgalore.com/wp-content/uploads/2018/10/cell-phone-1-featured-2.png'),
(2, 'Laptop', 'https://www.freeiconspng.com/uploads/laptop-icon-9.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(10000) NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'Samsung Galaxy M11 (32GB/3GB) ', 3490000, 'https://cdn.tgdd.vn/Products/Images/42/111107/samsung-galaxy-a7-2018-blue-600x600.jpg', 'Với khung viền tinh giản và những sắc màu thời thượng: Đen Vô Cực và Xanh Đại Dương, Galaxy M11 khẳng định phong cách hiện đại nơi bạn. Tận hưởng cảm giác dễ chịu khi sử dụng nhờ những đường cong mềm mại trên thiết kế đối xứng từ Samsung.\r\nSự kết hợp giữa camera Góc Rộng 77 độ và Góc Siêu Rộng 115 độ trong Galaxy M11 giúp bạn chụp toàn cảnh dễ dàng hơn bao giờ hết. Chụp điều bạn thấy, trọn vẹn từng chi tiết.\r\nSự kết hợp giữa camera Góc Rộng 77 độ và Góc Siêu Rộng 115 độ trong Galaxy M11 giúp bạn chụp toàn cảnh dễ dàng hơn bao giờ hết. Chụp điều bạn thấy, trọn vẹn từng chi tiết.\r\nSự kết hợp giữa camera Góc Rộng 77 độ và Góc Siêu Rộng 115 độ trong Galaxy M11 giúp bạn chụp toàn cảnh dễ dàng hơn bao giờ hết. Chụp điều bạn thấy, trọn vẹn từng chi tiết.\r\n\r\n\r\n\r\n', 1),
(2, 'SamSung Galaxy Note 8 64GB', 5390000, 'https://sudospaces.com/mobilecity-vn/images/2019/10/samsung-note-10-plus-4.jpg', 'Galaxy Note 8 là niềm hy vọng vực lại dòng Note danh tiếng của Samsung với diện mạo nam tính, sang trọng. Trang bị camera kép xóa phông thời thượng, màn hình vô cực như trên S8 Plus, bút Spen với nhiều tính năng mới và nhiều công nghệ được Samsung ưu ái đem lên Note 8.\r\nDù được giới thiệu là màn hình lên tới 6.3 inch nhưng thực sự máy khi cầm trên tay rất nhỏ gọn nhờ vào công nghệ “màn hình vô cực” tiên tiến nhất hiện nay của Samsung.\r\nCác cạnh bên máy được làm cong đều khiến mình khi cầm có cảm giác ôm tay rất thoải mái và không hề bị cấn.', 1),
(3, 'Laptop Lenovo IdeaPad S145-15API', 9699000, 'https://hanoicomputercdn.com/media/product/52580_lenovo_ideapad_s145__8_.jpg', 'Là một chiếc laptop màn hình lớn 15,6 inch nhưng Lenovo Ideapad S145 có trọng lượng vỏn vẹn chỉ 1,85kg, quá dễ dàng để bạn cho vào cặp xách hay balo và mang đi bất cứ đâu. Hơn nữa, thiết kế mới với viền màn hình mỏng, bản lề linh hoạt còn giúp Lenovo S145 gọn gàng chỉ tương đương các mẫu laptop 14 inch truyền thống. \r\nThưởng thức những đoạn phim. MV âm nhạc một cách tuyệt vời nhờ màn hình sắc nét và âm thanh sống động của Lenovo IdeaPad S145. Chúng ta có một màn hình lớn 15,6 inch chống chói, độ phân giải Full HD với chi tiết cao và hình ảnh hiển thị chân thực. Âm thanh rõ nét, sống động hơn bao giờ hết khi được tinh chỉnh bởi Dolby Audio. Thỏa mãn cả phần nhìn lẫn phần nghe của bạn, đó là Lenovo IdeaPad S145. \r\n', 2),
(4, 'Laptop Asus D509DA-EJ285T ', 9799000, 'https://cdn.fptshop.com.vn/Uploads/Originals/2019/10/7/637060402492738981_asus-vivobook-s431-bac-1.png', 'Không chỉ là một trong những mẫu laptop phổ thông 15.6 inch nhỏ nhất thế giới, dòng Laptop Asus D509DA còn rất mạnh mẽ với bộ vi xử lý đến từ AMD cùng với viền màn hình mỏng hiện đại. Cho dù là giải trí hay công việc, Laptop Asus D509DA luôn mang lại trải nghiệm vô cùng chân thực và sống động cho người dùng. Còn chần chừ gì nữa mà không cùng HNC tìm hiểu dòng laptop này qua mẫu Laptop Asus D509DA-EJ285T thôi nào!\r\nLaptop Asus D509DA-EJ285T là một chiếc laptop phổ thông 15.6 inch mỏng nhẹ. Trọng lượng của máy chỉ khoảng 1.8kg. Tuy nhiên không vì thế mà máy ọp ẹp dễ hỏng mà trái lại, máy khá cứng cáp do được gia cố thêm bộ khung chống sốc ở các bộ phận như ổ cứng, hai cạnh bên màn hình, nắp lưng và bàn phím. Bộ khung này không chỉ có tác dụng bảo vệ các linh kiện của máy tốt hơn, mà còn có tác dụng bảo vệ các khớp bản lề, cải thiện việc gõ và đóng mở máy, giúp cho người dùng yên tâm làm việc dù có đang di chuyển.', 2),
(5, 'Laptop HP Pavilion 14-ce3029TU (8WH94PA)', 15990000, 'https://product.hstatic.net/1000233206/product/hp-pavilion-14-ce3029tu-8wh94pa-1_77956a3c76a04fd59bfbc1c5ab80c0ca_master.png', 'Laptop HP mang màu bạc sang trọng với các đường nét thiết kế tinh tế. Khối lượng siêu nhẹ cùng khung máy cứng cáp mang lại tính di động cao cho máy. Bạn có thể dễ dàng sử dụng ở bất cứ nơi đâu và bất kì lúc nào. \r\nMàn hình máy lớn 14-inch với độ phân giải HD cho hình ảnh rõ nét. Công nghệ chống chói Anti-glare giúp cho người dùng có thể làm việc tốt ngay cả những nơi có điều kiện ánh sáng chói như ở ngoài trời. Pin của Laptop HP 14s-dq1065TU (8QN32PA) là loại pin 3 cell với thời lượng sử dụng thực tế khoảng 3.5 đến 5 giờ đồng hồ tùy theo tác vụ sử dụng nặng hay nhẹ. Nhìn chung, thời lượng pin này không quá cao nhưng đủ để người dùng sử dụng máy trong một buổi làm việc.\r\n\r\n\r\n\r\n', 2),
(6, 'iPhone 11 Pro Max 256GB Midnight Green ', 30790000, 'https://techland.com.vn/wp-content/uploads/2019/09/dien-thoai-iphone-11-pro-max-3a.jpg', 'iPhone 11 Pro Max là sản phẩm dành cho những ai đang kiếm tìm sự hoàn hảo trong quá trình trải nghiệm điện thoại. Với chiếc iPhone này, Apple đã vươn tới đỉnh cao khi tinh chỉnh tối ưu mọi yếu tố bên trong như hiệu năng, camera, pin và thiết kế một cách tốt nhất.\r\nHiểu được nhu cầu chụp ảnh cao của người dùng hiện nay, Apple đã nâng tầm iPhone 11 Pro Max bằng cụm 3 camera xuất sắc trên mặt lưng máy. Nhờ hệ thống 3 camera này, sản phẩm có thể chụp ảnh trong môi trường thiếu sáng rất tốt, mở rộng góc chụp tới 4 lần và bổ sung tính năng quay video 4K tốc độ 60 fps. Chưa dừng lại ở đó, chiếc điện thoại iPhone 11 Pro Max còn sở hữu nhiều công cụ phần mềm hậu kỳ hiệu quả để bạn chỉnh sửa và cho ra đời bức ảnh thành phẩm thực sự ưng ý.', 1),
(7, 'REALME 5 64GB', 2995000, 'http://chuyenphanphoi.vn/upload/product/339163701159.png', 'Realme 5 sở hữu cho mình tới 4 camera sau ở trong phân khúc mà những chiếc máy khác đang "loay hoay" với cụm camera kép.\r\nVới cụm camera này thì Realme 5 tự tin đáp ứng cho bạn hầu hết các nhu cầu trong cuộc sống thường ngày.\r\nCamera selfie ở mặt trước với độ phân giải 13 MP với tính năng làm đẹp bằng AI thì bạn có thể tự tin chụp ảnh mọi lúc mọi nơi.\r\n', 1),
(8, 'iPhone 11 64GB', 17589000, 'https://cdn.dienthoaigiakho.vn/630x/https://cdn.dienthoaigiakho.vn/photos/1589597863298-iphone11-yellow-select-2019-min.jpg', 'Hoàn toàn xứng đáng với những gì được mong chờ, bộ 3 iPhone 11 của Apple năm nay nổi bật với chip A13 Bionic được giới thiệu là mạnh nhất trong các dòng smartphone, màn hình rộng đến 6.5 inch, hệ thống camera được cải tiến nổi bật và Face ID được nâng cấp. Bộ 3 phiên bản iPhone 11 bao gồm iPhone 11, iPhone 11 Pro và iPhone 11 Pro Max\r\nĐây là một trong những cải tiến đáng chú ý của dòng iPhone 11 từ tính năng cho đến thiết kế. Cụ thể về tính năng, Apple đã giới thiệu đến người dùng hệ thống camera góc rộng (Wide) và góc siêu rộng (Ultra Wide).', 1),
(9, 'Asus X00DD ZenFone 3 Max 5.5 inch ZC553KL', 3690000, 'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/z/f/zfmaxpro_m2__front_darkblue.jpg', 'ZenFone 3 Max là chiếc điện thoại thông minh 5,5 inch có thể loại trừ mọi nỗi lo về thời lượng pin, với đủ sức mạnh để giúp bạn vượt qua một ngày làm việc dài, và thậm chí là xa hơn nữa! Với pin 4100mAh dung tích lớn, ZenFone 3 Max có thể hoạt động dài, với thời gian chờ lên đến 38 ngày. Tất cả chúng ta đều cần thêm thời gian để nói chuyện, kết nối, vui chơi và giải trí mà không lo hết pin.\r\nDung tích pin 4100mAh của ZenFone 3 Max lớn đến mức chiếc điện thoại này có thể đảm nhiệm vai trò của một pin sạc dự phòng để sạc các thiết bị kỹ thuật số khác của bạn. Vậy nên, đừng lo khi các thiết bị khác của bạn bị hết pin: chỉ việc cắm chúng vào ZenFone 3 Max để nạp năng lượng một cách tiện lợi.', 1),
(10, 'Huawei Y9', 3990000, 'https://cdn.fptshop.com.vn/Uploads/Originals/2019/2/22/636864401747926277_huawei-y9-2019-blue-1.png', 'Huawei Y9 2019 sở hữu màn hình siêu lớn tới 6,5 inch và 4 camera AI, mang đến cho bạn những trải nghiệm đáng kinh ngạc.\r\nCả camera chính lẫn camera trước của Huawei Y9 2019 đều là những cụm camera kép chất lượng với sự hỗ trợ của trí tuệ nhân tạo AI. Camera trước bao gồm hai cảm biến 16MP + 2MP còn camera chính là 13MP + 2MP, cho bạn khả năng chụp ảnh xóa phông ấn tượng. AI sẽ tự động nhận diện được hơn 500 nhóm chủ thể, thuộc 22 chủ đề khác nhau để đưa ra những tùy chỉnh tối ưu hóa cảnh qua thời gian thực, mang đến những bức ảnh đẹp và sinh động nhất.', 1),
(11, 'Surface Laptop 3', 30500000, 'https://surfacepro.vn/thumb/468/upload/surfacepro.vn/surface-laptop-3/15-amd-ryzen-5-8gb-128gb/rface-laptop-3-15-amd-ryzen-5-8gb-128gb_02.jpg', 'Microsoft cho ra mắt phiên bản Surface Laptop 3 15 inch với cấu hình đến từ AMD Ryzen thay vì Intel đã tạo nên sự bất ngờ khá lớn trên thị trường laptop. Không chỉ thế thiết bị còn có thiết kế ngoại hình rất độc đáo và hiện đại hứa hẹn đem đến cho người dùng những trải nghiệm tuyệt vời nhất khi sử dụng.\r\nGiống như Surface Laptop 2 thì Surface Laptop 3 vẫn là mẫu máy tính xách tay sở hữu màn hình cảm ứng đa điểm chạm giúp người dùng có những trải nghiệm tuyệt vời nhất. Với phần vỏ được làm bằng nhôm nguyên khối, logo Microsoft được in sáng bóng ở giữa - thiết kế đơn giản nhưng đầy sang trọng và tinh tế.\r\n\r\nMáy được thiết kế vát mỏng dần từ cạnh trước ra cạnh sau tạo nên một độ nghiêng thoải mái khi sử dụng. Surface Laptop 3 sẽ có thêm tùy chọn màu sắc nhiều hơn so với thế hệ trước để người dùng lựa chọn.\r\n\r\nNgoài ra việc sở hữu kích thước 13.4x9.6.0.57 inch với trọng lượng chỉ 1.54 kg đã biến chiếc máy tính trở thành mẫu máy sở hữu màn hình 15 inch mỏng nhất trên thị trường hiện nay. Và thiết bị cũng được đánh giá rất cao về tính di động nhờ khả năng có thể dễ dàng cầm nắm và di chuyển mọi lúc mọi nơi rất tiện lợi.', 2),
(12, 'Laptop Asus X509FJ-EJ158T', 16990000, 'https://hanoicomputercdn.com/media/product/52606_asus_x409ma_bv034t__5_.jpg', 'Những chiếc laptop nhỏ gọn, thiết kế đẹp mắt càng ngày càng trở nên thu hút khách hàng. Laptop Asus X509FJ-EJ158T tự hào là một trong những chiếc Laptop 15” nhỏ gọn nhất thế giới.\r\nVới trọng lượng siêu nhẹ chỉ 1.8kg, có thể dễ dàng mang theo đến mọi nơi không khiến bạn bạn thấy vướng víu hay nặng nề, mang lại trải nghiệm di động tốt nhất. Thiết kế sang trọng với hai màu Bạc ánh trăng và Xám tinh tú phù hợp với sở thích của từng người sử dụng.\r\n\r\nKhung máy của Asus X509FJ-EJ158T được gia cố chắc chắn cho phần cạnh và nắp lưng, bàn phím tạo sự chắc chắn, bền bỉ trong quá trình sử dụng.', 2),
(13, 'Dell Inspiron N3481/Core i3-7020U/4Gb', 9990000, 'https://cdn.fptshop.com.vn/Uploads/Originals/2019/6/17/636963912790626520_dell-3481-den-1.png', 'Đánh giá chi tiết Dell Inspiron N3481/Core i3-7020U/4Gb/1Tb/14"HD/3cell/Win 10/030CX2\r\nNhỏ gọn, bền bỉ và mạnh mẽ, Dell Inspiron N3481 là chiếc laptop rất thích hợp cho công việc văn phòng, học tập với hiệu năng mượt mà cùng khả năng sử dụng tốt trong thời gian dài.\r\nDell Inspiron N3481 trang bị bộ vi xử lý Intel Core i3 7020U, đi cùng 4GB RAM DDR4 và 1TB ổ cứng. Với cấu hình này, máy có thể hoạt động tốt trong học tập cũng như công việc văn phòng. Để nâng cấp laptop cũng hết sức dễ dàng khi Dell N3481 có tới 2 khe RAM và ổ cắm thêm SSD. Khả năng tối ưu hoá tốt đến từ Dell, phần cứng mạnh mẽ, dễ dàng nâng cấp giúp cho bạn có thể yên tâm sử dụng laptopn Inspiron trong thời gian dài mà không lo máy bị chậm đi.', 2),
(14, 'Dell Precision M6700', 26990000, 'https://www.laptopvip.vn/images/detailed/2/precision-m6700-core-i7-3520m-2900-mhz-17-3-1920x1080-16384mb-1000gb-dvd-rw-wi-fi-bluetooth-win-7-pro-64-1_G1061_1376373011533.jpg', 'Dell Precision 5540 rất mỏng nhẹ, nhỏ gọn với trọng lượng chỉ 1.77 kg, thiết kế đẹp mắt, hiện đại và hiện có hai màu.\r\n\r\nĐặc biệt, với màn hình InfinityEdge 15.6 inch có tới OLED PremierColor đảm bảo khả năng hiển thị rực rỡ, gần như không biên giới, có thể nâng cấp lên màn hình cảm ứng UHD tùy chọn có 100% Adobe RGB với 500nits hoặc màn hình OLED với 100% DCI-P3. \r\nMột hệ thống làm mát mang tính cách mạng với quạt kép giúp cải thiện luồng không khí và giữ cho hệ thống của bạn mát mẻ dưới khối lượng công việc nặng. \r\nTrình đọc dấu vân tay Windows Hello tùy chọn đảm bảo rằng bạn và chỉ bạn mới có thể truy cập công việc của mình. Chỉ cần đặt ngón tay của bạn lên cảm biến và cứ như thế, bạn đã sẵn sàng để thực hiện nhiệm vụ tiếp theo. Hoặc nâng cấp lên Windows Hello IR Camera và đăng nhập bằng một cái nhìn.', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
