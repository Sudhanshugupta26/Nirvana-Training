package ConnectionsJDBC;

import java.sql.*;

public class DatabasesMetadata {

    public static void main(String[] args) {

        String url =
            "jdbc:postgresql://localhost:5432/Java";

        String username = "postgres";
        String password = "sudhanshu@26022004";

        try (Connection con =
                DriverManager.getConnection(
                    url,
                    username,
                    password
                )) {

            DatabaseMetaData metaData =
                con.getMetaData();

            System.out.println(
                "Database Name: "
                + metaData.getDatabaseProductName()
            );

            System.out.println(
                "Database Version: "
                + metaData.getDatabaseProductVersion()
            );

            System.out.println(
                "Driver Name: "
                + metaData.getDriverName()
            );

            System.out.println(
                "Driver Version: "
                + metaData.getDriverVersion()
            );

            System.out.println(
                "Username: "
                + metaData.getUserName()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}