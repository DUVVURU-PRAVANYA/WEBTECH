import java.io.*;
import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg6 extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
        try {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            // Look for the specific Christmas Order cookie
            Cookie[] cookies = request.getCookies();
            Cookie christmasCookie = null;
            
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("ChristmasOrder".equals(cookie.getName())) {
                        christmasCookie = cookie;
                        break;
                    }
                }
            }
            
            // Generate HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Christmas Cookie Order History</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; background: linear-gradient(135deg, #654321, #A0522D); color: white; text-align: center; padding: 50px; }");
            out.println(".container { background: rgba(0,0,0,0.3); padding: 40px; border-radius: 15px; max-width: 600px; margin: 0 auto; }");
            out.println("h1 { color: #FFD700; font-size: 2.5em; }");
            out.println(".order-display { background: #2F1B14; padding: 20px; border-radius: 10px; margin: 20px 0; }");
            out.println(".no-order { background: #8B4513; padding: 30px; border-radius: 10px; border: 2px dashed #D2691E; }");
            out.println("</style>");
            out.println("</head><body>");
            
            out.println("<div class='container'>");
            out.println("<h1>Christmas Cookie Order History</h1>");
            
            if (christmasCookie != null) {
                String cookieValue = christmasCookie.getValue();
                
                // Convert underscores back to spaces
                String orderName = cookieValue.replace("_", " ");
                try {
                    orderName = URLDecoder.decode(orderName, "UTF-8");
                } catch (Exception e) {
                    orderName = cookieValue.replace("_", " ");
                }
                
                out.println("<p style='font-size: 1.2em; color: #90EE90;'>Order Found Successfully!</p>");
                
                out.println("<div class='order-display'>");
                out.println("<h3>Your Christmas Cookie Order:</h3>");
                String safeOrder = orderName.replace("<", "&lt;").replace(">", "&gt;");
                out.println("<p style='font-size: 1.3em; color: #FFD700;'>\"" + safeOrder + "\"</p>");
                out.println("<p>Status: <span style='color: #90EE90;'>Saved in System</span></p>");
                out.println("</div>");
                
                out.println("<div style='font-size: 2em; margin: 20px;'>🍪 ✅ 🎄</div>");
                
            } else {
                out.println("<div class='no-order'>");
                out.println("<h3>No Christmas Order Found</h3>");
                out.println("<p>Please place your first cookie order to see it here!</p>");
                out.println("<p style='font-style: italic;'>Go back to the order form to place an order.</p>");
                out.println("</div>");
                
                out.println("<div style='font-size: 2em; margin: 20px;'>📚 ❌ 🍪</div>");
            }
            
            out.println("<p style='margin-top: 30px;'>");
            out.println("<strong>System Info:</strong> Showing only Christmas Order cookies");
            out.println("</p>");
            out.println("</div>");
            
            out.println("</body></html>");
            out.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}