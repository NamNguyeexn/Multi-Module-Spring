# Iterator Docx

*Sử dụng ở com/check/DTO/iterator và com/check/iterators*

***Khi nào thì sử dụng iterator ?***
- Khi muốn duyệt 1 danh sách mà không cần biết kiểu của nó, thay vì sử dụng những vòng for, ta sẽ sử dụng các node để 
duyệt và lọc các phần tử trong danh sách

***Tại sao lại sử dụng iterator thay vì sử dụng các vòng lặp thông thường ?***
- Vì khi sử dụng iterator, ta có thể kiểm soát các phần tử duyệt qua tốt hơn, thêm các logic và tiêm phụ thuộc tối ưu 
hơn
- Iterator cho phép ta thực hiện thêm và loại bỏ phần tử trong khi duyệt, sử dụng tính trừu tượng để duyệt các phần tử 
mà không ảnh hưởng tới cách sử dụng của danh sách sau khi duyệt, cho phép sử dụng nhiều cách duyệt khác nhau.
