Created: 202506062311
Tags: 

## Giải ngố web api
### Định nghĩa web api
- web api là gì?
	- nôm na:  là 1 hàm/ method (phải trả về 1 kq nào đó) mà ta gọi nó, chạm đến nó qua 1 cái URL
		- gọi web api, dùng web api là phải gọi nó qua 1 url
		- gọi hàm truyền thống (trong java)
			```
			import package...tên-class;
			khai báo biến object = new tên-class(...);
			biến object.goijtenmethod() -> nhận giá trị trả về
			```
		- gọi web api
			```
			đưa chuỗi url vào 1 object nào đó
			nhận giá trị trả về khi url được thực thi
				giá trị trả về THƯỜNG LÀ DATA THÔ dạng: XML, JSON
			```

- ai dùng web-api??
	```
	có 2 loại url
	- url quen thuộc: https://abc.com
		url này sẽ được dùng qua trình duyệt
		đc end-user dùng -> lướt web
	- url api - web api: https:/...
		dành cho lập trình viên dùng, tức đưa url vào code (ko phải trình duyệt)
		lấy data thô trả về trong code - json 
			-> ta viết nốt phần render ra trang web, ra app androi, ios
		url này đặc biệt, ko trả về trang web đẹp - MÀ TRẢ VỀ DATA THÔ
		gọi tên khác là: END-POINT
	```

- ví dụ

- khi nào dùng? tại sao cần web api?

### Để có được web api dùng, ta làm như thế nào, cần gì để tạo ra đc 1 web api?
- vì có url để gọi web api -> có thể xem web api như 1 web đặc biệt dành riêng cho dân dev 
	-> dân dev dùng web api app để tạo ra app cho user thường dùng
	-> cần 1 web server để nhận request/http request và reponse/phản hồi: IIS, Glasfish, JBoss, WebSphere, Apache HTTP Server, Nginx, Tomcat
- cần tạo 1 web app, thay vì trả về các trang web đẹp, ta trả về data thô dạng json
	- 1 web làm gồm 2 phần đc luôn
		- trang web đẹp cho user thường dùng
		- web api cung cấp các hàm CRUD data
	- ta phải viết code cho phần url gọi từ xa trả về json
		-> cần có các bộ thư viện/framework để nhận request/trả response dạng xml/json: dùng RESTful API/ REST API (bộ chuẩn quy ước, nhận trả data) và có phiên bản kế bên JERSEY (dependency ta dùng để viết API)
- cần database chứa data, sẽ được thao tác CRUD bởi các web api

#### Cài đặt cấu hình TOMCAT trên server/hosting/máy ta thuê để phục vụ cộng đồng dùng web app do ta viết, xài api của ta
- xài Tomcat 10.x
	- khác tomcat 8.x ở chỗ: package lõi về xử lý request/response đã đổi tên từ `import javax.`(java ee) thành `import jakarta.` (jakarta ee)
	- `EE` : enterprise edition (phiên bản java, java dành cho các doanh nghiệp)
- https://tomcat.apache.org/download-10.cgi : 64bit.zip 
- giải nén
- `bin` : 
	- win mở: `startup.bat`, `shutdown.bat` (batch)
	- macos mở: `startup.sh`, `shutdown.sh` 
	- để khởi động tomcat
- `conf`
	- `server.xml`: chứa thông tin của 8080
	- `tomcat-users.xml`: quyền admin quản trị
- `logs`: ghi lại nhật kí hoạt động 
- `webapps` : xả web app của mình vào đây, deploy là vào đây

#### Giải ngố về PORT/cổng trong app
- 

-----
## References
1.
