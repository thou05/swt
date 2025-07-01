Created: 202506182117

Tags: 

## DDT 
- kĩ thuật ddt khi chơi với unit test
	- ddt viết tắt của: `DATA DRIVEN TESTING` - kĩ thuật kiểm thử theo tập data chuẩn bị sẵn
	- là kĩ thuật `tách lời gọi hàm cần test ra 1 chỗ, data đầu vào và expected ra 1 chỗ khác`, sau đó nhồi/nạp/feeed đám data này vào lời gọi hàm 
		- giúp: nhìn code test dễ dàng, trong sáng, tách biệt việc chuẩn bị data ra 1 chỗ => ta dễ tập trung trong việc build bộ data test ko bị trộn với code test đám data này
		- vì việc kiểm thử đòi hỏi tính chặt chẽ, cẩn thận, code (JUnit code) để test code cũng cần phải đẹp, chuẩn, dễ bảo trì
	- trong giới công nghiệp/các cty phần mềm, tập data test để ở
		- trong file Excel theo hàng cột
		- trong text file (dùng tab để phân cách giá trị) dạng `CSV`
		- nhúng trực tiếp tỏng code nhưng tách so với code JUnit Test
		- để trong table của database chứa toàn data để test, không phải là database của app
	```
	vd: phân tích bài test hàm tính giai thừa
	Input(n)        Expected(n!)
	   0                1
	   1                1
	   2                2
	   3                6
	   4                24
	   5                120
	   6                720
	=> assertEquals(expected, .getF(input));
		=> tập data cần veryfy đặt thành các biến
			feed các biến vào code JUnit/Unit Test
	Kĩ thuật DDT
		trong sáng, dễ hiểu, dễ đánh giá được thiếu case 
		hay ko, tình huống dùng hàm đã có đủ đại diện chưa
	```
	- CHỐT
		- DDT chẳng qua là tách tập data test ra 1 chỗ, đặt cho chúng thành các biến tương ứng, rồi đưa biến vào hàm test
		- DDT còn được gọi 1 tên mới: KIỂM THỬ UNIT TEST KIỂU THAM SỐ HÓA - PARAMETERIZED - tham số hóa tập data test

## Tom tat
- Unit Test Framework thường có
	- nhóm hàm assertX() để so sánh expected và actual
	- nhóm hàm bắt ngoại lệ coi có xuất hiện, ngoại lệ xuất hiện sẽ là màu đỏ, nhưng nếu kiểm soát nó, thì là xanh
	- tách data và câu lệnh test hàm riêng biệt - DDT
	- chạy song song các test cases
	- gài ràng buộc (dependency) giữa các test case
		- vd login thành công thì mới CRUD
			- nếu test case login thành công -> chạy mấy test case sau login
			- thất bại -> những test case sau login vô nghĩa
	- generate ra các report/báo cáo/bản thống kê code lỗi ở những test case nào
	- chạy ở chế độ console/command line (giống chạy Ant có chạy test luôn) - Test Runner 
	- generate luôn giùm các test cases để ta chỉ việc modify thay vì phải viết từ đầu 


-----
## References
1.
