# Observer docx

***Khi nào thì sử dụng observer ?***
- Khi cần thông báo tới các lớp quan sát rằng lớp cha của nó có sự thay đổi
- Các lớp con có chung các hàm kế thừa từ lớp cha
- Observer được cấu hình từ các lớp ngoài, có sự khác biệt so với lớp con ở trong composite 

***Khi nào không thể sử dụng observer ?***
- khi module đơn giản và không phức tạp, việc sử dụng observer sẽ làm thay đổi quy trình hoạt động và
làm code thêm dài hơn.

***Observer và Composite ?***
- Composite cấu trúc theo sơ đồ hình cây, môĩ nhánh ta đều không cần biết có bao nhiêum  node, bao nhiêu nhánh, nhunng 
Observer cấu trúc theo sơ đồ hình cây chỉ có 1 nhánh và có nhiều lá con. Chỉ cần thực hiện 1 hàm và nó sẽ thông báo tới 
các nhánh con.