import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetreiveJobsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Logger logger = Logger.getLogger(RetreiveJobsServlet.class.getName());
        String url = "jdbc:mysql://192.168.7.44:3306/nwr"; // Replace mydatabase with your database name
        String username = "nwr"; // Replace your-username with your MySQL username
        String password = "password"; // Replace your-password with your MySQL password

        String permitNumber = request.getParameter("permitNumber");
        String sqlPermitData = "SELECT * FROM permit_data WHERE permitNumber = ?";
	logger.info("Received request with permitNumber: " + permitNumber);

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	    logger.finest("Executing SQL query: " + sqlPermitData);
            PreparedStatement selPermitData = conn.prepareStatement(sqlPermitData);
            selPermitData.setString(1, permitNumber);
	    ResultSet rsPermitData = selPermitData.executeQuery();
	    logger.info("SQL query executed successfully " + selPermitData);

	    response.setContentType("text/plain");
	    logger.info("Setting response content type: " + response.getContentType());
            PrintWriter out = response.getWriter();
            while (rsPermitData.next()) {
		StringBuilder row = new StringBuilder();
                for (int i = 1; i <= rsPermitData.getMetaData().getColumnCount(); i++) {
		    String columnValue = rsPermitData.getString(i);
                    row.append(String.format("%-20s", columnValue)).append("\t");
                }
		String permitData = "Permit Data: " + row.toString();
		logger.info(permitData);
		out.print(row.toString());
            }
	} catch (SQLException e) {
	    logger.severe("Error executing SQL query: " + sqlPermitData + ". Error message: " + e.getMessage());
            response.getWriter().println("Error: " + e.getMessage());
	}
    }
}
