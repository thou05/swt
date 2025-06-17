Created: 202506161417

Tags: 

## TESTING LEVEL
- là cách phân chia công việc test, tiến hành công việc kiểm thử chất lượng phần mềm dựa trên tiến trình hoàn thiện code, hoàn thiện app
- (NOTE: thực sự việc kiểm thử phần mềm phải được tiến hành sớm hơn, không chờ đến giai đoạn viết code, test ngay ở giai đoạn reqs, NGUYÊN LÍ EARLY TESTING)
- Chia 4 mức độ/giai đoạn kiểm thử app dựa trên việc viết code, việc hoàn thiện code
	- UNIT TEST/TESTING
	- INTEGRATION TEST
	- SYSTEM TEST
	- UAT (User Acceptance Test)
### UNIT TEST
- Unit: đơn vị code, có thể xem 1 hàm, 1 class là 1 đơn vị code cơ bản
- developer sẽ phải là gã có trách nhiệm đảm bảo rằng hàm/class của mình ngon!! 
- ngon cho chính mình sử dụng, ngon cho người khác sử dụng (làm việc nhóm, sự án)
- Thế nào là code ngon, ổn - chắc chắn phải kiểm thử, DEV PHẢI TEST CODE CỦA MÌNH, TEST HÀM, METHOD, CLASS
- Làm sao test code của mình?
	- Mở code ra đọc
	- Chạy thử code
		- Chạy bằng cách gọi hàm ở trong main()
		- In ra trang web, hoặc windows form, hoặc ghi ra LOG file (.txt)
		- 2 cách này đều ổn, nhưng bị 1 vấn đề
			- nếu ta có nhiều hàm cần test thì sao? -> code chạy thử hàm cũng dài dài
			- mắt ta phải nhìn các OUTPUT trả về của hàm (ACTUAL), ta tự so sánh (= suy luận của ta) với cái ta nghĩ rằng app phải trả ra thế này (EXPECTED)
			- máy, ngôn ngữ lập trình dư sức so sánh 2 giá trị bất kì. Nếu để mắt và não bộ phải suy nghĩ, tự so sánh expected và actual của hàm => không tận dụng được ưu thế của NNLT => cảm hứng để đề xuất 1 kĩ thuật kiểm thử hàm, class hiệu qảu hơn không cần dùng sức người so sánh EX và ACT, viết 1 đoạn code nho nhỏ so sánh giùm, nếu == nhau thì báo, không == nhau cũng báo
			- nếu có quá nhiều cặp EX và ACT cần so sánh, thì máy ơi tự so sánh cả đám giùm, kết luận chung giùm
				- tất cả có đúng hay không, thằng nào bị sai báo!!
			- Trong giang hồ, có những nhóm dev ngta viết sẵn cho mình những bộ thư viện/framework giúp ta so sánh cả đám EX và ACT 1 cách hiệu quả. Ứng với mỗi NNLT đều có bộ thư viện tương ứng để giúp dân DEV kiểm soát hàm mình viết có tốt với tất cả/đa số các tình huống dùng hàm hay không!! 
				- ==> Thư viện này giúp so sánh 1 loạt các EX với ACT tương ứng khi dùng hàm, sau đó kết luận chung dùm luôn!! Hàm ổn hay không. Mắt mình chỉ cần nhìn 2 tín hieuj: ỔN HAY KHÔNG, cho cả đám value cần so sánh!! 
				- thư viện này viết phải theo đúng quy tắc, không viết tự do kiểu như `jdbc.jar` mà PHẢI BIẾT ĐÚNG TRÌNH TỰ YÊU CẦU
					- **các thư viện mà để ta tự do sd hàm -> LIBRARY** 
					- **các thư viện mà ép ta viết theo 1 trình tự nào đó -> FRAMEWORK** (có khung nào đó, ta chỉ điền code vào những chỗ quy ước)
				- thư viện dùng để test các hàm của ta theo mô tả ở trên đgl `UNIT TEST FRAMEWORK`, với mỗi NNLT khác nhau có Unit Test Framework khác nhau
					- Java: JUnit, TestNG
					- C#: NUnit, MSUnit Test, xUnit...
					- JS:
					- Python
					- (search: unit test for ... để tìm framework của mỗi ngôn ngữ)
