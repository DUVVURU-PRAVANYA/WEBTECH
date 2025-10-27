import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SProg7 extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pwriter = response.getWriter();
            
            String name = request.getParameter("userName");
            String password = request.getParameter("userPassword");
            
            // Create session and store user data
            HttpSession session = request.getSession();
            session.setAttribute("uname", name);
            session.setAttribute("upass", password);
            session.setAttribute("loginTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            session.setAttribute("christmasSpirit", "Ho Ho Ho! 🎅");
            
            // Output the complete HTML as a single string to ensure proper rendering
            String htmlContent = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <title>🎄 Christmas Magic Portal - Welcome " + name + "! 🎄</title>\n" +
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
            "            width: 90%; max-width: 700px;\n" +
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
            "            font-size: 2.8em;\n" +
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
            "        .user-info-card {\n" +
            "            background: rgba(255, 255, 255, 0.05);\n" +
            "            padding: 30px;\n" +
            "            border-radius: 15px;\n" +
            "            margin: 25px 0;\n" +
            "            border: 1px solid rgba(255, 255, 255, 0.1);\n" +
            "            text-align: left;\n" +
            "            box-shadow: inset 0 2px 10px rgba(255, 255, 255, 0.1);\n" +
            "        }\n" +
            "\n" +
            "        .info-item {\n" +
            "            margin-bottom: 15px;\n" +
            "            padding: 15px;\n" +
            "            background: rgba(76, 175, 80, 0.2);\n" +
            "            border-radius: 10px;\n" +
            "            border-left: 4px solid #4caf50;\n" +
            "            transition: all 0.3s ease;\n" +
            "        }\n" +
            "\n" +
            "        .info-item:hover {\n" +
            "            background: rgba(76, 175, 80, 0.3);\n" +
            "            transform: translateX(5px);\n" +
            "        }\n" +
            "\n" +
            "        .info-label {\n" +
            "            color: #bbe1fa;\n" +
            "            font-weight: bold;\n" +
            "            font-size: 1.1em;\n" +
            "            text-shadow: 1px 1px 2px rgba(0,0,0,0.5);\n" +
            "            margin-bottom: 5px;\n" +
            "        }\n" +
            "\n" +
            "        .info-value {\n" +
            "            color: #ffffff;\n" +
            "            font-size: 1em;\n" +
            "            font-weight: normal;\n" +
            "        }\n" +
            "\n" +
            "        .success-message {\n" +
            "            background: rgba(255, 107, 107, 0.8);\n" +
            "            color: #fff;\n" +
            "            padding: 20px;\n" +
            "            border-radius: 15px;\n" +
            "            margin: 20px 0;\n" +
            "            border: 2px solid #ff6b6b;\n" +
            "            font-size: 1.2em;\n" +
            "            animation: messageGlow 2s ease-in-out infinite alternate;\n" +
            "        }\n" +
            "\n" +
            "        @keyframes messageGlow {\n" +
            "            0% { box-shadow: 0 0 0 rgba(255, 107, 107, 0); }\n" +
            "            100% { box-shadow: 0 0 20px rgba(255, 107, 107, 0.5); }\n" +
            "        }\n" +
            "\n" +
            "        .christmas-link {\n" +
            "            display: inline-block;\n" +
            "            background: linear-gradient(45deg, #ff6b6b, #ff8e53);\n" +
            "            color: white;\n" +
            "            text-decoration: none;\n" +
            "            padding: 15px 40px;\n" +
            "            border-radius: 25px;\n" +
            "            font-size: 1.2em;\n" +
            "            font-weight: bold;\n" +
            "            margin-top: 25px;\n" +
            "            transition: all 0.3s ease;\n" +
            "            text-transform: uppercase;\n" +
            "            letter-spacing: 1px;\n" +
            "            box-shadow: 0 6px 20px rgba(255, 107, 107, 0.4);\n" +
            "            font-family: 'Georgia', serif;\n" +
            "        }\n" +
            "\n" +
            "        .christmas-link:hover {\n" +
            "            transform: translateY(-3px);\n" +
            "            box-shadow: 0 8px 25px rgba(255, 107, 107, 0.6);\n" +
            "            background: linear-gradient(45deg, #ff5252, #ff7043);\n" +
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
            "            h1 { font-size: 2.2em; }\n" +
            "            .christmas-link { padding: 12px 30px; font-size: 1.1em; }\n" +
            "            .user-info-card { padding: 20px; }\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div class='christmas-container'>\n" +
            "        <div class='christmas-decorations'>🎄✨🎅✨🎄</div>\n" +
            "        \n" +
            "        <h1>🎁 Welcome to Christmas Land, " + name + "! 🎁</h1>\n" +
            "        \n" +
            "        <div class='success-message'>\n" +
            "            🍪 Ho Ho Ho! Your magical Christmas session has been created! ✨\n" +
            "            <br><br>🎄 Get ready for some holiday magic! 🎄\n" +
            "        </div>\n" +
            "        \n" +
            "        <div class='user-info-card'>\n" +
            "            <h2 style='color: #ffed4a; text-align: center; margin-bottom: 20px; text-shadow: 2px 2px 4px rgba(0,0,0,0.5);'>🎉 Christmas Profile Details 🎉</h2>\n" +
            "            \n" +
            "            <div class='info-item'>\n" +
            "                <div class='info-label'>🎯 Christmas Elf Name:</div>\n" +
            "                <div class='info-value'>" + name + "</div>\n" +
            "            </div>\n" +
            "            \n" +
            "            <div class='info-item'>\n" +
            "                <div class='info-label'>🔐 Secret North Pole Access:</div>\n" +
            "                <div class='info-value'>Protected by Santa's Magic! ✨</div>\n" +
            "            </div>\n" +
            "            \n" +
            "            <div class='info-item'>\n" +
            "                <div class='info-label'>🕒 Magical Login Time:</div>\n" +
            "                <div class='info-value'>" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy 'at' HH:mm:ss")) + "</div>\n" +
            "            </div>\n" +
            "            \n" +
            "            <div class='info-item'>\n" +
            "                <div class='info-label'>🎅 Christmas Spirit Level:</div>\n" +
            "                <div class='info-value'>Maximum Ho Ho Ho! 🎄</div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        \n" +
            "        <a href='SP8' class='christmas-link'>🎄 View My Christmas Profile 🎅</a>\n" +
            "        \n" +
            "        <div class='footer-message'>\n" +
            "            🎊 May your Christmas session be filled with joy, wonder, and endless cookies! 🎊\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>";
            
            pwriter.print(htmlContent);
            pwriter.close();
            
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}