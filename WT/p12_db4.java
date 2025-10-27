
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p12_db4 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Emoji-safe response
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Connection conn = null;

        try {
            // ✅ Keep your driver
            Class.forName("com.mysql.jdbc.Driver");

            // ✅ Connection URL with UTF-8
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/p12_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root",
                ""
            );

            String depid = request.getParameter("depid");
            String depname = request.getParameter("depname");
            String depnos = request.getParameter("depnos");

            out.println("<!DOCTYPE html>");
            out.println("<html><head><meta charset='UTF-8'><title>🎄 Update Department 🎄</title>");
            out.println("<style>");
            out.println("body { background: linear-gradient(135deg, #1a472a 0%, #2d5a3d 100%); color: #fff; font-family: Arial; padding: 20px; }");
            out.println("h1 { color: #ff6b6b; text-align: center; text-shadow: 2px 2px 4px rgba(0,0,0,0.7); }");
            out.println(".success { background: rgba(74,222,128,0.2); border: 2px solid #4ade80; padding: 15px; border-radius: 8px; margin: 20px 0; }");
            out.println(".error { background: rgba(255,107,107,0.2); border: 2px solid #ff6b6b; padding: 15px; border-radius: 8px; margin: 20px 0; color: #ff9999; }");
            out.println(".dept-card { background: rgba(255,255,255,0.05); border: 2px solid #4ade80; border-radius: 10px; padding: 15px; margin: 15px 0; }");
            out.println(".label { color: #ffd700; font-weight: bold; }");
            out.println(".value { color: #e0e0e0; margin-left: 10px; }");
            out.println(".back-link { display: inline-block; margin: 20px 0; padding: 10px 20px; background: #ff6b6b; color: white; text-decoration: none; border-radius: 5px; }");
            out.println("</style></head><body>");

            out.println("<h1>🎄 Update Department 🎄</h1>");

            // ✅ Check if department exists
            String checkSql = "SELECT * FROM department WHERE DeptID = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, depid);
            ResultSet checkRs = checkStmt.executeQuery();

            if (!checkRs.next()) {
                out.println("<div class='error'>");
                out.println("<h2>❌ Department Not Found!</h2>");
                out.println("<p>Department ID <strong>" + depid + "</strong> does not exist.</p>");
                out.println("</div>");
            } else {
                // ✅ Update department
                String updateSql = "UPDATE department SET DeptName = ?, NOS = ? WHERE DeptID = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setString(1, depname); // emoji-safe
                updateStmt.setInt(2, Integer.parseInt(depnos));
                updateStmt.setString(3, depid);

                int res = updateStmt.executeUpdate();
                if (res > 0) {
                    out.println("<div class='success'>");
                    out.println("<h2>✅ Department Updated Successfully!</h2>");
                    out.println("<p><span class='label'>🎁 Dept ID:</span><span class='value'>" + depid + "</span></p>");
                    out.println("<p><span class='label'>📚 Dept Name:</span><span class='value'>" + depname + "</span></p>");
                    out.println("<p><span class='label'>👥 Students:</span><span class='value'>" + depnos + "</span></p>");
                    out.println("</div>");
                } else {
                    out.println("<div class='error'>");
                    out.println("<h2>❌ Update Failed!</h2>");
                    out.println("</div>");
                }
                updateStmt.close();
            }

            checkRs.close();
            checkStmt.close();

            // ✅ Show all departments
            out.println("<h2>🎅 All Departments 🎅</h2>");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                out.println("<div class='dept-card'>");
                out.println("<p><span class='label'>🎁 Dept ID:</span><span class='value'>" + rs.getString("DeptID") + "</span></p>");
                out.println("<p><span class='label'>📚 Dept Name:</span><span class='value'>" + rs.getString("DeptName") + "</span></p>");
                out.println("<p><span class='label'>👥 Students:</span><span class='value'>" + rs.getInt("NOS") + "</span></p>");
                out.println("</div>");
            }

            out.println("<a class='back-link' href='p12_db.html'>← Go Back</a>");
            out.println("</body></html>");

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<html><head><meta charset='UTF-8'></head><body>");
            out.println("<div class='error'>Error: " + e.getMessage() + "</div></body></html>");
            e.printStackTrace();
        }
    }
}
