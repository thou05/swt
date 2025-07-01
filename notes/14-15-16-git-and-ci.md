Created: 202506182345

Tags: 

## GitHub
- Linus Torvalds - tác giả 
- Git: kĩ thuật, công nghệ phần mềm quản lí source code - open source
- GitHub, GitLab, BitBucket cung cấp giải pháp lưu trữ, quản lý code online
	- miễn phí và có trả tiền theo dung lượng lưu trữ, số member tham gia vào dự án có lưu code ở trên 3 nền tảng này
- Quản lí code
	- lưu trữ code
	- share code cho mọi người cùng tham gia sửa
	- tracking history chỉnh sửa code 
		- quản lí các phiên bản code/version code
		- quản lí sự thay đổi của các dòng code
		- ai thêm/sửa/xóa code, thêm ngày giờ nào, dòng code nào?
	- undo lại code kể từ ngày đầu tiên, đoạn thay đổi lưng chừng
	- ae đè code lẫn nhau, do sơ ý, do cùng làm trên 1 project, 1 tập tin, xóa lộn code của nhau, cả 2 cùng update trên 1 tập tin -> CONFLICT
	- đồng bộ code của ae khác, merge code của ae khác
	- copy/paste project để thí nghiệm thử, sau đó đc thì xài, ko thì xóa, trước giờ làm thủ công ở local/máy mình

	=> TẤT CẢ NHỮNG VẤN ĐỀ TRÊN, GIT LO ĐƯỢC HẾT!!

	- toàn bộ những vấn đề nêu trên cần tool nào đó để quản lí thì tuyệt vời cho dân DEV tiết kiệm cực nhiều công sức cho việc quản lý sự thay đổi trong code khi làm việc teamwork => các tool làm việc này gọi chung là
		- VCS: Version Control System
		- SCM: Source Code Management System
	- tool công nghệ cũ: SVN (Subversion), Source Safe
	- tool công nghệ mới: Git và phiên bản implement để xài: GitHub (Microsoft), GitLab, BitBucket
### Mô hình hoạt động Git/GitHub/...
```
Máy dev (local workspace)     GitHub/GitLab server (cloud, trên mạng)...

		--------> đẩy code lên server - check-in: thuật ngữ chung SCM
									push: thuật ngữ riêng cho Git
		down code về <--------- check-out: thuật ngữ chung SCM
								git clone
								git pull  : lệnh của git

Máy dev khác (local workspace)
		y chang trên

```
- Code để ở trên Server GitHub/GitLab sẽ đc đặt trong 1 folder - chính là tên folder chứa code ở local. Folder chứa code/project/solution trên server GitHub đgl REPOSITORY/REPO - KHO CODE.
	- Mỗi project tương ứng 1 kho
	- Lưu ý: TÊN KHO NÊN (RẤT NÊN) TRÙNG 100% CẢ HOA THƯỜNG VỚI THU MỤC CHỨA PROJECT Ở LOCAL

### CÁCH CHƠI GITHUB
#### 1. Tạo trên server 1 kho trùng trên (100% hoa thường với tên project ở local)
- public/private tùy chọn
- mới dùng thì k nên tick vào README, gitignore để tránh confic

```
echo "#..." >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://...
git push -u origin main
```

#### 2. Cài tool ở local/máy dev để đồng bộ code lên server
- `git scm download, cài tool`
- tool này thực ra là 1 đống các câu lệnh gõ ở cmd/terminal, các câu lệnh bắt đầu bằng từ `git <kèm tham số phía sau>` 

- có đến 3 loại tool để đồng bộ code lên server/lên kho ở xa/remote repository
	- tool 1: cmd/terminal/gõ lệnh git kèm tham số (nhớ cài git scm trước) -> pro, user guide trên mạng hầu hết cách 1
	- tool 2: các IDE, Code Editor đã có hỗ trợ sẵn bộ lệnh, hoặc cài thêm plugin, dùng GUI chuột để nhấn nút bấm lệnh
	- tool 3: tool rời của các hãng khác nhau, thường là GUI cho dễ dùng cho người lười nhớ để gõ lệnh: git desktop, sourcetree...

