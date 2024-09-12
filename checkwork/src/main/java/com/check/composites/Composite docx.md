# Composite Docx 

- Composite ứng dụng phần lớn yếu tố đa hình của hướng đối tượng, mấu chốt là dùng 1 hàm để thực hiện bóc tách các tệp 
mà không cần quan tâm thứ tự tệp đó như thế nào 
- Cho phép xử lý các đối tượng theo hình cây một cách đồng nhất, khi thực hiện hàm, chương trình sẽ quét từ các lớp lớn 
và lớp bé cùng cấp bậc, thứ tự từ 4, tới 3 1 2, tới 1 1 1
VD:    4
    3      1      2
  1    1             1
- Khi gọi một phương thức trên một đối tượng cha, gồm nhiều lớp con, thì nó sẽ tự động thực hiện phương thức đó cho tất 
cả các lớp con của nó. 