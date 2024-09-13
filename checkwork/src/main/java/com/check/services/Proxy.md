# Proxy docx

***Đặc trưng của proxy***
- Quản lý được quyền truy cập đối tượng từ các nguồn, sử dụng để mở rộng 1 chức năng mà không 
làm ảnh hưởng tới các chức năng cũ. 

***So sánh proxy với adapter***
- Khác so với adapter thực hiện các chuyển đổi từ interface này qua interface khác, **proxy thực hiện thay đổi trước và 
sau khi gọi tới đối tượng đó**. Proxy sẽ có **interface giống với đối tượng gốc (để xử lý trước và sau khi gọi tới đối tượng 
mà không làm thay đổi code cũ)** còn Adapter sẽ có interface khác với đối tượng gốc (sử dụng để chuyển đối qua lại giữa
các đối tượng)
