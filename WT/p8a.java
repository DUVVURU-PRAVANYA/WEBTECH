import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p8a extends HttpServlet {
    private int totalVisits = 0; // Track all visitors to Santa's Workshop

    public synchronized void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        totalVisits++; // Increment counter for every visit

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>🎄 Santa's Workshop Visitor Counter 🎅</title>");
        out.println("<style>");
        out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
        
        out.println("@keyframes snowfall {");
        out.println("    0% { transform: translateY(-10px) rotate(0deg); opacity: 1; }");
        out.println("    100% { transform: translateY(100vh) rotate(360deg); opacity: 0.8; }");
        out.println("}");
        
        out.println("@keyframes glow {");
        out.println("    0%, 100% { text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #ff0000; }");
        out.println("    50% { text-shadow: 0 0 20px #fff, 0 0 40px #ff0000; }");
        out.println("}");
        
        out.println("@keyframes pulse {");
        out.println("    0%, 100% { transform: scale(1); }");
        out.println("    50% { transform: scale(1.1); }");
        out.println("}");
        
        out.println("body { font-family: Georgia, serif; background: linear-gradient(180deg, #0f2027, #203a43, #2c5364); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; position: relative; overflow: hidden; }");
        
        out.println(".snowflake { position: absolute; top: -10px; color: white; font-size: 1.5em; opacity: 0.8; animation: snowfall linear infinite; pointer-events: none; }");
        
        out.println(".container { background: linear-gradient(135deg, rgba(139, 0, 0, 0.9), rgba(220, 20, 60, 0.9)); padding: 60px 50px; border-radius: 30px; text-align: center; box-shadow: 0 15px 50px rgba(255, 215, 0, 0.4), inset 0 0 30px rgba(255, 255, 255, 0.2); max-width: 600px; border: 3px solid gold; position: relative; z-index: 10; }");
        
        out.println("h1 { color: #fff; margin-bottom: 30px; font-size: 2.5em; animation: glow 2s ease-in-out infinite; }");
        
        out.println(".counter-box { background: rgba(255, 255, 255, 0.95); padding: 30px; border-radius: 20px; margin-top: 30px; box-shadow: 0 8px 25px rgba(0, 0, 0, 0.3); border: 2px solid #ffd700; }");
        
        out.println(".counter-label { color: #8b0000; font-size: 1.3em; font-weight: bold; margin-bottom: 15px; }");
        
        out.println(".count { font-size: 3em; color: #228b22; font-weight: bold; animation: pulse 2s ease-in-out infinite; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); }");
        
        out.println(".message { color: #ffd700; font-size: 1.2em; margin-top: 25px; font-style: italic; }");
        
        out.println(".ornament { position: absolute; font-size: 2em; animation: glow 1.5s ease-in-out infinite; }");
        out.println(".ornament-1 { top: 20px; left: 20px; }");
        out.println(".ornament-2 { top: 20px; right: 20px; }");
        out.println(".ornament-3 { bottom: 20px; left: 30px; }");
        out.println(".ornament-4 { bottom: 20px; right: 30px; }");
        
        out.println("</style></head><body>");
        
        out.println("<div class='container'>");
        out.println("<div class='ornament ornament-1'>🔴</div>");
        out.println("<div class='ornament ornament-2'>🟡</div>");
        out.println("<div class='ornament ornament-3'>🔵</div>");
        out.println("<div class='ornament ornament-4'>🟢</div>");
        
        out.println("<h1>🎅 Welcome to Santa's Workshop! 🎄</h1>");
        
        out.println("<div class='counter-box'>");
        out.println("<div class='counter-label'>🎁 Total Workshop Visitors 🎁</div>");
        out.println("<div class='count'>" + totalVisits + "</div>");
        out.println("</div>");
        
        out.println("<p class='message'>Ho Ho Ho! Merry Christmas to all! 🌟</p>");
        
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