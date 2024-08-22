***Factory methods***
- Tạo 2 lớp con Online, Offline kế thừa interface Meeting 
- 2 lớp con Online và Offline có các thuộc tính chung và thuộc tính riêng nên có thể sử dụng FactoryMethod để khởi tạo, tăng khả năng tuỳ biến code.
- Bên trong MeetingFactoryImpl sẽ là nơi kế thừa các logic khởi tạo và tương tác với đối tượng meeting.
- 