***Abstract Factory Docx***
-
**Tại sao sử dụng Abstract Factory Docx**
- Có điểm chung khi sử dụng AF và FM, đó là tách biệt khách hàng (client) khỏi quy trình khởi tạo các đối tượng, tăng 
khả năng mở rộng cho chương trình.
- AF sử dụng khi cần *tạo 1 lớp quản lý 1 họ các factory methods có chung bản chất* (các fields, các thuộc tính) và có 
các bước khởi tạo khác nhau hoặc cần mở rộng thêm. Trong AF cũng có thể sử dụng FM 
- Khác so với FM sử dụng khi cần quản lý các lớp có chung các bước khởi tạo nhưng khác nhau về bản chất, tăng khả năng 
mở rộng và tăng tính đa dạng

**Tại sao không sử dụng 1 Factory Methods để quản lý các Factory Methods nhỏ hơn mà lại sử dụng Abstract Factory để quản
lý các Factory Methods ?**
- Khi sử dụng các Factory Methods lồng nhau, ta sẽ gặp khó khăn trong quá trình mở rộng phần mềm, giảm khả năng linh 
hoạt của code 
- Gây phức tạp code và khó bảo trì

**Trong Spring, Abstract Factory được sử dụng ở đâu ?**
- Sử dụng trong BeanFactory. BeanFactory là 1 dạng AF. Nó cung cấp phương thức getBean() để lấy các bean được cấu hình 
trong IoC
- Sử dụng trong ApplicationContext. Hỗ trợ cho events và đăng ký listener
- Sử dụng trong DataSourceUtils. Cung cấp và trả lại các kết nối DB.
- Sử dụng trong PlatformTransactionManager. Cung cấp các phương thức để commit, rollback một transaction.
