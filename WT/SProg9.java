import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.nio.charset.StandardCharsets;

public class SProg9 extends HttpServlet
{  
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {  
        try {  
            // Force UTF-8 encoding for request and response
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            
            PrintWriter out = response.getWriter();  
            String visitorName = request.getParameter("visitorName");  
            
            // Christmas-themed welcome message with styling
            out.print("<!DOCTYPE html>");
            out.print("<html><head>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.print("<title>\uD83C\uDF84 Christmas Session Management \uD83C\uDF84</title>");
            out.print("<style>");
            out.print("body { background: linear-gradient(135deg, #c41e3a, #2e8b57); color: white; font-family: 'Comic Sans MS', cursive; text-align: center; padding: 50px; }");
            out.print(".container { background: rgba(255,255,255,0.1); padding: 30px; border-radius: 20px; border: 3px solid gold; }");
            out.print("h1 { color: #ffd700; text-shadow: 2px 2px 4px #000; }");
            out.print(".welcome { font-size: 24px; margin: 20px 0; }");
            out.print("input[type='submit'] { background: #228b22; color: white; border: none; padding: 15px 30px; border-radius: 10px; font-size: 18px; cursor: pointer; }");
            out.print("input[type='submit']:hover { background: #32cd32; }");
            out.print(".snowflake { position: absolute; color: white; font-size: 20px; animation: fall 3s linear infinite; }");
            out.print("@keyframes fall { 0% { top: -50px; } 100% { top: 100vh; } }");
            out.print("</style></head><body>");
            
            // Add falling snowflakes using Unicode escapes
            out.print("<div class='snowflake' style='left: 10%; animation-delay: 0s;'>\u2744</div>");
            out.print("<div class='snowflake' style='left: 20%; animation-delay: 1s;'>\u2745</div>");
            out.print("<div class='snowflake' style='left: 30%; animation-delay: 2s;'>\u2744</div>");
            out.print("<div class='snowflake' style='left: 40%; animation-delay: 0.5s;'>\u2745</div>");
            out.print("<div class='snowflake' style='left: 50%; animation-delay: 1.5s;'>\u2744</div>");
            out.print("<div class='snowflake' style='left: 60%; animation-delay: 0.8s;'>\u2745</div>");
            out.print("<div class='snowflake' style='left: 70%; animation-delay: 2.2s;'>\u2744</div>");
            out.print("<div class='snowflake' style='left: 80%; animation-delay: 1.2s;'>\u2745</div>");
            out.print("<div class='snowflake' style='left: 90%; animation-delay: 0.3s;'>\u2744</div>");
            
            out.print("<div class='container'>");
            out.print("<h1>\uD83C\uDF85 Ho Ho Ho! Welcome to Santa's Workshop! \uD83C\uDF85</h1>");
            out.print("<div class='welcome'>\uD83C\uDF84 Merry Christmas, " + visitorName + "! \uD83C\uDF84</div>");
            out.print("<p>\uD83C\uDF81 Santa has received your Christmas wish! \uD83C\uDF81</p>");
            out.print("<p>\uD83D\uDD14 Click below to visit Santa's gift preparation area! \uD83D\uDD14</p>");
            
            // Form with hidden fields
            out.print("<form action='SP10' method='POST'>");  
            out.print("<input type='hidden' name='christmasVisitor' value='" + visitorName + "'>");
            out.print("<input type='hidden' name='sessionId' value='XMAS_" + System.currentTimeMillis() + "'>");
            out.print("<input type='hidden' name='visitTime' value='" + new java.util.Date() + "'>");
            out.print("<input type='submit' value='\uD83C\uDF81 Enter Santa&apos;s Workshop \uD83C\uDF81'>");  
            out.print("</form>");
            out.print("</div></body></html>");
            
            out.close();  
        } catch(Exception e) {
            System.out.println("\uD83C\uDF84 Christmas Error: " + e);
        }  
    }  
}