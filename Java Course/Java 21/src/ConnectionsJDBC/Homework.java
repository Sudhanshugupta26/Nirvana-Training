package ConnectionsJDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Homework {
    private static final Logger LOGGER = Logger.getLogger(Homework.class.getName());

    public static void main(String[] args) throws SQLException {
        String url =
            "jdbc:postgresql://localhost:5432/Java";

        String username = "postgres";
        String password = "sudhanshu@26022004";
        if (password == null || password.isBlank()) {
            throw new IllegalStateException("DB_PASSWORD environment variable is not set");
        }

        try (
            Connection con =
                DriverManager.getConnection(
                    url,
                    username,
                    password
                );

            CallableStatement cs =
                con.prepareCall(
                    "CALL update_student_details(?, ?, ?, ?, ?, ?, ?, ?, ?)"
                )) {

            con.setAutoCommit(false);

            cs.setInt(1, 1);

            cs.setString(2, "Rahul Gupta");
            cs.setString(3, "rahul@gmail.com");
            cs.setInt(4, 22);

            cs.setString(5, "Gorakhpur");
            cs.setString(6, "Uttar Pradesh");

            cs.setString(7, "Computer Science Engineering");
            cs.setInt(8, 8);

            cs.registerOutParameter(9, Types.VARCHAR);

            cs.execute();
            con.commit();

            String status = cs.getString(9);

            LOGGER.log(Level.INFO, "Status: {0}", status);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database error while updating student details", e);
            throw new SQLException("Could not update student details", e);
        }
}
}
