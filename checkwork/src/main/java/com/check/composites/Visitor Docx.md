# Visitor Docx

***- Khi nào sử dụng visitor ?***
- Khi ta muốn mở rộng 1 module, bằng cách thêm các hàm visitor, sử dụng tính đa hình, ở trong các lớp đối tượng và các 
lớp dịch vụ

***- Tại sao sử dụng tính đa hình trong visitor ?***
- Để phù hợp với việc mở rộng các hàm, ta không cần quan tâm tới cách chọn hàm để sử dụng mà tính đa hình sẽ hỗ trợ. 

***- So sánh visitor và facade***
- Visitor là cách sử dụng tính đa hình để mở rộng 1 module, sử dụng trong cả các lớp đối tượng và các hàm 
- Facade là cách sử dụng 1 interface mở rộng 1 module bằng cách mở rộng các lớp dịch vụ và cung cấp hàm qua interface để
sử dụng.
