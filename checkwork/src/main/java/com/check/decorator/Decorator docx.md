# Decorator Docx

- Decorator sử dụng khi muốn mở rộng 1 lớp có sẵn, bằng cách bọc nó bằng nhiều lớp khác, nhằm tránh thay đổi lớp cũ.
- Mấu chốt của decorator là việc sử dụng abstract class - không tạo instance của lớp đó mà cho các lớp con kế thừa. 

**Trong spring, decorator được sử dụng ở các vị trí như sau** (kết hợp với proxy)
- Ở trong Spring security, là các lớp filter cho các lớp yêu cầu HTTP
- Ở trong các annotation, việc bọc các annotation là việc sử dụng decorator nhằm mở rộng mà không cần thay đổi mã nguồn
- BeanPostProcessor cũng được coi là decorator khi bọc các bean và cho phép mở rộng các bean
- Spring Interceptor, là các tiền xử lý và hậu xử lý, sử dụng HttpRequest và HttpResponse để cho phép đón nhận yêu cầu 
và xử lý yêu cầu, là một phần của Spring AOP 
