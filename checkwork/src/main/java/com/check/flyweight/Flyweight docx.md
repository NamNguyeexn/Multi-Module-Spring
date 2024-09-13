# Flyweight Docx 

- Flyweight xử lý các yêu cầu một cách lần lượt, có thể liên quan đến xử lý luồng. Flyweight sẽ duyệt các object,
được đánh dấu bằng key để tránh xử lý trùng lặp các yêu cầu, nhằm giảm tải bộ nhớ sử dụng. 

***Trong Spring***
- Flyweight được sử dụng ở các bean scope singleton khi cung cấp cho các bean 1 instance duy nhất cho phép gọi lại trong 
chương trình và tiết kiệm bộ nhớ