#### 3. Setup 1 số thông số hệ thống, 1 số thông số dự án trc khi đồng bộ code
- Setup 1 số thông số của dự án - project của mình
	- Cái thư mục chứa code trên HDD/SSD có nhiều thư mục của riêng IDE và những thư mục chứa code do mình gõ - `src\` quan trọng nhất
		```
		ANT:
			PROJECT FOLDER
				src\  -> cực kì quan trọng, code mình gõ, cất lên server
				build\  .class      |   => từ src sẽ ra 2 mục này, ở lại local, k cần lên server tốn đĩa
				dist\   .war .jar   |

		MAVEN
			src\
			target\  .class .war .jar  => ở lại k cần lên
		```
	- trong thư mục dự án của mình có ng đi lên server, kẻ thì ở lại local, ko đồng bộ lên ->  `git ignore` là kĩ thuật dạy cho lệnh GIT biết đứa nào lên server, đứa nào ở nhà  
	- ta tạo trong thư mục chứa code ở local (sẽ đc đồng bộ lên server ở xa) 1 tập tin có tên là `.gitignore` chứa danh sách các thư mục hay tập tin cần ở lại local
		- nếu ko có tập tin này, toàn bộ folder chứa code lên server
		- để tạo tập tin này nhanh, ta vào website [gitignore.io]( https://www.toptal.com/developers/gitignore/), gõ tool IDE (ecilipse, intellij, vscode) mà bạn dùng, hệ thống tự generate tập tin ignore cho

#### 4. CÁC LỆNH GIT CẦN LÀM ĐỂ ĐƯA CODE LÊN SERVER Ở XA (GITHUB, GITLAB, BITBUCKET...)
- 4.1 Nhóm lệnh chỉ làm 1 lần duy nhất cho 1 máy lần đầu tiên chơi với Git
	- Sẽ làm lại các lệnh này nếu cài lại Windows, hoặc đổi username/pass của GitHub...
	```
	git config --global user.name <tên-url-github>
	git config --global user.email <email-dung-dki-github>

	pass sẽ đc hỏi khi đưa code lên, Windows tự remember
	sau này ko cần làm này 2 lệnh này, trừ khi đổi pass, url github, cài lại win
	```

```
lệnh của linux
	pwd
	dir
	dir -a
	ls
	ls -a
	ls -la
	clear
