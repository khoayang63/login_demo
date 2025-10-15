<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Trang Chủ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            /* 1. Reset và Căn giữa tổng thể */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f9; /* Màu nền nhẹ */
                text-align: center; /* Căn giữa nội dung văn bản */
            }

            /* 2. Container chính */
            .main-container {
                width: 400px;
                margin: 100px auto; /* Căn giữa khối theo chiều ngang, thêm lề trên */
                padding: 30px;
                background-color: #fff;
                border-radius: 8px; /* Bo góc */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Thêm đổ bóng */
            }
            
            /* 3. Định dạng Liên kết */
            .link-group {
                margin-top: 20px;
                display: flex; /* Dùng Flexbox để sắp xếp các liên kết */
                justify-content: space-around; /* Chia đều khoảng cách */
            }
            
            .link-group a {
                text-decoration: none; /* Bỏ gạch chân */
                color: #007bff; /* Màu xanh nổi bật */
                padding: 8px 15px;
                border: 1px solid #007bff;
                border-radius: 5px;
                transition: background-color 0.3s;
            }

            .link-group a:hover {
                background-color: #0056b3;
                color: white;
            }
        </style>
    </head>
    <body>
        
        <div class="main-container">
            
            <h2>Welcome, <span style="color: #28a745;">${sessionScope.user.username}</span>!</h2>
            
            <p>Đây là khu vực dành cho thành viên.</p>
            
            <div class="link-group">
                <a href="./ProfileServlet">Xem Hồ sơ (My Profile)</a>
                <a href="./LogoutServlet">Đăng xuất (Log out)</a>
            </div>
            
        </div>
        
    </body>
</html>