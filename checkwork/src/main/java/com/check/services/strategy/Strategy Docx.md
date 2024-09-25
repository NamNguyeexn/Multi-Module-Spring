# Strategy Docx

***- Khi nào sử dụng strategy ?***
- Khi muốn tách biệt phần thuật toán với phần khởi tạo lớp, ta sử dụng strategy
- Strategy là sử dụng 1 interface để quản lý các thuật toán , kết hợp với state để liên kết các trạng thái của đối tượng
sẽ tạo thành 1 khối logic có khả năng mở rộng tốt

***- Strategy và các pattern khác***
- Strategy khá giống Bridge, State, Adapter khi sử dụng tính trừu tượng và khả năng mở rộng của nó 
- Strategy và Command khá giống nhau do đều tác động tới 1 đối tượng bằng các hành động thực hiện qua 1 lớp interface. 
Command có thể chuyển hoá các trường của lớp khác thành trường của đối tượng và sử dụng hàng đợi, ngăn xếp để lưu trữ.
Còn Strategy là sự thay đổi giữa các thuật toán của hành động của đối tượng, hoạt động trong đối tượng.