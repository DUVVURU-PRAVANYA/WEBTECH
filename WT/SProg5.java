import java.io.*;
import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SProg5 extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
        try {
            // Set proper encoding for input handling
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            
            PrintWriter out = response.getWriter();
            String userInput = request.getParameter("userin");
            
            // Handle input with spaces and special characters
            if (userInput != null && userInput.trim().length() > 0) {
                userInput = userInput.replace("+", " ");
                try {
                    userInput = URLDecoder.decode(userInput, "UTF-8");
                } catch (Exception e) {
                    System.out.println("Decode warning: " + e.getMessage());
                }
                userInput = userInput.trim();
            } else {
                userInput = "Christmas Cookie"; // Default value
            }
            
            // Create cookie (replace spaces with underscores for HTTP standard)
            String cookieValue = userInput.replace(" ", "_").replace("\"", "");
            Cookie userCookie = new Cookie("ChristmasOrder", cookieValue);
            userCookie.setMaxAge(60 * 60 * 24 * 7); // 7 days
            userCookie.setPath("/");
            response.addCookie(userCookie);
            
            // Generate HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Christmas Cookie Order Confirmation</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; background: linear-gradient(135deg, #8B4513, #D2691E); color: white; text-align: center; padding: 50px; }");
            out.println(".container { background: rgba(0,0,0,0.3); padding: 40px; border-radius: 15px; max-width: 600px; margin: 0 auto; }");
            out.println("h1 { color: #FFD700; font-size: 2.5em; }");
            out.println(".order { background: #2F1B14; padding: 20px; border-radius: 10px; margin: 20px 0; }");
            out.println("</style>");
            out.println("</head><body>");
            
            out.println("<div class='container'>");
            out.println("<h1>Christmas Cookie Order Confirmed!</h1>");
            out.println("<p style='font-size: 1.2em;'>Thank you for your order!</p>");
            
            out.println("<div class='order'>");
            out.println("<h3>Your Order Details:</h3>");
            String safeInput = userInput.replace("<", "&lt;").replace(">", "&gt;");
            out.println("<p><strong>Cookie Type:</strong> \"" + safeInput + "\"</p>");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a");
            out.println("<p><strong>Order Time:</strong> " + dateFormat.format(new Date()) + "</p>");
            out.println("</div>");
            
            out.println("<p style='color: #90EE90; font-size: 1.1em;'>Your order has been saved in our system!</p>");
            out.println("<div style='font-size: 2em; margin: 20px;'>🍪 🎄 ☕</div>");
            out.println("</div>");
            
            out.println("</body></html>");
            out.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}