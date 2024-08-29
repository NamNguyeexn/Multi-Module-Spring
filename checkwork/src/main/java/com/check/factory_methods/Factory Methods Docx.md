# Factory methods
- Tạo 2 lớp con Online, Offline kế thừa interface Meeting 
- 2 lớp con Online và Offline có các thuộc tính chung và thuộc tính riêng nên có thể sử dụng FactoryMethod để khởi tạo, tăng khả năng tuỳ biến code.
- Bên trong MeetingFactoryImpl sẽ là nơi kế thừa các logic khởi tạo và tương tác với đối tượng meeting.
                                
***Phân biệt factory beans và factory methods :*** 
- Factory Bean
**Là 1 bean đặc biệt, có 1 instance, có các dependence, life cycle được quản lý bởi Spring Container, sử dụng để tạo các
instance trong bean**
- Factory methods:
**Là 1 các phương thức tĩnh trong 1 class, được sử dụng để ghi đè, mở rộng các phương thức trong 1 class. Trong factory 
bean cũng sử dụng factory methods để khởi tạo bean, ghi đè các hàm**

***Lợi ích việc sử dụng Factory Methods:***
- Tăng khả năng mở rộng cho không chỉ các hàm nghiệp vụ, các hàm config mà còn cả các hàm trong thư viện của spring.

***Nhược điểm***
- Khó kiểm soát code nếu như có quá nhiều hàm cần mở rộng (hiệu năng giảm) và code trở nên phức tạp hơn 