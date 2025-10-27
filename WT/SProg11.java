import java.io.*;  
import javax.servlet.http.*;  

public class SProg11 extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
  
            PrintWriter out = response.getWriter();  
           
            String christmasName = request.getParameter("userName");  
            
            // Christmas-themed HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>🎅 Santa's Workshop - Welcome 🎅</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    background: linear-gradient(135deg, #ff4757, #2ed573);");
            out.println("    font-family: 'Arial', sans-serif;");
            out.println("    margin: 0; padding: 50px;");
            out.println("    min-height: 100vh;");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("}");
            out.println(".christmas-welcome {");
            out.println("    background: white;");
            out.println("    padding: 50px;");
            out.println("    border-radius: 25px;");
            out.println("    box-shadow: 0 25px 50px rgba(0,0,0,0.3);");
            out.println("    text-align: center;");
            out.println("    border: 5px solid #2ed573;");
            out.println("    animation: glow 2s infinite alternate;");
            out.println("}");
            out.println("@keyframes glow {");
            out.println("    from { box-shadow: 0 25px 50px rgba(0,0,0,0.3); }");
            out.println("    to { box-shadow: 0 25px 50px rgba(46, 213, 115, 0.5); }");
            out.println("}");
            out.println("h1 { color: #ff4757; font-size: 3em; margin-bottom: 30px; }");
            out.println(".santa-link {");
            out.println("    display: inline-block;");
            out.println("    background: linear-gradient(45deg, #2ed573, #20bf6b);");
            out.println("    color: white;");
            out.println("    padding: 20px 40px;");
            out.println("    text-decoration: none;");
            out.println("    border-radius: 30px;");
            out.println("    font-size: 1.3em;");
            out.println("    font-weight: bold;");
            out.println("    transition: all 0.3s;");
            out.println("    box-shadow: 0 10px 20px rgba(46, 213, 115, 0.3);");
            out.println("    margin-top: 30px;");
            out.println("}");
            out.println(".santa-link:hover {");
            out.println("    transform: translateY(-5px);");
            out.println("    box-shadow: 0 20px 40px rgba(46, 213, 115, 0.5);");
            out.println("}");
            out.println(".decoration { font-size: 2.5em; margin: 20px 0; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='christmas-welcome'>");
            out.println("<div class='decoration'>🎄 ⭐ 🎅 ⭐ 🎄</div>");
            
            out.println("<h1>Ho Ho Ho! Welcome " + christmasName + "!</h1>");
            out.println("<p style='font-size: 1.4em; color: #2ed573; margin: 20px 0;'>");
            out.println("🎁 You've successfully entered Santa's Workshop! 🎁");
            out.println("</p>");
            out.println("<p style='font-size: 1.1em; color: #666;'>");
            out.println("Your Christmas spirit has been detected and recorded in our magical session!");
            out.println("</p>");
            
            // Appending the username in the query string with Christmas theme
            out.println("<a href='http://localhost:8080/DUVVURU/SP12?santaName=" + christmasName + "' class='santa-link'>");
            out.println("🎁 Visit Santa's Gift Shop 🎁");
            out.println("</a>");
            
            out.println("<div class='decoration'>🔔 🍪 🥛 🍪 🔔</div>");
            out.println("<p style='font-style: italic; color: #888; margin-top: 30px;'>");
            out.println("✨ Session maintained through magical URL rewriting ✨");
            out.println("</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
                   
            out.close();                  
        }
        catch(Exception e) {
            System.out.println("🎄 Christmas Error: " + e);
        }  
    }  
}