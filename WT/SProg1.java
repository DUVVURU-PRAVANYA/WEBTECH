import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Christmas Servlet extending HttpServlet class
public class SProg1 extends HttpServlet {

   private String message;

   public void init() throws ServletException {
      // Initialize with Christmas message (text only, no emojis here)
      message = "Ho Ho Ho! Welcome to the magical Christmas Servlet Arena!";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      // Set response content type
      response.setContentType("text/html; charset=UTF-8");
      response.setCharacterEncoding("UTF-8");

      // Get PrintWriter to write response
      PrintWriter out = response.getWriter();

      // Generate Christmas-themed HTML response
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>🎄 Christmas Servlet Response</title>");
      out.println("<style>");
      out.println("body {");
      out.println("  background: linear-gradient(45deg, #d32f2f, #388e3c, #1976d2, #7b1fa2);");
      out.println("  background-size: 400% 400%;");
      out.println("  animation: gradientShift 4s ease infinite;");
      out.println("  font-family: 'Arial', sans-serif;");
      out.println("  text-align: center;");
      out.println("  padding: 50px;");
      out.println("  margin: 0;");
      out.println("  color: white;");
      out.println("  min-height: 100vh;");
      out.println("}");
      out.println("@keyframes gradientShift {");
      out.println("  0% { background-position: 0% 50%; }");
      out.println("  50% { background-position: 100% 50%; }");
      out.println("  100% { background-position: 0% 50%; }");
      out.println("}");
      out.println("h1 {");
      out.println("  font-size: 2.5em;");
      out.println("  text-shadow: 2px 2px 4px rgba(0,0,0,0.5);");
      out.println("  margin-bottom: 30px;");
      out.println("  background: linear-gradient(45deg, #ffeb3b, #ff9800);");
      out.println("  -webkit-background-clip: text;");
      out.println("  -webkit-text-fill-color: transparent;");
      out.println("  background-clip: text;");
      out.println("  animation: bounce 2s infinite;");
      out.println("  display: inline-block;");
      out.println("}");
      out.println("@keyframes bounce {");
      out.println("  0%, 20%, 50%, 80%, 100% { transform: translateY(0); }");
      out.println("  40% { transform: translateY(-30px); }");
      out.println("  60% { transform: translateY(-15px); }");
      out.println("}");
      out.println(".emoji {");
      out.println("  -webkit-background-clip: unset;");
      out.println("  -webkit-text-fill-color: initial;");
      out.println("  background: none;");
      out.println("  font-size: 1.2em;");
      out.println("}");
      out.println(".back-link {");
      out.println("  display: inline-block;");
      out.println("  background: linear-gradient(45deg, #4caf50, #8bc34a);");
      out.println("  color: white;");
      out.println("  padding: 15px 30px;");
      out.println("  text-decoration: none;");
      out.println("  border-radius: 25px;");
      out.println("  font-size: 1.2em;");
      out.println("  font-weight: bold;");
      out.println("  box-shadow: 0 6px 12px rgba(0,0,0,0.3);");
      out.println("  transition: all 0.3s ease;");
      out.println("  border: 2px solid #ffeb3b;");
      out.println("}");
      out.println(".back-link:hover {");
      out.println("  background: linear-gradient(45deg, #d32f2f, #f44336);");
      out.println("  transform: translateY(-3px);");
      out.println("  box-shadow: 0 9px 18px rgba(0,0,0,0.4);");
      out.println("}");
      out.println(".santa {");
      out.println("  font-size: 3em;");
      out.println("  animation: wave 1s ease-in-out infinite;");
      out.println("}");
      out.println("@keyframes wave {");
      out.println("  0%, 100% { transform: rotate(0deg); }");
      out.println("  50% { transform: rotate(20deg); }");
      out.println("}");
      out.println("</style>");
      out.println("</head>");
      out.println("<body>");
      out.println("<div class='santa'>🎅</div>");
      out.println("<h1><span class='emoji'>🎄</span> " + message + " <span class='emoji'>🎅</span></h1>");
      out.println("<div class='santa'>🤶</div>");
      out.println("<p><a href='http://localhost:8080/DUVVURU/sprgm1.html' class='back-link'>");
      out.println("🎁 Return to Christmas Portal 🎄</a></p>");
      out.println("</body>");
      out.println("</html>");
   }

   public void destroy() {
      // Christmas cleanup - do nothing special
   }
}
