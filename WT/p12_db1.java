
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class p12_db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p12_db?useUnicode=true&characterEncoding=UTF-8", "root", "");
           
            stmt = conn.createStatement();
            String sql = "SELECT * FROM marks";
            ResultSet rs = stmt.executeQuery(sql);
           
            out.println("<html><head><title>Student Marks</title>");
            out.println("<style>");
            out.println("body { background: linear-gradient(135deg, #1a472a 0%, #2d5a3d 100%); color: #fff; font-family: Arial; padding: 20px; }");
            out.println("h1 { color: #ff6b6b; text-align: center; text-shadow: 2px 2px 4px rgba(0,0,0,0.7); }");
            out.println(".student-card { background: rgba(255,255,255,0.05); border: 2px solid #4ade80; border-radius: 10px; padding: 15px; margin: 15px 0; transition: all 0.3s; }");
            out.println(".student-card:hover { box-shadow: 0 0 20px rgba(74,222,128,0.5); transform: translateY(-5px); }");
            out.println(".label { color: #ffd700; font-weight: bold; }");
            out.println(".value { color: #e0e0e0; margin-left: 10px; }");
            out.println("</style></head><body>");
            out.println("<h1>🎄 Student Marks List 🎄</h1>");
           
            while (rs.next()) {
                String reg = rs.getString("RegNo");
                String name = rs.getString("Name");
                String dept = rs.getString("Dept");
                Double cgpa = rs.getDouble("CGPA");
                String sch = rs.getString("Scholarship");
               
                out.println("<div class='student-card'>");
                out.println("<p><span class='label'>🎅 Registration No:</span><span class='value'>" + reg + "</span></p>");
                out.println("<p><span class='label'>📝 Name:</span><span class='value'>" + name + "</span></p>");
                out.println("<p><span class='label'>🏢 Department:</span><span class='value'>" + dept + "</span></p>");
                out.println("<p><span class='label'>⭐ CGPA:</span><span class='value'>" + cgpa + "</span></p>");
                out.println("<p><span class='label'>🎁 Scholarship:</span><span class='value'>" + sch + "</span></p>");
                out.println("</div>");
            }
           
            out.println("</body></html>");
           
            rs.close();
            stmt.close();
            conn.close();
           
        } catch (Exception e) {
            out.println("<h2 style='color: red;'>❌ Error: " + e.getMessage() + "</h2>");
            System.out.print("Database Connection Error: " + e);
        }
    }
}
