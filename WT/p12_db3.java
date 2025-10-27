
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p12_db3 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/p12_db?useUnicode=true&characterEncoding=UTF-8",
                "root", ""
            );

            String depid = request.getParameter("depid");
            String depname = request.getParameter("depname");
            String depnos = request.getParameter("depnos");

            out.println("<html><head><title>🎄 Insert Department 🎄</title>");
            out.println("<style>");
            out.println("body { background: linear-gradient(135deg, #1a472a 0%, #2d5a3d 100%); color: #fff; font-family: Arial; padding: 20px; }");
            out.println("h1 { color: #ff6b6b; text-align: center; text-shadow: 2px 2px 4px rgba(0,0,0,0.7); }");
            out.println("h2 { color: #4ade80; }");
            out.println(".success { background: rgba(74,222,128,0.2); border: 2px solid #4ade80; padding: 15px; border-radius: 8px; margin: 20px 0; }");
            out.println(".error { background: rgba(255,107,107,0.2); border: 2px solid #ff6b6b; padding: 15px; border-radius: 8px; margin: 20px 0; color: #ff9999; }");
            out.println(".dept-card { background: rgba(255,255,255,0.05); border: 2px solid #4ade80; border-radius: 10px; padding: 15px; margin: 15px 0; transition: all 0.3s; }");
            out.println(".dept-card:hover { box-shadow: 0 0 20px rgba(74,222,128,0.5); transform: translateY(-5px); }");
            out.println(".label { color: #ffd700; font-weight: bold; }");
            out.println(".value { color: #e0e0e0; margin-left: 10px; }");
            out.println(".back-link { display: inline-block; margin: 20px 0; padding: 10px 20px; background: #ff6b6b; color: white; text-decoration: none; border-radius: 5px; }");
            out.println("</style></head><body>");

            out.println("<h1>🎄 Department Management System 🎄</h1>");
            String checkSql = "SELECT * FROM department WHERE DeptID = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, depid);
            ResultSet checkRs = checkStmt.executeQuery();

            if (checkRs.next()) {
                out.println("<div class='error'>");
                out.println("<h2>❌ Duplicate Department ID!</h2>");
                out.println("<p>Department ID <strong>" + depid + "</strong> already exists. Please use a new ID.</p>");
                out.println("</div>");
            } else {
                //  Insert new department
                String insertSql = "INSERT INTO department (DeptID, DeptName, NOS) VALUES (?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setString(1, depid);
                insertStmt.setString(2, depname);
                insertStmt.setInt(3, Integer.parseInt(depnos));

                int result = insertStmt.executeUpdate();

                if (result > 0) {
                    out.println("<div class='success'>");
                    out.println("<h2>✓ Department Added Successfully!</h2>");
                    out.println("<p><span class='label'>🎁 Department ID:</span><span class='value'>" + depid + "</span></p>");
                    out.println("<p><span class='label'>📚 Department Name:</span><span class='value'>" + depname + "</span></p>");
                    out.println("<p><span class='label'>👥 Number of Students:</span><span class='value'>" + depnos + "</span></p>");
                    out.println("</div>");
                }

                insertStmt.close();
            }

            checkRs.close();
            checkStmt.close();

            //  Display all departments
            out.println("<h2>🎅 All Departments in Database 🎅</h2>");
            String selectSql = "SELECT * FROM department";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            ResultSet rs = selectStmt.executeQuery();

            int count = 0;
            while (rs.next()) {
                count++;
                out.println("<div class='dept-card'>");
                out.println("<p><span class='label'>🎁 Department ID:</span><span class='value'>" + rs.getString("DeptID") + "</span></p>");
                out.println("<p><span class='label'>📚 Department Name:</span><span class='value'>" + rs.getString("DeptName") + "</span></p>");
                out.println("<p><span class='label'>👥 Number of Students:</span><span class='value'>" + rs.getInt("NOS") + "</span></p>");
                out.println("</div>");
            }

            out.println("<h3>📊 Total Departments: " + count + "</h3>");
            out.println("<a class='back-link' href='p12_db.html'>← Go Back</a>");
            out.println("</body></html>");

            rs.close();
            selectStmt.close();
            conn.close();

        } catch (SQLException e) {
            out.println("<div class='error'>");
            out.println("<h2>❌ Database Error</h2>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
            out.println("</div>");
            System.out.print("SQL Error: " + e);
        } catch (Exception e) {
            out.println("<div class='error'>");
            out.println("<h2>❌ Error</h2>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
            out.println("</div>");
            System.out.print("Error: " + e);
        }
    }
}
