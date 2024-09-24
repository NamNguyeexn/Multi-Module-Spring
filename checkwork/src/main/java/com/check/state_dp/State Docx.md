# State Docx

***- Khi nào ta sử dụng state?***
- Khi 1 đối tượng có nhiều trạng thái liên kết tới nhau, ta có thể sử dụng một lớp trừu tượng để quản lý các trạng thái 
và liên kết chúng với nhau 
- Giúp quản lý các trạng thái tốt hơn, quản lý các logic cho từng trạng thái tốt hơn 

***- State có phần giống với factory***
- State và Factory đều sử dụng một lớp trừu tượng để quản lý nhiều lớp con phụ thuộc 
- State tập trung vào hành vi của đối tượng (behavior), sử dụng 1 interface để định nghĩa các method, liên kết các chuyển 
trạng thái của đối tượng 
- Factory tập trung vào khởi tạo đối tượng (creational), sử dụng 1 interface để định nghĩa phương thức khởi tạo của các 
lớp con 