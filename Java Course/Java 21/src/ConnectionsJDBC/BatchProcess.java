package ConnectionsJDBC;

import java.sql.*;

public class BatchProcess {

    public static void main(String[] args) {
        

        String url =
            "jdbc:postgresql://localhost:5432/Java";

        String username = "postgres";
        String password = "sudhanshu@26022004";

        String sql =
            "INSERT INTO employee(name, salary) " +
            "VALUES (?, ?)";

        try (
            Connection con =
                DriverManager.getConnection(
                    url,
                    username,
                    password
                );

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            // Employee 1
            ps.setString(1, "Ashutosh");
            ps.setDouble(2, 50000);
            ps.addBatch();

            // Employee 2
            ps.setString(1, "Amit");
            ps.setDouble(2, 60000);
            ps.addBatch();

            // Employee 3
            ps.setString(1, "Priya");
            ps.setDouble(2, 55000);
            ps.addBatch();

            // Execute all statements
            int[] results = ps.executeBatch();

            System.out.println(
                "Batch executed successfully!"
            );

            System.out.println(
                "Number of operations: "
                + results.length
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
