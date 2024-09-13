# Chain Of Responsibility 

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
