
import java.sql.Connection;
import java.sql.DriverManager;


public class main {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg?useSSL=false", "root", "123456")) { 
            System.out.println("Kết nối thành công");    
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
