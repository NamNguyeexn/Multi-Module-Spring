#  Builder Docx
**Builder sử dụng ở đâu ?**
- Thay vì sử dụng nhiều constructor đa hình - mỗi lần gọi tới lớp thì hàm đó sẽ được quét qua một lần - thì ta sẽ tạo 1
  lớp builder để *tạo các hàm khởi tạo và các hàm validate dữ liệu, xử lý dữ liệu trước khi truy vấn*

**Builder khác gì so với Factory Methods?**
- Factory Methods cung cấp các phương thức khởi tạo đối tượng và trả về một đối tượng cụ thể trong 1 tập các đối tượng
  có chung các bước khởi tạo
- Builder *cung cấp các bước khởi tạo* cho 1 đối tượng cụ thể, trong đó các bước chi tiết được thực hiện trong builder, có
  thể mở rộng thêm nhiều loại builder ứng với nhiều loại trong đa hình của đối tượng.

**Builder khác gì so với tiền xử lý dữ liệu ?**
- Builder gọi ra trước khi khởi tạo 1 đối tượng. Ta có thể gọi ra tiền xử lý đối tượng trong Builder

- Annotation @Builder.Default chỉ hoạt động với builder().build()