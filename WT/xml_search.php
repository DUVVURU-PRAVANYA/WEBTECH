<?php
if ($_POST) {
    $searchId = $_POST['id'];
    
    // Load XML file
    $dom = new DOMDocument();
    $dom->load('users.xml');
    
    // Get all user elements
    $users = $dom->getElementsByTagName('user');
    
    $found = false;
    
    // HTML output with Christmas theme
    echo '<!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Search Results</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            
            body {
                font-family: "Georgia", serif;
                background: linear-gradient(to bottom, #0a1f3d 0%, #1a3a5c 50%, #0f2438 100%);
                min-height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 40px;
                position: relative;
            }
            
            body::before {
                content: "";
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-image: 
                    radial-gradient(2px 2px at 20% 30%, white, transparent),
                    radial-gradient(2px 2px at 60% 70%, white, transparent),
                    radial-gradient(1px 1px at 50% 50%, white, transparent);
                background-size: 200% 200%;
                animation: twinkle 4s ease-in-out infinite;
                opacity: 0.5;
                pointer-events: none;
            }
            
            @keyframes twinkle {
                0%, 100% { opacity: 0.3; }
                50% { opacity: 0.6; }
            }
            
            .container {
                background: rgba(255, 255, 255, 0.97);
                padding: 50px 70px;
                border-radius: 20px;
                box-shadow: 
                    0 30px 80px rgba(0, 0, 0, 0.7),
                    0 0 0 1px rgba(255, 215, 0, 0.3);
                text-align: center;
                max-width: 750px;
                position: relative;
                z-index: 10;
            }
            
            h1 {
                font-size: 2.5em;
                color: #b71c1c;
                margin-bottom: 30px;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
            }
            
            .success-icon {
                font-size: 4em;
                margin-bottom: 20px;
            }
            
            .error-icon {
                font-size: 4em;
                margin-bottom: 20px;
            }
            
            table {
                width: 100%;
                border-collapse: separate;
                border-spacing: 0;
                margin: 30px 0;
                border-radius: 12px;
                overflow: hidden;
                box-shadow: 0 8px 25px rgba(0, 0, 0, 0.3);
            }
            
            th {
                background: linear-gradient(135deg, #b71c1c 0%, #1b5e20 100%);
                color: #ffd700;
                padding: 18px;
                font-size: 1.2em;
                font-weight: bold;
                text-transform: uppercase;
                letter-spacing: 1px;
                text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.5);
            }
            
            td {
                background: #ffffff;
                color: #2c3e50;
                padding: 18px;
                font-size: 1.1em;
                border-bottom: 1px solid #e0e0e0;
            }
            
            td:first-child {
                font-weight: 600;
                color: #1565c0;
                background: rgba(21, 101, 192, 0.08);
                text-align: left;
                width: 35%;
            }
            
            td:last-child {
                text-align: left;
                font-weight: 500;
            }
            
            .error-message {
                color: #c62828;
                font-size: 1.3em;
                margin: 20px 0;
                font-weight: 600;
            }
            
            .hint {
                color: #757575;
                font-size: 1.1em;
                margin-top: 10px;
                font-style: italic;
            }
            
            .back-btn {
                display: inline-block;
                margin-top: 35px;
                padding: 14px 40px;
                background: linear-gradient(135deg, #b71c1c 0%, #1b5e20 100%);
                color: #ffffff;
                text-decoration: none;
                border-radius: 10px;
                font-size: 1.2em;
                font-weight: bold;
                transition: all 0.3s ease;
                box-shadow: 0 6px 20px rgba(0, 0, 0, 0.3);
            }
            
            .back-btn:hover {
                transform: translateY(-3px);
                box-shadow: 0 10px 30px rgba(0, 0, 0, 0.4);
                background: linear-gradient(135deg, #c62828 0%, #2e7d32 100%);
            }
            
            .lights-container {
                display: flex;
                justify-content: center;
                gap: 18px;
                margin: 25px 0;
            }
            
            .light {
                width: 16px;
                height: 26px;
                border-radius: 50% 50% 50% 50% / 60% 60% 40% 40%;
                animation: blink 1.5s infinite;
                box-shadow: 0 0 12px currentColor;
            }
            
            .light:nth-child(1) { background: #e53935; animation-delay: 0s; }
            .light:nth-child(2) { background: #43a047; animation-delay: 0.3s; }
            .light:nth-child(3) { background: #1e88e5; animation-delay: 0.6s; }
            .light:nth-child(4) { background: #fdd835; animation-delay: 0.9s; }
            .light:nth-child(5) { background: #fb8c00; animation-delay: 1.2s; }
            
            @keyframes blink {
                0%, 100% { opacity: 1; }
                50% { opacity: 0.3; }
            }
        </style>
    </head>
    <body>
        <div class="container">';
    
    // Loop through all users
    foreach ($users as $user) {
        $id = $user->getElementsByTagName('id')->item(0)->nodeValue;
        $name = $user->getElementsByTagName('name')->item(0)->nodeValue;
        
        // Check if description exists
        $descNode = $user->getElementsByTagName('description')->item(0);
        $description = ($descNode) ? $descNode->nodeValue : "Special Christmas Helper";
        
        // Match search ID
        if ($id == $searchId) {
            $found = true;
            echo '<div class="success-icon">🎉</div>';
            echo '<h1>Character Found!</h1>';
            
            echo '<div class="lights-container">
                <div class="light"></div>
                <div class="light"></div>
                <div class="light"></div>
                <div class="light"></div>
                <div class="light"></div>
            </div>';
            
            echo '<table>';
            echo '<tr><th colspan="2">Character Details</th></tr>';
            echo '<tr><td>ID</td><td>' . htmlspecialchars($id) . '</td></tr>';
            echo '<tr><td>Character Name</td><td>' . htmlspecialchars($name) . '</td></tr>';
            echo '<tr><td>Role Description</td><td>' . htmlspecialchars($description) . '</td></tr>';
            echo '</table>';
            break;
        }
    }
    
    if (!$found) {
        echo '<div class="error-icon">❌</div>';
        echo '<h1>Character Not Found</h1>';
        echo '<p class="error-message">No character exists with ID: ' . htmlspecialchars($searchId) . '</p>';
        echo '<p class="hint">🎄 Please search for IDs between 1 and 10</p>';
    }
    
    echo '<a href="xml_search.html" class="back-btn">🔙 Back to Search</a>';
    echo '</div></body></html>';
}
?>