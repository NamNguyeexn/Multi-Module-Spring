# Bridge Docx

***Bridge được sử dụng ở đâu ?***
- Bridge được sử dụng rất phổ biến trong cấu trúc MVC, khi thay đổi các tầng controller, service, view, sẽ không ảnh 
hưởng tới các tầng khác, khi mà đầu vào và đầu ra không thay đổi
- Chính việc tạo gọi API cũng là cách sử dụng bridge, khi mà ta có thể thay đổi nghiệp vụ của API trong khi không thay 
đổi cách gọi API đó

***Tại sao lại sử dụng bridge ?***
- Bridge sử dụng khi muốn tách biệt các phần nghiệp vụ, tăng tính mở rộng mà không làm thay đổi các phần cũ. 
- Bridge có thể hoạt động tốt với Abstract Factory. Bridge sẽ cấu hình chi tiết các lớp trừu tượng, còn abstract factory
sẽ đóng gói các lớp trừu tượng thành các họ và làm ẩn đi quy trình

