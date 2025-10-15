
import info.user_info;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;

/**
 *
 * @author OS
 */
@WebServlet(urlPatterns = {"/signupServlet"})
public class signupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Lấy dữ liệu từ form
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        // 2. Xác thực cơ bản (Giữ nguyên logic của bạn)
        if (!password.equals(confirmPassword)) {
            out.println("Lỗi: Mật khẩu xác nhận không khớp!");
            return;
        }
        if (firstName == null || firstName.isEmpty() || username == null || username.isEmpty()) {
            out.println("Lỗi: Vui lòng điền đầy đủ các trường bắt buộc.");
            return;
        }

        // 3. Thông tin kết nối và Truy vấn
        String sql = "INSERT INTO employee (first_name, last_name, username, password, address, contact) VALUES (?,?,?,?,?,?)";

        try {
            // Tải driver thủ công không còn cần thiết nhưng giữ lại để gỡ lỗi
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg?useSSL=false", "root", "123456");
            PreparedStatement stm = con.prepareStatement(sql);
            // Gán tham số
            stm.setString(1, firstName);
            stm.setString(2, lastName);
            stm.setString(3, username);
            stm.setString(4, password);
            stm.setString(5, address);
            stm.setString(6, contact);

            // THỰC THI CHÈN DỮ LIỆU
            int rowsAffected = stm.executeUpdate(); // SỬA LỖI Ở ĐÂY

            if (rowsAffected > 0) {
                // Đăng ký thành công và chuyển hướng người dùng
                out.println("<h1>Đăng kí thành công!</h1>");
                out.println("<p>Bạn sẽ được chuyển hướng về trang đăng nhập...</p>");
                // Chuyển hướng về trang đăng nhập (giả sử là Login.html)
                response.setHeader("Refresh", "3;url=Login.html"); 

            } else {
                out.println("Lỗi: Không thể chèn dữ liệu. Vui lòng thử lại.");
            }

        } catch (SQLException e) {
            // Xử lý lỗi SQL (Ví dụ: Username đã tồn tại do UNIQUE constraint)
            if (e.getErrorCode() == 1062) { // 1062 là mã lỗi trùng lặp (Duplicate Entry)
                out.println("Lỗi: Tên đăng nhập đã tồn tại. Vui lòng chọn username khác.");
            } else {
                out.println("Lỗi SQL: " + e.getMessage());
            }
            e.printStackTrace(out);
        } catch (Exception e) {
            out.println("Lỗi hệ thống: " + e.getMessage());
            e.printStackTrace(out);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
