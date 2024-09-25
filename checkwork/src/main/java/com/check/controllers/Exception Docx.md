# Các lỗi và cách xử lý
***Lỗi Cannot commit JPA Exception :***
- Đặt debug ở hàm save của service và repository
- Vào tới hàm proceed dòng 696 của lớp /org/springframework/aop/framework/CglibAopProxy.class
- Hàm này sẽ trả về vị trí gây ra exception đó 
- Thường xảy ra ở các field của các lớp có kiểu dữ liệu int hoặc enum (không thể đặt NotBlank)

***Lỗi Failed making field 'java.time.LocalDateTime#date' accessible; either increase its visibility or 
write a custom TypeAdapter for its declaring type :***
- Đặt debug ở hàm return ở controller 
- Vào tới hàm invokeAndHandle dòng 55 của lớp /org/springframework/web/servlet/mvc/method/annotation
/ServletInvocableHandlerMethod.class
- Thường xảy ra khi các field có kiểu dữ liệu time in ra dạng string hoặc parse sang String

***Lỗi Failed making field 'java.time.Optional#' accessible; either increase its visibility or
write a custom TypeAdapter for its declaring type :***
- Đặt debug ở cuối của hàm service 
- Nhận thấy hàm service có thể hoàn thành 
- Thường xảy ra khi cố in ra object định dạng kiểu Optional< > 

***Lỗi GOT GLOBAL EXCEPTION :Could not resolve attribute '#' of 'com.check.models.#'***
- Xảy ra khi truyền biến vào query bị sai 
- Kiểm tra lại tên biến ở trong repository 

***Khi 1 object in ra output dạng proxy ?***
- Xảy ra khi ta cố gắng in ra 1 object nằm trong key field của 1 map nào đó 
- Ta cần kiểm tra lại kiểu dữ liệu đầu ra, thay đổi thứ tự hoặc đổi kiểu 