```

- 4.2 Nhóm lệnh dùng cho mỗi project ở local lần đầu tiên chuẩn bị lên server
	- leader, trưởng nhóm làm việc này trc
	- 1 lần cho 1 project/lặp lại cho project mới khác
	```
	git init  
		=> khởi động cái thư mục code ở local, cbi sẵn sàng đồng bộ lên server
			tự tạo ra 1 folder .git\ ẩn, chứa nhật kí thay đổi code ở local
			cấm tuyệt đối xóa, sửa thư mục này, xem thì đc

	git add .
		lệnh này báo với git rằng tao cần upload tất cả các tập tin/folder trong local lên server
		lên server hết, kể cả có dấu chấm . 
		dĩ nhiên ko lên những thằng có tên trong gitignore
		nếu lần đầu tiên thì phải dùng cái này

	git add *
		lệnh này báo với git rằng tao cần upload tất cả các tập tin/folder trong local lên server
		để lại những thằng có trong .gitignore, và những thằng trong tên gọi có dấu . ở đầu tên
		những tập tin tên gọi xuất phát là dấu chấm thì ở lại local luôn
		cái này sẽ k push .gitignore lên luôn


	git commit -m "message-cho-team-biet-minh-update-gi-trong-kho-chung-ten-server"
		lưu ý khi đi thực tập
			mỗi lần đưa code lên server phải ghi rõ lí do
			thường là câu ngắn tóm tắt lại lần mình update code, cấm ghi "ahihi"

	git branch -M main
		báo với git vào room-phòng chính chứa projet ở local lấy code chuẩn bị đưa lên server

	git remote add origin https://...
		báo với git rằng kho ở xa tên là gì, url đâu

	git push -u origin main
		cú chót lên đường, sẽ bị hỏi pass lần đầu
	```

	- Kho local đc đồng bộ lên kho từ xa - sau đó ta invite team member vào edit code -> team phải clone code về thành 1 folder trên local t chang máy leader
	- hoặc đưa url của kho cho bá tánh download code (.zip)

- 4.3 NHÓM 3 LÂU LỆNH HUYỀN THOẠI
	- dùng ngày này qua tháng khác do cta thêm xóa sửa ccode theo tiến trình làm dự án
	- dù là sếp, hay lính, cũng chỉ 3 lệnh làm miết trên kho đã đc đồng bộ
	```
	git add *
	git commit -m "sua cai gi vay"
	git push
	```

- `.md` : là markdown, 1 loại ngôn ngữ đánh dấu đơn giản, gọn nhẹ hơn html dùng cho 1 số việc nhẹ nhàng, ko dùng làm FE
	- VS Code, hay các tool IDE đều hiểu .md hiển thị the màu sắc tag, dữ liệu
	- html: markup language
	- xml: markup language
	- md: mark down
	- mark là đánh dấu


## NHẬP MÔN CI - CONTINUOUS INTEGRATION
- Là kĩ thuật đảm bảo chất lượng code của cả TEAM, ko riêng của cá nhân. Vì code của dự án là do sự đóng góp của nhiều team member, 1 dự án có nhiều dev cùng code
- Mỗi dev phải đảm bảo code mình ngon và phải đảm bảo code mình cùng chung sống với code bạn trong cùng project cũng ngon, cả dự án code phải ngon, cả dự án phải màu XANH mới ổn => XANH trên tất cả code của ae dev team gom về server => CODE TRÊN SERVER PHẢI XANH CHO TẤT CẢ
- CI là kĩ thuật gom code của ae lên server phải đảm bảo XANH cho tất cả khi gom (INTEGRATION - TÍCH HỢP)
	
	việc gom này diễn ra rất nhiều lần do code kéo dài thời gian cả tháng, cả năm, n người cùng làm -> việc kiểm tra XANH cho tất cả phải làm LIÊN TỤC LIÊN TỤC LIÊN TỤC
	
	-> TÍCH HỢP LIÊN TỤC XUẤT HIỆN: TIẾN TRÌNH KIỂM TRA CODE TOÀN DỰ ÁN LÀ MÀU XANH DIỄN RA LIÊN TỤC LIÊN TỤC KHI SERVER ĐƯỢC AI ĐÓ DEV NÀO ĐÓ CHỈNH SỬA CODE
	
	nói cách khác: mỗi lần ai sửa code/update code trên server, MÀU XANH cho tất cả đc chạy ngay, kích hoạt ngay tiến trình kiểm tra XANH khi code server bị thay đổi


- Muốn làm CI cần
	- source code của các ae(dự án mà)
	- server chứa code để gom code
	- Unit Test cho toàn dự án để có XANH ĐỎ
	- kích hoạt quy trình chạy unit test khi có bất kì gã dev nào sửa code trên server
	- notify đc XANH ĐỎ tới team member khi có problem ĐỎ
	- tự động việc làm ở trên, ko chạy bằng cơm => ta cấu hình server và những thứ liên quan để tạo quy trình XANH ĐỎ 1 cách tự động 
	- =>Rẽ nhánh đi làm: CI/CD/DEVOPS ko code app, code cho quy trình XANH ĐỎ, deploy lên server  - khai báo các hành động để từ code -> chất lượng code -> app -> lên server luôn


-----
## References
1.
