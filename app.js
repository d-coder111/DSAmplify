import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class App {
    // In-memory storage for contributors
    private static Map<String, String> contributors = new HashMap<>();

    public static void main(String[] args) {
        // Sample data for contributors (in a real app, this would come from a database)
        contributors.put("Alice", "Implemented sorting algorithms in C++ and Java.");
        contributors.put("Bob", "Developed the web interface for contributors' display.");
        contributors.put("Charlie", "Added Python solutions for common data structure problems.");

        // Home route
        get("/home", (req, res) -> {
            res.type("text/html");
            return "<h1>Welcome to DSAmplify Home</h1><p>This is the home page for DSA resources.</p>";
        });

        // About route
        get("/about", (req, res) -> {
            res.type("text/html");
            return "<h1>About DSAmplify</h1><p>DSAmplify is a project focused on solving DSA problems.</p>";
        });

        // Contributors route - dynamically loads contributors list
        get("/contributors", (req, res) -> {
            res.type("text/html");
            StringBuilder contributorsPage = new StringBuilder("<h1>Our Contributors</h1><ul>");
            for (Map.Entry<String, String> entry : contributors.entrySet()) {
                contributorsPage.append("<li><strong>")
                        .append(entry.getKey())
                        .append("</strong> - ")
                        .append(entry.getValue())
                        .append("</li>");
            }
            contributorsPage.append("</ul>");
            return contributorsPage.toString();
        });

        // Contact route
        get("/contact", (req, res) -> {
            res.type("text/html");
            return "<h1>Contact Us</h1><p>Email us at support@dsamplify.com</p>";
        });

        // API endpoint to get all contributors as JSON (if needed for frontend integration)
        get("/api/contributors", (req, res) -> {
            res.type("application/json");
            return contributors;
        });
    }
}
