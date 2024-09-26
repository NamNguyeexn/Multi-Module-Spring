# Template Method Docx

***- Khi nào sử dụng Template Method ?***
- Khi cần tách biệt các lớp xử lý logic ra khỏi lớp service, sắp xếp lại chúng và quyết định cách khởi tạo chúng, có thể
kết hợp với factory method để tạo ra các đối tượng phù hợp.
- Khác với Chain Of Responsibility - cũng tách các xử lý ra khỏi lớp service nhưng xâu chuỗi thành 1 chuỗi các hành động, 
Chain có khả năng mở rộng tốt hơn, kiểm soát các các node tốt hơn. Template Method đặc trưng ở tính kế thừa, nó có khả 
năng giới hạn các hàm mà lớp con có thể ghi đè