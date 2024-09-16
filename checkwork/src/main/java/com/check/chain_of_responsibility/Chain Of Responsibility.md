# Chain Of Responsibility 

- checkwork/src/main/java/com/check/services/handlers

***Khi nào sử dụng CoR ?***
- CoR được sử dụng khi cần thực hiện 1 chuỗi các xử lý. Bình thường ta sẽ lồng nhiều vòng if else để xử lý, nhưng khi 
cần mở rộng service đó, ta sẽ cẩn thay đổi rất nhiều logic bên trong vòng if else, gây phức tạp. Thay vào đó ta sẽ sử 
dụng tính mở rộng của interface và abstract class.
- Ta có thể tách biệt các xử lý, mỗi khi một handle này được lọc qua, nó sẽ quyết định có xử lý tiếp hay đưa ra kết quả 
ngay.
- Làm tăng tính mở rộng cho các xử lý service 
- Giúp quản lý tốt hơn, linh hoạt hơn, tăng khả năng kiểm thử cho service đó 
- Tăng tính đồng nhất trong quản lý, khi nhiều handle cùng kế thừa 1 interface, trong đó ta vẫn có thể tạo thêm các
xử lý đặc trưng tại lớp đó, ngoài các hàm kế thừa ra 

***Khó khăn khi sử dụng CoR***
- Khi sử dụng CoR với các service chưa đủ phức tạp, ta sẽ gặp khó khăn trong việc xâu chuỗi luồng data của các service 
khi mà các service có đầu vào và đầu ra khác nhau, và đầu ra của logic này là đầu vào của service sau. Khi ấy ta cần tìm 
cách tối ưu đầu vào và đầu ra của các logic. Có rất nhiều hướng giải quyết, trong đó ta có thể sử dụng decorator hoặc 
strategy.

***Trong Spring CoR được sử dụng ở đâu?***
- Khá là giống so với Decorator nên CoR được sử dụng ở những nơi như sau 
- Trong các lớp filter của spring security
- Trong các lớp tiền xử lý, hậu xử lý của spring aop 
- Trong các lớp exception handle, ta có thể mở rộng và sử dụng các annotation 
