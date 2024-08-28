***Docx Exception***
-
- Khi gặp lỗi access denied hãy kiểm tra lại pom của common và các phụ thuộc trước, vì khi đặt debug vào 
@SpringApplication, Spring chưa hề quét tới đó => lỗi do thiếu phụ thuộc trong file pom.xml của common, mặc dù file pom 
build thành công.
- Và nhớ rằng hãy build, package lại common module sau khi thực hiện các thay đổi trên module này