- dùng JUnit để test code, chưa quan tâm UI, mức UNIT TEST, DEV PHẢI LÀM VIỆC NÀY
- KẾT LUẬN 
	- UNIT TEST: DEV phải có trách nhiệm đảm bảo chất lượng của các hàm, các class do mình viết ra hàm nhận đầu vào, xử lí, ra kết quả ACT khớp với EX
		- đảm bảo chất lượng code = cách
			- kĩ thuật TRÂU BÒ: main(), log file, pop-up, window form, web page. DÙNG MẮT LUẬN ĐÚNG SAI TRÊN RẤT NHIỀU CASE - tình huống dùng hàm
			- kĩ thuật xịn xò: TEST AUTOMATION/ VIẾT CODE ĐỂ TEST CODE CHÍNH
				- dùng 1 framework/bộ thư viện để code đoạn ngắn
				- gọi hàm cần test, viết code này cho các case xài hàm, tình huống xài hàm
				- SAU ĐÓ KẾT LUẬN CHO CHO MỌI CASE 1 CÁCH TỰ ĐỘNG. MẮT CHỈ NHÌN 2 MÀU XANH ĐỎ CHO TẤT CẢ CÁC CASES
	- CÁCH LUẬN XANH ĐỎ/QUY ƯỚC XANH ĐỎ CỦA UNIT TEST NÓI CHUNG, JUNIT NÓI RIÊNG
		- liệt kê ra các case cần test - hàm cần test có những tình huống nào để dùng - các đầu vào là gì - liệt kê các đầu vào cần test cho hàm, tính trước các expected !!!
		- viết code để test code cho các case - gọi hàm với các đầu vào đã liệt kê
		- RUN
			- nếu TẤT CẢ các case đều ngon - EXPECTED == ACTUAL, 1 màu xanh cho tất cả (mệnh đề AND)
			- nếu có ÍT NHẤT 1 CASE TẠCH - EXPECTED != ACTUAL cho ít nhất 1 case - 1 màu đỏ cho tất cả
	- NGHỆ THUẬT ĐẢM BẢO CHẤT LƯỢNG CODE CỦA DÂN DEV, DÂN QC/TESTER
		- Cố gắng tưởng tượng, liệt kê các CASE sử dụng app, sử dụng hàm 1 cách bao quát bao sân tốt nhất các tình huống!! CẦN XANH CHO TẤT CẢ CÁC CASE ĐÃ LIỆT KÊ
		- Liệt kê thiếu sót case, chuyện lớn kiểu khác. Đã đưa ra các case, chúng phải xanh hết!!
	- ĐỎ (actual != expected): bao gồm 2 nguyên nhân
		- Mình code sai giá trị trả về - chiếm số nhiều
		- Mình kì vọng sai - tính bằng tay khi chưa có hàm/app bị sai

```
TEST CASE
	- một tình huống hàm/app/màn hình/tính năng được đưa vào sử dụng giả lập hành vi dùng của ai đó
	- LÀ 1 TÌNH HUỐNG SỬ DỤNG, DÙNG APP HAY DÙNG HÀM MÀ BAO GỒM
		- INPUT: data đầu vào cụ thể nào đó
		- OUTPUT: đầu ra ứng với xử lí của hàm/chức năng của app, dĩ nhiên dùng đầu vào để xử lý
		- KÌ VỌNG: mong hàm sẽ trả về value nào đó ứng với input ở trên 
		- so sánh để xem xét kết quả có như ý hay không
```

```
NOTE
ctrl + shift + t => chọn create new test => okela
```
```
có nhiều quy tắc đặt tên hàm kiểm thử
nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thử, tình huống dùng hàm theo kiểu thành công và thất bại


@Test phia hau truong chinh la public static void main() 
co nhieu @Test ung voi nhieu case khac nhau de kiem thu tinh giai thua
```
-----
## References
1.
