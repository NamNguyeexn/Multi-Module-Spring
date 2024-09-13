# Adapter Docx

***Khi nào thì sử dụng adapter ?***
- Khi cần mở rộng 1 service có sẵn từ trước đó 

***Tại sao không viết 1 class mới implement class trước đó để mở rộng các service ?***
- Bằng cách implement service cũ, ta sẽ truyền tham số của service cũ vào trong adapter mới, kèm theo 1 service mới. Ta 
có thể thực hiện xử lý dữ liệu trước khi truyền vào trong class mới.
- Ưu điểm đầu tiên của adapter đó là **không gây ra conflict khi cùng mở rộng từ 1 interface**.

***Tại sao không tạo 1 service riêng biệt và truyền tham số kết quả từ service cũ ?***
- Nếu ta tạo 1 service riêng biệt, ta sẽ cần lưu ý các tham số kết quả từ service cũ, và có thể sẽ cần mở rộng service 
cũ để cung cấp các tham số trong việc tạo service mới. Nhưng nếu sử dụng Adapter thì ta có thể **tạo service mới mà không
cần quan tâm đầu ra của service cũ**. Ta cũng có thể **tái sử dụng service cũ**, **linh hoạt thay đổi service mới mà không cần 
chỉnh sửa service cũ**
- Nhưng nếu ta tạo 1 adapter mới, có thể vi phạm quy tắc Single Response, và service cũ có thể can thiệp vào service mới
gây phức tạp code, khó quản lý code.
- Ta cần cân nhắc, **chỉ khi service mới không quá phức tạp**, không tái sử dụng nhiều lần, thì khi đó mới nên tạo adapter

