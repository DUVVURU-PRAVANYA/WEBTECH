import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg8 extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Set UTF-8 encoding for proper Christmas emojis
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            
            PrintWriter pwriter = response.getWriter();
            
            // Get session data (same logic as original)
            HttpSession session = request.getSession(false);
            String myName = (String) session.getAttribute("uname");
            String myPass = (String) session.getAttribute("upass");
            
            // Output the complete HTML as a single string to ensure proper rendering
            String htmlContent = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <title>🎅 Santa's Session Workshop - " + myName + " 🎅</title>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <style>\n" +
            "        * { margin: 0; padding: 0; box-sizing: border-box; }\n" +
            "\n" +
            "        body {\n" +
            "            background: #0f3460;\n" +
            "            background: -webkit-linear-gradient(135deg, #0f3460, #16537e, #1e6091);\n" +
            "            background: -moz-linear-gradient(135deg, #0f3460, #16537e, #1e6091);\n" +
            "            background: linear-gradient(135deg, #0f3460, #16537e, #1e6091);\n" +
            "            font-family: 'Georgia', serif;\n" +
            "            min-height: 100vh;\n" +
            "            display: flex;\n" +
            "            justify-content: center;\n" +
            "            align-items: center;\n" +
            "            color: #fff;\n" +
            "            position: relative;\n" +
            "            overflow-x: hidden;\n" +
            "            padding: 20px;\n" +
            "        }\n" +
            "\n" +
            "        body::before {\n" +
            "            content: '';\n" +
            "            position: absolute;\n" +
            "            top: 0; left: 0;\n" +
            "            width: 100%; height: 100%;\n" +
            "            background-image: \n" +
            "                radial-gradient(2px 2px at 20px 30px, #fff, transparent),\n" +
            "                radial-gradient(2px 2px at 40px 70px, rgba(255,255,255,0.8), transparent),\n" +
            "                radial-gradient(1px 1px at 90px 40px, #fff, transparent),\n" +
            "                radial-gradient(1px 1px at 130px 80px, rgba(255,255,255,0.6), transparent),\n" +
            "                radial-gradient(2px 2px at 160px 30px, #fff, transparent);\n" +
            "            background-repeat: repeat;\n" +
            "            background-size: 200px 100px;\n" +
            "            animation: sparkle 8s linear infinite;\n" +
            "            opacity: 0.6;\n" +
            "            pointer-events: none;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes sparkle {\n" +
            "            0% { background-position: 0 0, 40px 60px, 130px 270px, 70px 100px, 180px 290px; }\n" +
            "            100% { background-position: 500px 1000px, 540px 1060px, 630px 1270px, 570px 1100px, 680px 1290px; }\n" +
            "        }\n" +
            "\n" +
            "        .christmas-container {\n" +
            "            background: rgba(255, 255, 255, 0.1);\n" +
            "            backdrop-filter: blur(15px);\n" +
            "            -webkit-backdrop-filter: blur(15px);\n" +
            "            border: 3px solid #ff6b6b;\n" +
            "            border-radius: 25px;\n" +
            "            padding: 40px;\n" +
            "            width: 90%; max-width: 600px;\n" +
            "            text-align: center;\n" +
            "            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3), inset 0 2px 10px rgba(255, 255, 255, 0.1);\n" +
            "            position: relative; z-index: 1;\n" +
            "            animation: containerGlow 4s ease-in-out infinite alternate;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes containerGlow {\n" +
            "            0% { box-shadow: 0 20px 40px rgba(0,0,0,0.3), inset 0 2px 10px rgba(255,255,255,0.1), 0 0 0 rgba(255,107,107,0); }\n" +
            "            100% { box-shadow: 0 20px 40px rgba(0,0,0,0.3), inset 0 2px 10px rgba(255,255,255,0.1), 0 0 30px rgba(255,107,107,0.3); }\n" +
            "        }\n" +
            "\n" +
            "        h1 {\n" +
            "            color: #ffed4a;\n" +
            "            text-shadow: 3px 3px 6px rgba(0,0,0,0.5);\n" +
            "            font-size: 2.5em;\n" +
            "            margin-bottom: 30px;\n" +
            "            animation: titleGlow 2s ease-in-out infinite alternate;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes titleGlow {\n" +
            "            0% { text-shadow: 3px 3px 6px rgba(0,0,0,0.5); }\n" +
            "            100% { text-shadow: 3px 3px 6px rgba(0,0,0,0.5), 0 0 15px #ffed4a, 0 0 25px #ffed4a; }\n" +
            "        }\n" +
            "\n" +
            "        .christmas-decorations {\n" +
            "            font-size: 2em;\n" +
            "            margin: 20px 0;\n" +
            "            animation: bounce 2s ease-in-out infinite;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes bounce {\n" +
            "            0%,20%,50%,80%,100%{transform:translateY(0);}\n" +
            "            40%{transform:translateY(-15px);}\n" +
            "            60%{transform:translateY(-7px);}\n" +
            "        }\n" +
            "\n" +
            "        .session-info-card {\n" +
            "            background: rgba(255, 255, 255, 0.05);\n" +
            "            padding: 30px;\n" +
            "            border-radius: 15px;\n" +
            "            margin: 25px 0;\n" +
            "            border: 1px solid rgba(255, 255, 255, 0.1);\n" +
            "            box-shadow: inset 0 2px 10px rgba(255, 255, 255, 0.1);\n" +
            "        }\n" +
            "\n" +
            "        .session-data {\n" +
            "            background: linear-gradient(135deg, #ff6b6b, #ff8e8e);\n" +
            "            color: white;\n" +
            "            padding: 25px;\n" +
            "            border-radius: 15px;\n" +
            "            margin: 20px 0;\n" +
            "            font-size: 1.3em;\n" +
            "            font-weight: bold;\n" +
            "            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);\n" +
            "            border: 2px solid #ff6b6b;\n" +
            "            animation: sessionGlow 2s ease-in-out infinite alternate;\n" +
            "            line-height: 1.6;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes sessionGlow {\n" +
            "            0% { box-shadow: 0 0 0 rgba(255, 107, 107, 0); }\n" +
            "            100% { box-shadow: 0 0 20px rgba(255, 107, 107, 0.5); }\n" +
            "        }\n" +
            "\n" +
            "        .info-item {\n" +
            "            margin-bottom: 12px;\n" +
            "            padding: 10px 0;\n" +
            "        }\n" +
            "\n" +
            "        .success-message {\n" +
            "            background: rgba(76, 175, 80, 0.8);\n" +
            "            color: #fff;\n" +
            "            padding: 20px;\n" +
            "            border-radius: 15px;\n" +
            "            margin: 20px 0;\n" +
            "            border: 2px solid #4caf50;\n" +
            "            font-size: 1.1em;\n" +
            "            animation: messageGlow 2s ease-in-out infinite alternate;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes messageGlow {\n" +
            "            0% { box-shadow: 0 0 0 rgba(76, 175, 80, 0); }\n" +
            "            100% { box-shadow: 0 0 20px rgba(76, 175, 80, 0.5); }\n" +
            "        }\n" +
            "\n" +
            "        .footer-message {\n" +
            "            margin-top: 30px;\n" +
            "            color: #bbe1fa;\n" +
            "            font-style: italic;\n" +
            "            font-size: 1.1em;\n" +
            "            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);\n" +
            "        }\n" +
            "\n" +
            "        @media (max-width: 768px) {\n" +
            "            .christmas-container { padding: 30px 20px; margin: 20px; max-width: 95%; }\n" +
            "            h1 { font-size: 2em; }\n" +
            "            .session-data { font-size: 1.1em; }\n" +
            "            .session-info-card { padding: 20px; }\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div class='christmas-container'>\n" +
            "        <div class='christmas-decorations'>&#127876;&#10024;&#127877;&#10024;&#127876;</div>\n" +
            "        \n" +
            "        <h1>&#127876; Santa's Session Workshop &#127876;</h1>\n" +
            "        \n" +
            "        <div class='success-message'>\n" +
            "            &#127877; Ho Ho Ho! Session data retrieved from Santa's magical database! &#10024;\n" +
            "        </div>\n" +
            "        \n" +
            "        <div class='session-info-card'>\n" +
            "            <div class='session-data'>\n" +
            "                <div class='info-item'>&#127876; Name: " + myName + " &#127876;</div>\n" +
            "                <div class='info-item'>&#128273; Pass: " + myPass + " &#128273;</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        \n" +
            "        <div class='christmas-decorations'>&#127873;&#127872;&#127873;&#127872;&#127873;</div>\n" +
            "        \n" +
            "        <div class='footer-message'>\n" +
            "            &#127876; Your Christmas session is secure in Santa's workshop! &#127876;\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>";
            
            pwriter.print(htmlContent);
            pwriter.close();
            
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}