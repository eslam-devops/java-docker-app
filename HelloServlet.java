import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@WebServlet(name = "HealthServlet", urlPatterns = {"/"})
public class HelloServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(HelloServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LOGGER.info("Incoming request from IP: " + req.getRemoteAddr());

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("{");
        out.println("  \"service\": \"java-docker-demo\",");
        out.println("  \"status\": \"UP\",");
        out.println("  \"message\": \"Hello from Java Docker App 🚀\",");
        out.println("  \"timestamp\": \"" + LocalDateTime.now() + "\"");
        out.println("}");
        out.flush();
    }
}
