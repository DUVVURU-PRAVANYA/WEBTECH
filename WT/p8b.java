import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p8b extends HttpServlet {
    // HashMap to store visit count for each unique user by name
    private Map<String, Integer> userVisitMap = new HashMap<>();

    public synchronized void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        
        // Get current visit count for this specific user name
        Integer userVisits = userVisitMap.get(userName);
        if (userVisits == null) {
            userVisits = 0; // First time this user visits
        }
        userVisits++; // Increment this specific user's count
        
        // Store updated count for this user
        userVisitMap.put(userName, userVisits);

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>🦌 Reindeer Registry - Personal Stats 🎅</title>");
        out.println("<style>");
        out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
        
        out.println("@keyframes snowfall {");
        out.println("    0% { transform: translateY(-10px) rotate(0deg); opacity: 1; }");
        out.println("    100% { transform: translateY(100vh) rotate(360deg); opacity: 0.8; }");
        out.println("}");
        
        out.println("@keyframes glow {");
        out.println("    0%, 100% { text-shadow: 0 0 10px #fff, 0 0 20px #228b22; }");
        out.println("    50% { text-shadow: 0 0 20px #fff, 0 0 40px #32cd32; }");
        out.println("}");
        
        out.println("@keyframes pulse {");
        out.println("    0%, 100% { transform: scale(1); }");
        out.println("    50% { transform: scale(1.1); }");
        out.println("}");
        
        out.println("@keyframes float {");
        out.println("    0%, 100% { transform: translateY(0px) rotate(0deg); }");
        out.println("    50% { transform: translateY(-15px) rotate(10deg); }");
        out.println("}");
        
        out.println("body { font-family: Georgia, serif; background: linear-gradient(180deg, #1a472a, #2d5016, #0f2027); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; position: relative; overflow: hidden; }");
        
        out.println(".snowflake { position: absolute; top: -10px; color: white; font-size: 1.5em; opacity: 0.8; animation: snowfall linear infinite; pointer-events: none; }");
        
        out.println(".container { background: linear-gradient(135deg, rgba(0, 100, 0, 0.9), rgba(34, 139, 34, 0.9)); padding: 60px 50px; border-radius: 30px; text-align: center; box-shadow: 0 15px 50px rgba(255, 215, 0, 0.4), inset 0 0 30px rgba(255, 255, 255, 0.2); max-width: 600px; border: 3px solid #ffd700; position: relative; z-index: 10; }");
        
        out.println("h1 { color: #fff; margin-bottom: 20px; font-size: 2.3em; animation: glow 2s ease-in-out infinite; }");
        
        out.println(".welcome { color: #ffd700; font-size: 1.8em; margin-bottom: 30px; font-weight: bold; }");
        
        out.println(".counter-box { background: rgba(255, 255, 255, 0.95); padding: 30px; border-radius: 20px; margin-top: 30px; box-shadow: 0 8px 25px rgba(0, 0, 0, 0.3); border: 2px solid #ffd700; }");
        
        out.println(".counter-label { color: #006400; font-size: 1.3em; font-weight: bold; margin-bottom: 15px; }");
        
        out.println(".count { font-size: 3em; color: #dc143c; font-weight: bold; animation: pulse 2s ease-in-out infinite; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); }");
        
        out.println(".message { color: #ffd700; font-size: 1.2em; margin-top: 25px; font-style: italic; line-height: 1.6; }");
        
        out.println(".back-button { margin-top: 30px; padding: 15px 35px; font-size: 16px; font-weight: bold; border-radius: 50px; border: none; background: linear-gradient(135deg, #dc143c, #ff0000); color: white; cursor: pointer; text-decoration: none; display: inline-block; box-shadow: 0 5px 20px rgba(220, 20, 60, 0.5); transition: all 0.3s ease; }");
        
        out.println(".back-button:hover { transform: translateY(-3px) scale(1.05); box-shadow: 0 10px 30px rgba(255, 0, 0, 0.7); }");
        
        out.println(".gift { position: absolute; font-size: 2.5em; animation: float 3s ease-in-out infinite; }");
        out.println(".gift-1 { top: 30px; left: 30px; animation-delay: 0s; }");
        out.println(".gift-2 { top: 30px; right: 30px; animation-delay: 0.5s; }");
        out.println(".gift-3 { bottom: 30px; left: 40px; animation-delay: 1s; }");
        out.println(".gift-4 { bottom: 30px; right: 40px; animation-delay: 1.5s; }");
        
        out.println("</style></head><body>");
        
        out.println("<div class='container'>");
        out.println("<div class='gift gift-1'>🎁</div>");
        out.println("<div class='gift gift-2'>🎄</div>");
        out.println("<div class='gift gift-3'>⭐</div>");
        out.println("<div class='gift gift-4'>🔔</div>");
        
        out.println("<h1>🦌 Reindeer Registry 🦌</h1>");
        out.println("<div class='welcome'>Ho Ho Ho, " + userName + "! 🎅</div>");
        
        out.println("<div class='counter-box'>");
        out.println("<div class='counter-label'>🎄 " + userName + "'s Personal Visit Count 🎄</div>");
        out.println("<div class='count'>" + userVisits + "</div>");
        out.println("</div>");
        
        String message;
        if (userVisits == 1) {
            message = "Welcome to Santa's Workshop for the first time! 🌟";
        } else if (userVisits < 5) {
            message = "You're becoming a regular helper at the North Pole! ❄️";
        } else if (userVisits < 10) {
            message = "Santa's impressed with your dedication! 🎅";
        } else {
            message = "You're officially an Honorary Elf! 🧝 Keep up the Christmas spirit!";
        }
        
        out.println("<p class='message'>" + message + "</p>");
        out.println("<p class='message'>May your days be merry and bright! 🌟</p>");
        
        out.println("<a href='p8b.html' class='back-button'>Visit Again 🎁</a>");
        
        out.println("</div>");
        
        // Add snowflakes
        out.println("<script>");
        out.println("function createSnowflake() {");
        out.println("    const snowflake = document.createElement('div');");
        out.println("    snowflake.classList.add('snowflake');");
        out.println("    snowflake.innerHTML = '❄';");
        out.println("    snowflake.style.left = Math.random() * 100 + '%';");
        out.println("    snowflake.style.animationDuration = (Math.random() * 3 + 2) + 's';");
        out.println("    snowflake.style.fontSize = (Math.random() * 1 + 0.5) + 'em';");
        out.println("    document.body.appendChild(snowflake);");
        out.println("    setTimeout(() => snowflake.remove(), 5000);");
        out.println("}");
        out.println("setInterval(createSnowflake, 200);");
        out.println("</script>");
        
        out.println("</body></html>");
    }
}