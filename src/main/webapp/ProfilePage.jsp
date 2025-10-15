<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="info.user_info" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Thông tin Chi tiết Người dùng</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f7f6; /* Nền nhẹ */
                text-align: center;
                margin: 0;
            }
            h1 {
                margin-top: 50px;
                color: #333;
            }
            
            /* CONTAINER CHÍNH CHO PROFILE */
            .profile-box {
                width: 450px;
                margin: 30px auto; /* Căn giữa */
                padding: 30px;
                background-color: #ffffff;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Đổ bóng nhẹ */
                text-align: left; /* Đặt lại căn trái cho nội dung chi tiết */
            }
            
            /* ĐỊNH DẠNG TỪNG DÒNG THÔNG TIN */
            .profile-info {
                display: flex; /* Dùng flexbox để căn chỉnh nhãn và giá trị */
                margin-bottom: 12px;
                padding-bottom: 5px;
                border-bottom: 1px dashed #eee; /* Đường kẻ mờ phân cách */
            }
            .profile-info strong {
                flex: 0 0 100px; /* Đặt độ rộng cố định cho nhãn (ví dụ: 'Username:') */
                color: #555;
            }
            .profile-info span {
                flex-grow: 1; /* Cho phép giá trị chiếm phần còn lại */
                font-weight: bold; /* Giá trị in đậm */
                color: #007bff; /* Màu xanh nổi bật */
            }

            /* Nút Đăng nhập/Trở về */
            .action-link {
                display: inline-block;
                margin-top: 25px;
                padding: 10px 20px;
                text-decoration: none;
                background-color: #28a745;
                color: white;
                border-radius: 5px;
                transition: background-color 0.3s;
            }
            .action-link:hover {
                background-color: #1e7e34;
            }
        </style>
    </head>
    <body>
        
        <h1>Thông tin Chi tiết Người dùng</h1>

        <%
            Object userObject = session.getAttribute("user");
        %>

        <div class="profile-box">
        <% if (userObject != null) { 
            info.user_info userProfile = (info.user_info) userObject; 
            request.setAttribute("userProfile", userProfile);
        %>
            <div class="profile-info">
                <strong>Username:</strong> <span>${userProfile.username}</span>
            </div>
            <div class="profile-info">
                <strong>Họ:</strong> <span>${userProfile.lastName}</span>
            </div>
            <div class="profile-info">
                <strong>Tên:</strong> <span>${userProfile.firstName}</span>
            </div>
            <div class="profile-info">
                <strong>Địa chỉ:</strong> <span>${userProfile.address}</span>
            </div>
            <div class="profile-info">
                <strong>Liên hệ:</strong> <span>${userProfile.contact}</span>
            </div>
            
            <a href="./Home.jsp" class="action-link">Trở về Trang Chủ</a>
            
        <% } else { %>

            <p style="color: red; text-align: center;">Vui lòng đăng nhập để xem thông tin.</p>
            <a href="./Login.html" class="action-link">Đăng nhập ở đây</a>

        <% } %>
        </div>
        
    </body>
</html>