import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertJobsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://192.168.7.44:3306/nwr"; // Replace mydatabase with your database name
        String username = "nwr"; // Replace your-username with your MySQL username
        String password = "password"; // Replace your-password with your MySQL password

        int lotNumber = Integer.parseInt(request.getParameter("lotNumber"));
        String permitNumber = request.getParameter("permitNumber");
        String locationId = request.getParameter("locationId");
	String uBuilderDate = request.getParameter("uBuilderDate");
	String uStartDate = request.getParameter("uStartDate");
	String uCompletedDate = request.getParameter("uCompletedDate");
	String uInspectionDate = request.getParameter("uInspectionDate");
	String uResults = request.getParameter("uResults");
	String uNotes = request.getParameter("uNotes");
	String rBuilderDate = request.getParameter("rBuilderDate");
        String rStartDate = request.getParameter("rStartDate");
        String rCompletedDate = request.getParameter("rCompletedDate");
        String rInspectionDate = request.getParameter("rInspectionDate");
        String rResults = request.getParameter("rResults");
        String rNotes = request.getParameter("rNotes");
	String fBuilderDate = request.getParameter("fBuilderDate");
        String fStartDate = request.getParameter("fStartDate");
        String fCompletedDate = request.getParameter("fCompletedDate");
        String fInspectionDate = request.getParameter("fInspectionDate");
        String fResults = request.getParameter("fResults");
        String fNotes = request.getParameter("fNotes");
	String pBuilderDate = request.getParameter("pBuilderDate");
        String pStartDate = request.getParameter("pStartDate");
        String pCompletedDate = request.getParameter("pCompletedDate");
        String pInspectionDate = request.getParameter("pInspectionDate");
        String pResults = request.getParameter("pResults");
        String pNotes = request.getParameter("pNotes");

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sqlJobs = "INSERT INTO jobs (lotNumber, permitNumber, locationId) VALUES (?, ?, ?)";
            PreparedStatement stmtJobs = conn.prepareStatement(sqlJobs);
            stmtJobs.setInt(1, lotNumber);
            stmtJobs.setString(2, permitNumber);
            stmtJobs.setString(3, locationId);
            int jRowsAffected = stmtJobs.executeUpdate();

	    String sqlUnderground = "INSERT INTO underground (permitNumber, builder_date, date_started, date_completed, inspection_requested, results) VALUES (?, ?, ?, ?, ?, ?)";
	    PreparedStatement stmtUnderground = conn.prepareStatement(sqlUnderground);
	    stmtUnderground.setString(1, permitNumber);
	    if (uBuilderDate == null) {
		    stmtUnderground.setNull(2, java.sql.Types.VARCHAR);
	    } else {
		    stmtUnderground.setString(2, uBuilderDate);
	    }
	    if (uStartDate == null) {
                    stmtUnderground.setNull(3, java.sql.Types.VARCHAR);
            } else {
                    stmtUnderground.setString(3, uStartDate);
            }
	    if (uCompletedDate == null) {
                    stmtUnderground.setNull(4, java.sql.Types.VARCHAR);
            } else {
                    stmtUnderground.setString(4, uCompletedDate);
            }
	    if (uInspectionDate == null) {
                    stmtUnderground.setNull(5, java.sql.Types.VARCHAR);
            } else {
                    stmtUnderground.setString(5, uInspectionDate);
            }
	    if (uResults == null) {
                    stmtUnderground.setNull(6, java.sql.Types.VARCHAR);
            } else {
                    stmtUnderground.setString(6, uResults);
            }
	    int uRowsAffected = stmtUnderground.executeUpdate();

            String sqlRough = "INSERT INTO rough (permitNumber, builder_date, date_started, date_completed, inspection_requested, results) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtRough = conn.prepareStatement(sqlRough);
            stmtRough.setString(1, permitNumber);
            if (rBuilderDate == null) {
                    stmtRough.setNull(2, java.sql.Types.VARCHAR);
            } else {
                    stmtRough.setString(2, rBuilderDate);
            }
            if (rStartDate == null) {
                    stmtRough.setNull(3, java.sql.Types.VARCHAR);
            } else {
                    stmtRough.setString(3, rStartDate);
            }
            if (rCompletedDate == null) {
                    stmtRough.setNull(4, java.sql.Types.VARCHAR);
            } else {
                    stmtRough.setString(4, rCompletedDate);
            }
            if (rInspectionDate == null) {
                    stmtRough.setNull(5, java.sql.Types.VARCHAR);
            } else {
                    stmtRough.setString(5, rInspectionDate);
            }
            if (rResults == null) {
                    stmtRough.setNull(6, java.sql.Types.VARCHAR);
            } else {
                    stmtRough.setString(6, rResults);
            }
            int rRowsAffected = stmtRough.executeUpdate();
            
	    String sqlFinish = "INSERT INTO finish (permitNumber, builder_date, date_started, date_completed, inspection_requested, results) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtFinish = conn.prepareStatement(sqlFinish);
            stmtFinish.setString(1, permitNumber);
            if (fBuilderDate == null) {
                    stmtFinish.setNull(2, java.sql.Types.VARCHAR);
            } else {
                    stmtFinish.setString(2, fBuilderDate);
            }
            if (fStartDate == null) {
                    stmtFinish.setNull(3, java.sql.Types.VARCHAR);
            } else {
                    stmtFinish.setString(3, fStartDate);
            }
            if (fCompletedDate == null) {
                    stmtFinish.setNull(4, java.sql.Types.VARCHAR);
            } else {
                    stmtFinish.setString(4, fCompletedDate);
            }
            if (fInspectionDate == null) {
                    stmtFinish.setNull(5, java.sql.Types.VARCHAR);
            } else {
                    stmtFinish.setString(5, fInspectionDate);
            }
            if (fResults == null) {
                    stmtFinish.setNull(6, java.sql.Types.VARCHAR);
            } else {
                    stmtFinish.setString(6, fResults);
            }
            int fRowsAffected = stmtFinish.executeUpdate();

            String sqlPunch = "INSERT INTO punch (permitNumber, builder_date, date_started, date_completed, inspection_requested, results) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtPunch = conn.prepareStatement(sqlPunch);
            stmtPunch.setString(1, permitNumber);
            if (pBuilderDate == null) {
                    stmtPunch.setNull(2, java.sql.Types.VARCHAR);
            } else {
                    stmtPunch.setString(2, pBuilderDate);
            }   
            if (pStartDate == null) {
                    stmtPunch.setNull(3, java.sql.Types.VARCHAR);
            } else {
                    stmtPunch.setString(3, pStartDate);
            }   
            if (pCompletedDate == null) {
                    stmtPunch.setNull(4, java.sql.Types.VARCHAR);
            } else {
                    stmtPunch.setString(4, pCompletedDate);
            }   
            if (pInspectionDate == null) {
                    stmtPunch.setNull(5, java.sql.Types.VARCHAR);
            } else {
                    stmtPunch.setString(5, pInspectionDate);
            }   
            if (pResults == null) {
                    stmtPunch.setNull(6, java.sql.Types.VARCHAR);
            } else {
                    stmtPunch.setString(6, pResults);
            }   
            int pRowsAffected = stmtPunch.executeUpdate();

            String sqlUndergroundNotes = "INSERT INTO notes (lotNumber, permitNumber, locationId, notes, undergroundId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtUndergroundNotes = conn.prepareStatement(sqlUndergroundNotes);

            if (uNotes != null) {
                stmtUndergroundNotes.setInt(1, lotNumber);
                stmtUndergroundNotes.setString(2, permitNumber);
                stmtUndergroundNotes.setString(3, locationId);
                stmtUndergroundNotes.setString(4, uNotes);

                // Retrieve the corresponding underground ID and set it as the foreign key for the note
                String query = "SELECT undergroundId FROM underground WHERE permitNumber = ?";
                PreparedStatement selUnderground = conn.prepareStatement(query);
                selUnderground.setString(1, permitNumber);
                ResultSet rsUnderground = selUnderground.executeQuery();

                if (rsUnderground.next()) {
                    stmtUndergroundNotes.setInt(5, rsUnderground.getInt("undergroundId"));
                } else {
                    stmtUndergroundNotes.setNull(5, java.sql.Types.INTEGER);
                }

                // Execute the INSERT statement for underground notes
                stmtUndergroundNotes.executeUpdate();
            }

            String sqlRoughNotes = "INSERT INTO notes (lotNumber, permitNumber, locationId, notes, roughId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtRoughNotes = conn.prepareStatement(sqlRoughNotes);

            if (rNotes != null) {
                stmtRoughNotes.setInt(1, lotNumber);
                stmtRoughNotes.setString(2, permitNumber);
                stmtRoughNotes.setString(3, locationId);
                stmtRoughNotes.setString(4, rNotes);

                // Retrieve the corresponding underground ID and set it as the foreign key for the note
                String query = "SELECT roughId FROM rough WHERE permitNumber = ?";
                PreparedStatement selRough = conn.prepareStatement(query);
                selRough.setString(1, permitNumber);
                ResultSet rsRough = selRough.executeQuery();

                if (rsRough.next()) {
                    stmtRoughNotes.setInt(5, rsRough.getInt("roughId"));
                } else {
                    stmtRoughNotes.setNull(5, java.sql.Types.INTEGER);
                }

                // Execute the INSERT statement for underground notes
                stmtRoughNotes.executeUpdate();
            }

            String sqlFinishNotes = "INSERT INTO notes (lotNumber, permitNumber, locationId, notes, finishId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtFinishNotes = conn.prepareStatement(sqlFinishNotes);

            if (fNotes != null) {
                stmtFinishNotes.setInt(1, lotNumber);
                stmtFinishNotes.setString(2, permitNumber);
                stmtFinishNotes.setString(3, locationId);
                stmtFinishNotes.setString(4, fNotes);
   
                // Retrieve the corresponding underground ID and set it as the foreign key for the note
                String query = "SELECT finishId FROM finish WHERE permitNumber = ?";
                PreparedStatement selFinish = conn.prepareStatement(query);
                selFinish.setString(1, permitNumber);
                ResultSet rsFinish = selFinish.executeQuery();

                if (rsFinish.next()) {
                    stmtFinishNotes.setInt(5, rsFinish.getInt("finishId"));
                } else {
                    stmtFinishNotes.setNull(5, java.sql.Types.INTEGER);
                }

                // Execute the INSERT statement for underground notes
                stmtFinishNotes.executeUpdate();
            }

            String sqlPunchNotes = "INSERT INTO notes (lotNumber, permitNumber, locationId, notes, punchId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtPunchNotes = conn.prepareStatement(sqlPunchNotes);

            if (pNotes != null) {
                stmtPunchNotes.setInt(1, lotNumber);
                stmtPunchNotes.setString(2, permitNumber);
                stmtPunchNotes.setString(3, locationId);
                stmtPunchNotes.setString(4, pNotes);
   
                // Retrieve the corresponding underground ID and set it as the foreign key for the note
                String query = "SELECT punchId FROM punch WHERE permitNumber = ?";
                PreparedStatement selPunch = conn.prepareStatement(query);
                selPunch.setString(1, permitNumber);
                ResultSet rsPunch = selPunch.executeQuery();

                if (rsPunch.next()) {
                    stmtPunchNotes.setInt(5, rsPunch.getInt("punchId"));
                } else {
                    stmtPunchNotes.setNull(5, java.sql.Types.INTEGER);
                }

                // Execute the INSERT statement for underground notes
                stmtPunchNotes.executeUpdate();
            }

            response.getWriter().println("Rows affected (jobs): " + jRowsAffected);
            response.getWriter().println("Rows affected (underground): " + uRowsAffected);
	    response.getWriter().println("Rows affected (rough): " + rRowsAffected);
	    response.getWriter().println("Rows affected (finish): " + fRowsAffected);
	    response.getWriter().println("Rows affected (punch): " + pRowsAffected);
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
