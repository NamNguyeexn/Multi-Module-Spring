# Mediator Doc

***-Khi nào thì sử dụng mediator pattern.***
- Khi cần mở rộng lớp nhưng lớp đó có quá nhiều luên kết chặt 
- Sử dụng giống như facade.

***Trong Spring***
- Cơ chế Dependency Injection được sử dụng khá thuận tiện nên việc sử dụng Mediator có thể không cần thiết
- Chính mô hình MVC cũng sử dụng Mediator nhưng tiêm phụ thuộc lại sử dụng rất thuận tiện trong MVC