import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
 
public class SProg12 extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
  
            PrintWriter out = response.getWriter();  
           
            // Getting value from the query string
            String santaName = request.getParameter("santaName");  
            
            // Christmas Gift Shop HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>🎁 Santa's Gift Shop 🎁</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    background: linear-gradient(135deg, #2ed573, #ff4757, #ffa502);");
            out.println("    font-family: 'Arial', sans-serif;");
            out.println("    margin: 0; padding: 50px;");
            out.println("    min-height: 100vh;");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    animation: christmasColors 5s infinite;");
            out.println("}");
            out.println("@keyframes christmasColors {");
            out.println("    0% { background: linear-gradient(135deg, #2ed573, #ff4757, #ffa502); }");
            out.println("    33% { background: linear-gradient(135deg, #ff4757, #ffa502, #2ed573); }");
            out.println("    66% { background: linear-gradient(135deg, #ffa502, #2ed573, #ff4757); }");
            out.println("    100% { background: linear-gradient(135deg, #2ed573, #ff4757, #ffa502); }");
            out.println("}");
            out.println(".gift-shop {");
            out.println("    background: white;");
            out.println("    padding: 60px;");
            out.println("    border-radius: 30px;");
            out.println("    box-shadow: 0 30px 60px rgba(0,0,0,0.4);");
            out.println("    text-align: center;");
            out.println("    border: 6px solid #ffa502;");
            out.println("    position: relative;");
            out.println("    overflow: hidden;");
            out.println("}");
            out.println(".gift-shop::before {");
            out.println("    content: '🎁 🎄 ⭐ 🎄 🎁';");
            out.println("    position: absolute;");
            out.println("    top: 15px;");
            out.println("    left: 0; right: 0;");
            out.println("    font-size: 24px;");
            out.println("    animation: sparkle 3s infinite;");
            out.println("}");
            out.println("@keyframes sparkle {");
            out.println("    0%, 100% { transform: scale(1) rotate(0deg); }");
            out.println("    50% { transform: scale(1.1) rotate(5deg); }");
            out.println("}");
            out.println("h1 {");
            out.println("    color: #ff4757;");
            out.println("    font-size: 3.5em;");
            out.println("    margin: 40px 0 30px 0;");
            out.println("    text-shadow: 3px 3px 6px rgba(0,0,0,0.3);");
            out.println("}");
            out.println(".welcome-message {");
            out.println("    background: linear-gradient(45deg, #2ed573, #20bf6b);");
            out.println("    color: white;");
            out.println("    padding: 25px;");
            out.println("    border-radius: 20px;");
            out.println("    font-size: 1.5em;");
            out.println("    margin: 30px 0;");
            out.println("    box-shadow: 0 10px 20px rgba(46, 213, 115, 0.3);");
            out.println("}");
            out.println(".gift-list {");
            out.println("    background: #f8f9fa;");
            out.println("    padding: 25px;");
            out.println("    border-radius: 15px;");
            out.println("    margin: 25px 0;");
            out.println("    border-left: 5px solid #ffa502;");
            out.println("}");
            out.println(".decoration { font-size: 3em; margin: 25px 0; }");
            out.println(".session-info {");
            out.println("    background: #e8f4f8;");
            out.println("    padding: 20px;");
            out.println("    border-radius: 15px;");
            out.println("    margin-top: 30px;");
            out.println("    border: 2px dashed #2ed573;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='gift-shop'>");
            
            out.println("<h1>🎁 Santa's Magical Gift Shop 🎁</h1>");
            
            out.println("<div class='welcome-message'>");
            out.println("🎅 Hello Dear " + santaName + "! 🎅");
            out.println("</div>");
            
            out.println("<div class='decoration'>🎄 ⭐ 🔔 ⭐ 🎄</div>");
            
            out.println("<div class='gift-list'>");
            out.println("<h3 style='color: #ff4757; margin-top: 0;'>🎁 Your Christmas Gifts Available:</h3>");
            out.println("<p style='font-size: 1.2em; color: #2ed573;'>✨ Magical Toy Train</p>");
            out.println("<p style='font-size: 1.2em; color: #2ed573;'>🍪 Unlimited Christmas Cookies</p>");
            out.println("<p style='font-size: 1.2em; color: #2ed573;'>🎵 Musical Snow Globe</p>");
            out.println("<p style='font-size: 1.2em; color: #2ed573;'>⭐ Twinkling Christmas Star</p>");
            out.println("</div>");
            
            out.println("<div class='decoration'>🔔 🎂 🍪 🎂 🔔</div>");
            
            out.println("<div class='session-info'>");
            out.println("<h4 style='color: #ffa502; margin-top: 0;'>🔮 Session Magic Details:</h4>");
            out.println("<p style='color: #666;'>");
            out.println("Your name '<strong>" + santaName + "</strong>' has been magically carried over using URL rewriting!");
            out.println("</p>");
            out.println("<p style='font-style: italic; color: #888;'>");
            out.println("✨ No cookies needed - just pure servlet magic! ✨");
            out.println("</p>");
            out.println("</div>");
            
            out.println("<div class='decoration'>🎅 Ho Ho Ho! Merry Christmas! 🎅</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
   
            out.close();  
        }
        catch(Exception e) {
            System.out.println("🎁 Gift Shop Error: " + e);
        }  
    }  
}