/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String sql = "select * from employee where username = ? and password = ?";
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg?useSSL=false", "root", "123456");
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);

            // THỰC THI TRUY VẤN
            try (ResultSet rs = stm.executeQuery()) {

                if (rs.next()) {
                    // Đăng nhập THÀNH CÔNG: Tìm thấy bản ghi
                    user_info userInfo = new user_info(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("contact")
                    );
                    HttpSession session = request.getSession();
                    
                    session.setAttribute("user", userInfo);
                    response.sendRedirect("Home.jsp");
                } else {
                    // Đăng nhập THẤT BẠI: Không tìm thấy bản ghi
                    out.println("<h1>Đăng nhập thất bại!</h1>");
                    out.println("<p>Tên người dùng hoặc mật khẩu không đúng.</p>");
                }
            }
        }
        catch (Exception e) {
            // Xử lý lỗi kết nối hoặc truy vấn
            e.printStackTrace(out);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
