<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
    <title>Christmas Character Directory</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Georgia', serif;
            background: linear-gradient(to bottom, #0a1f3d 0%, #1a3a5c 50%, #0f2438 100%);
            min-height: 100vh;
            padding: 50px 20px;
            position: relative;
        }
        
        body::before {
            content: '';
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-image: 
                radial-gradient(2px 2px at 20% 30%, white, transparent),
                radial-gradient(2px 2px at 60% 70%, white, transparent),
                radial-gradient(1px 1px at 50% 50%, white, transparent),
                radial-gradient(1px 1px at 80% 10%, white, transparent),
                radial-gradient(2px 2px at 90% 60%, white, transparent);
            background-size: 200% 200%;
            animation: twinkle 4s ease-in-out infinite;
            opacity: 0.6;
            pointer-events: none;
        }
        
        @keyframes twinkle {
            0%, 100% { opacity: 0.3; }
            50% { opacity: 0.7; }
        }
        
        .container {
            max-width: 1200px;
            margin: 0 auto;
            position: relative;
            z-index: 1;
        }
        
        h1 {
            text-align: center;
            font-size: 3.5em;
            color: #ffffff;
            text-shadow: 
                0 0 20px rgba(255, 215, 0, 0.8),
                0 0 40px rgba(220, 20, 60, 0.6),
                2px 2px 4px rgba(0, 0, 0, 0.8);
            margin-bottom: 10px;
            letter-spacing: 3px;
            font-weight: bold;
        }
        
        .subtitle {
            text-align: center;
            color: #c9e4ff;
            font-size: 1.3em;
            margin-bottom: 50px;
            font-style: italic;
            text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.7);
        }
        
        .ornaments {
            text-align: center;
            font-size: 2.5em;
            margin-bottom: 30px;
            letter-spacing: 15px;
        }
        
        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 
                0 20px 60px rgba(0, 0, 0, 0.6),
                0 0 0 1px rgba(255, 215, 0, 0.2);
        }
        
        thead {
            background: linear-gradient(135deg, #b71c1c 0%, #1b5e20 50%, #b71c1c 100%);
        }
        
        th {
            color: #ffd700;
            padding: 20px;
            font-size: 1.2em;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 2px;
            border-bottom: 3px solid #ffd700;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8);
        }
        
        tbody tr {
            transition: all 0.3s ease;
            border-bottom: 1px solid rgba(0, 0, 0, 0.1);
        }
        
        tbody tr:nth-child(odd) {
            background: rgba(27, 94, 32, 0.08);
        }
        
        tbody tr:nth-child(even) {
            background: rgba(183, 28, 28, 0.08);
        }
        
        tbody tr:hover {
            background: rgba(255, 215, 0, 0.15);
            transform: scale(1.01);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        
        td {
            padding: 18px 20px;
            color: #2c3e50;
            font-size: 1.05em;
        }
        
        td:first-child {
            font-weight: bold;
            color: #c62828;
            font-size: 1.3em;
            text-align: center;
            width: 100px;
        }
        
        td:nth-child(2) {
            font-weight: 600;
            color: #1565c0;
            font-size: 1.15em;
        }
        
        td:nth-child(3) {
            color: #424242;
            font-style: italic;
        }
        
        .footer {
            text-align: center;
            margin-top: 50px;
            color: #ffffff;
            font-size: 1.8em;
            text-shadow: 
                0 0 10px rgba(255, 215, 0, 0.8),
                2px 2px 4px rgba(0, 0, 0, 0.8);
            letter-spacing: 2px;
        }
        
        .lights-container {
            display: flex;
            justify-content: center;
            gap: 30px;
            margin-bottom: 40px;
        }
        
        .light {
            width: 20px;
            height: 30px;
            border-radius: 50% 50% 50% 50% / 60% 60% 40% 40%;
            animation: blink 1.5s infinite;
            box-shadow: 0 0 15px currentColor;
        }
        
        .light:nth-child(1) { background: #e53935; animation-delay: 0s; }
        .light:nth-child(2) { background: #43a047; animation-delay: 0.3s; }
        .light:nth-child(3) { background: #1e88e5; animation-delay: 0.6s; }
        .light:nth-child(4) { background: #fdd835; animation-delay: 0.9s; }
        .light:nth-child(5) { background: #fb8c00; animation-delay: 1.2s; }
        
        @keyframes blink {
            0%, 100% { opacity: 1; transform: scale(1); }
            50% { opacity: 0.4; transform: scale(0.95); }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🎄 Christmas Character Directory 🎅</h1>
        <p class="subtitle">North Pole Personnel Database - Season 2024</p>
        
        <div class="lights-container">
            <div class="light"></div>
            <div class="light"></div>
            <div class="light"></div>
            <div class="light"></div>
            <div class="light"></div>
        </div>
        
        <div class="ornaments">❄️ ⭐ 🎁 ⛄ 🔔</div>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Character Name</th>
                    <th>Role Description</th>
                </tr>
            </thead>
            <tbody>
                <xsl:for-each select="bio/user">
                    <tr>
                        <td><xsl:value-of select="id"/></td>
                        <td><xsl:value-of select="name"/></td>
                        <td>
                            <xsl:choose>
                                <xsl:when test="description">
                                    <xsl:value-of select="description"/>
                                </xsl:when>
                                <xsl:otherwise>
                                    Special Christmas Helper
                                </xsl:otherwise>
                            </xsl:choose>
                        </td>
                    </tr>
                </xsl:for-each>
            </tbody>
        </table>
        
        <div class="footer">★ Merry Christmas &amp; Happy Holidays ★</div>
    </div>
</body>
</html>
</xsl:template>
</xsl:stylesheet>