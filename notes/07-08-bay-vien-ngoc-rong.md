Created: 202506121623

Tags: 

- note
	- https://agilemanifesto.org/
		```
		Through this work we have come to value:  
		
		Individuals and interactions over processes and tools  
		Working software over comprehensive documentation  
		Customer collaboration over contract negotiation  
		Responding to change over following a plan  
		
		That is, while there is value in the items on  
		the right, we value the items on the left more.
		```
	
	- huyền chíp - đường đến stanford

## 5.  7 Testing Priciples
### 5.1 Kiểm thử phần mềm không phải là việc chứng minh, hay khẳng định, hay phải tuyên bố phần mềm tui không có lỗi - free of errors/defects
- Hiểu ngược lại: phần mềm luôn có lỗi, còn lỗi, việc của kiểm thử/testing là tìm lỗi (không tìm hết được)
- Nhưng tiêu chí sản xuất luôn là: HƯỚNG ĐẾN CHẤT LƯỢNG, GIẢM THIỂU BUG NẾU CÓ THỂ
- các công ty luôn đưa ra những quy trình để đảm bảo sp làm ra có chất lượng: 6 sigma, 5S, ISO, CMMI,...
- KHÔNG CẦN CHỜ ĐẾN LÚC CÓ SP MỚI KIỂM THỬ, KIỂM THỬ TỪ RẤT SỚM!!

### 5.2 Không thể test hết các tổ hợp sd/tình huống sd phần mềm của USER
- Khi ta bán phần mềm ra thị trường (product-based, generic app), khi ta bàn giao phần mềm theo đặt hàng (service-based, customized app, bespoke app) => người dùng/user sẽ có n cách thức dùng app 
- dân kiểm thử/tester dùng trước cái app theo cách/họ tưởng tượng cách mà user/người dùng app sẽ dùng, tưởng tượng cách người dùng dùng app, dùng theo cách đó, coi có văng lỗi không
- số tổ hợp cách dùng app là vô cùng, do đó có tiên đề 2: không thể test hết cách dùng của user với app 
- => phải có cách/trick/tip/kĩ thuật nào đó để ko test hết các tổ hợp sd mà vẫn dám kết luận app ổn để xài
- chiêu: trong bản đồ tư duy phần kĩ thuật test hộp đen

### 5.3 EARLY TESTING
- KIỂM THỬ CÀNG SỚM CÀNG TỐT, VÌ VÀO GIAI ĐOẠN CODE, VIỆC SỬA APP CÀNG TỐN CHI PHÍ
- NGAY TỪ KHI LẤY REQS ĐÃ CẦN TEST DOCUMENT RỒI, TEST THIẾT KẾ RỒI


```
NOTE: phân biệt CUSTOMER and USER
- customer: người đặt hàng, người xuống tiền để có sản phẩm, có thể không dùng
- user: người trực tiếp dùng sản phẩm
```
### 5.4 Defect clustering - sự phân bố hay tập trung của bug
- Lỗi thường sẽ xảy ra nhiều ở 1 số chỗ trong app -> Dân kiểm thử biết điều này để tập trung lực/thời gian vào trong việc test chỗ này
- VD:
	- lỗi hay xảy ra ở chỗ tích hợp với app khác, module khác: tích hợp app mình với MOMO, gọi API 
	- CRUD truyền thống ÍT lỗi (nằm trong hệ thống nhà mình)
	- phần import từ excel để tạo data nguồn cho app mới đang viết -> bug trong định dạng dữ liệu nhập vào hệ thống
- nguyên lý pareto 80/20, có cuốn sách nguyên lý 80/20 

### 5.5 Pesticide paradox
- nghịch lý thuốc trừ sâu, hiện tượng ` lờn` thuốc, `kháng` thuốc
- chủ quan, quen việc test của dân kiểm thử, test mãi 1 cái app => dẫn đến bỏ sót bug => mời bạn vào đảm bảo chất lượng phần mềm, bạn lại để bug to xuất hiện
- Nên thay đổi project cần test, module cần test, môi trường app, nay test mobile, mai tét web -> tránh nhàm chán, thêm mới mẻ trong cv

### 5.6 Kiểm thử phụ thuộc ngữ cảnh
- các loại app khác nhau, môi trường chạy app khác nhau, thì phải có phương pháp kiểm thử khác nhau, cách thức kiểm thử khác nhau
- app chạy đa nền (nhiều os) khác app hỗ trợ 1 platform
- vd
	- responsive là 1 dạng test khi app chạy trên màn hình to/nhỏ
	- tính tương thích của thiết bị: in bill loại giấy, loại máy in
	- IOT cần có thể môi trường giả lập (có thể) hoặc ra thực địa để xem app chạy thế nào

### 5.7 Ảo tưởng về việc app hết lỗi
- Vỗ ngực app ngon, hết lỗi (sai), ít lỗi, app chất lượng => câu này không đủ => Việc làm app chất lượng là DEFAULT, BÁN HÀNG PHẢI BÁN HÀNG CÓ CHẤT LƯỢNG
- Chuyện quan trọng hơn phải là: APP BẮT TREND, APP ĐƯỢC KHÁCH HÀNG YÊU THÍCH, ĐƯỢC KHÁCH HÀNG RECOMMEND ĐỀ XUẤT CHO AI ĐÓ, APP CÓ LƯỢNG USER/CUSTOMER ĐÔNG ĐẢO
- Mục tiêu tối thượng của làm app: app làm user/customer hài lòng (UX và Quality), vỗ ngực chất lượng không là ko đủ!!
- REQUIREMENTS PHẢI CHUẨN TRONG HẾT MỨC KHẢ NĂNG

-----
## References
1.
