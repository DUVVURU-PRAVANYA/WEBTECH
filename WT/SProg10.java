import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.nio.charset.StandardCharsets;

public class SProg10 extends HttpServlet
{  
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {  
        try {  
            // Force UTF-8 encoding for request and response
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8"); 
            
            PrintWriter out = response.getWriter();  

            // Retrieve hidden fields
            String visitorName = request.getParameter("christmasVisitor");
            String sessionId = request.getParameter("sessionId");
            String visitTime = request.getParameter("visitTime");

            out.print("<!DOCTYPE html>");
            out.print("<html><head>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.print("<title>\uD83C\uDF81 Santa's Workshop \uD83C\uDF81</title>");
            out.print("<style>");
            out.print("body { background: linear-gradient(45deg, #0f4c75, #3282b8, #bbe1fa); color: white; font-family: 'Comic Sans MS', cursive; text-align: center; padding: 30px; }");
            out.print(".workshop { background: rgba(255,255,255,0.15); padding: 40px; border-radius: 25px; border: 4px solid #ffd700; margin: 20px; }");
            out.print("h1 { color: #ffd700; text-shadow: 3px 3px 6px #000; font-size: 36px; }");
            out.print(".info { background: rgba(255,255,255,0.2); padding: 20px; border-radius: 15px; margin: 15px 0; }");
            out.print(".gift-box { font-size: 60px; animation: bounce 2s infinite; }");
            out.print("@keyframes bounce { 0%, 20%, 50%, 80%, 100% { transform: translateY(0); } 40% { transform: translateY(-30px); } 60% { transform: translateY(-15px); } }");
            out.print(".session-info { font-size: 14px; background: rgba(0,0,0,0.3); padding: 10px; border-radius: 10px; margin: 20px 0; }");
            out.print(".back-btn { background: #c41e3a; color: white; border: none; padding: 12px 25px; border-radius: 8px; font-size: 16px; cursor: pointer; margin-top: 20px; }");
            out.print(".back-btn:hover { background: #e74c3c; }");
            out.print("</style></head><body>");

            out.print("<div class='workshop'>");
            out.print("<h1>\uD83C\uDFAA Welcome to Santa's Magical Workshop! \uD83C\uDFAA</h1>");
            out.print("<div class='gift-box'>\uD83C\uDF81</div>");

            out.print("<div class='info'>");
            out.print("<h2>\uD83C\uDF85 Ho Ho Ho, " + visitorName + "! \uD83C\uDF85</h2>");
            out.print("<p>\uD83C\uDF1F You are now inside Santa's special workshop! \uD83C\uDF1F</p>");
            out.print("<p>\uD83E\uDDDD\u200D\u2640\uFE0F The elves are busy preparing your Christmas gifts! \uD83E\uDDDD\u200D\u2642\uFE0F</p>");
            out.print("<p>\uD83E\uDD8C Rudolph and the reindeer are getting ready for Christmas delivery! \uD83E\uDD8C</p>");
            out.print("</div>");

            // Display session info
            out.print("<div class='session-info'>");
            out.print("<h3>\uD83D\uDCCB Session Information (via Hidden Form Fields) \uD83D\uDCCB</h3>");
            out.print("<p><strong>\uD83C\uDFF7\uFE0F Visitor:</strong> " + visitorName + "</p>");
            out.print("<p><strong>\uD83C\uDD94 Session ID:</strong> " + sessionId + "</p>");
            out.print("<p><strong>\u23F0 Visit Time:</strong> " + visitTime + "</p>");
            out.print("<p><em>\u2139\uFE0F This data was passed using hidden form fields for session management!</em></p>");
            out.print("</div>");

            out.print("<p>\uD83C\uDF84 Thank you for visiting Santa's Workshop! \uD83C\uDF84</p>");
            out.print("<p>\uD83C\uDF85 Have a Merry Christmas and a Happy New Year! \uD83C\uDF8A</p>");

            out.print("<button class='back-btn' onclick='history.back()'>\uD83D\uDD19 Back to Christmas Page</button>");
            out.print("</div></body></html>");

            out.close();  
        } catch(Exception e) {
            System.out.println("\uD83C\uDF84 Christmas Workshop Error: " + e);  
        } 
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        doGet(request, response);
    }
}