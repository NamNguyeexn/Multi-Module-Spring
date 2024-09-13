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

***Tại sao sử dụng Factory method (1 interface) thay vì sử dụng abstract class***
- Vì Factory method là định nghĩa các phương thức, mở rộng các phương thức, trong khi abstract class là khởi tạo các lớp
