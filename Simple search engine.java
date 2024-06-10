
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchEngine")
public class SearchEngine extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "user";
    private static final String PASS = "password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<String> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); PreparedStatement stmt = conn.prepareStatement("SELECT url FROM websites WHERE keywords LIKE ?")) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(rs.getString("url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("results", results);
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}
