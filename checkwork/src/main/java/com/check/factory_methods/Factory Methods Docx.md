******Factory methods******
- Tạo 2 lớp con Online, Offline kế thừa interface Meeting 
- 2 lớp con Online và Offline có các thuộc tính chung và thuộc tính riêng nên có thể sử dụng FactoryMethod để khởi tạo, tăng khả năng tuỳ biến code.
- Bên trong MeetingFactoryImpl sẽ là nơi kế thừa các logic khởi tạo và tương tác với đối tượng meeting.
                                
***Phân biệt factory beans và factory methods :*** 
- Factory Bean
**Là 1 bean đặc biệt, có 1 instance, có các dependence, life cycle được quản lý bởi Spring Container**
- Factory methods:
**Là 1 các phương thức tĩnh trong 1 class, được sử dụng để tạo ra instance của 1 bean**