    CREATE TABLE employee (
        -- Cột ID (Khóa chính, tự động tăng)
        id INT(3) NOT NULL AUTO_INCREMENT, 
    
        -- Các cột Thông tin Cá nhân
        first_name VARCHAR(20) DEFAULT NULL,
        last_name VARCHAR(20) DEFAULT NULL,
        
        -- Các cột Đăng nhập (Dùng cho xác thực)
        username VARCHAR(250) NOT NULL UNIQUE, 
        password VARCHAR(20) NOT NULL,
        
        -- Các cột Liên hệ
        address VARCHAR(45) DEFAULT NULL,
        contact VARCHAR(45) DEFAULT NULL, 
        
        -- Khai báo Khóa chính
        PRIMARY KEY (id) 
    
    ) ENGINE=InnoDB 
      DEFAULT CHARSET=utf8mb4 
      COLLATE=utf8mb4_0900_ai_ci;
