package ConnectionsJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

    public static void main(String[] args) {

        // PostgreSQL database URL
        String url = "jdbc:postgresql://localhost:5432/Java";

        // PostgreSQL username
        String username = "postgres";

        // PostgreSQL password
        String password = "sudhanshu@26022004";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Connected to PostgreSQL successfully!");

            // Close connection
            con.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
