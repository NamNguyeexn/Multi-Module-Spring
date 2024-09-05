# Abstract Factory

**Khi nào thì sử dụng AFactory ?**
- Khi cần quản lý các factory có chung đặc điểm, quản lý 1 họ các factory 
- Khi cần khởi tạo các lớp có chung thuộc tính với nhau

**Tại sao không sử dụng 1 factory này để quản lý các factory khác mà sử dụng AFactory ?**
- Vì Factory sử dụng để chỉ định khởi tạo các lớp (class), nếu sử dụng để chỉ định khởi tạo các interface (factory) thì 
sẽ khó quản lý
- Sự khác biệt chủ yếu của việc sử dụng AFactory và Factory là : ***Factory sử dụng để khởi tạo các hàm phương thức 
(method)***, còn ***Abstract Factory sử dụng để khởi tạo các lớp***

- Khi sử dụng Abstract Factory cần phải chỉ định ra lớp cần khởi tạo 
