# Proxy docx

***Đặc trưng của proxy***
- Quản lý được quyền truy cập đối tượng từ các nguồn, sử dụng để mở rộng 1 chức năng mà không 
làm ảnh hưởng tới các chức năng cũ. 
- Proxy quản lý quyền truy cập nên sử dụng khá nhiều trong xử lý luồng

***So sánh proxy với adapter***
- Khác so với adapter thực hiện các chuyển đổi từ interface này qua interface khác, **proxy thực hiện thay đổi trước và 
sau khi gọi tới đối tượng đó**. Proxy sẽ có **interface giống với đối tượng gốc (để xử lý trước và sau khi gọi tới đối 
tượng mà không làm thay đổi code cũ)** còn Adapter sẽ có interface khác với đối tượng gốc (sử dụng để chuyển đối qua lại
giữa các đối tượng)

***Proxy sử dụng ở đâu trong Spring***
- Proxy sử dụng rất nhiều trong Spring, Proxy sẽ bọc 1 bean lại, khiến cho bean khi in ra sẽ có dạng 
Bean_Name$Random_Number
- Annotation Transaction là sử dụng proxy, nhằm cam kết và huỷ yêu cầu khi thực hiện không thành công 
- Proxy sử dụng trong xử lý luồng, khi đánh dấu bằng @Async, spring sẽ nhận định đó là 1 method cần phải bọc bằng proxy 
để xử lý nội hàm. Nhưng ta cần phải cấu hình lại số luồng cho phép hoạt động trong config. Và @Transactional cũng là 1 
dạng async. Khi sử dụng @EnableAsync(proxyTargetClass = true), ta sẽ bọc không chỉ các đối tượng được đánh dấu @Async 
mà còn cả các đối tượng @Transactional, bằng proxy.
