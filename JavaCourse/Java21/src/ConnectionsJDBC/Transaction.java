package ConnectionsJDBC;

import java.sql.*;

public class Transaction {

    public static void main(String[] args) {

        String url ="jdbc:postgresql://localhost:5432/Java";

        String username = "postgres";
        String password = "sudhanshu@26022004";

        String withdraw =
            "UPDATE employee " +
            "SET salary = salary - ? " +
            "WHERE id = ?";

        String deposit =
            "UPDATE employee " +
            "SET salary = salary + ? " +
            "WHERE id = ?";

        try (Connection con =
                DriverManager.getConnection(
                    url,
                    username,
                    password
                )) {

            // Start transaction
            con.setAutoCommit(false);

            try (
                PreparedStatement ps1 =
                    con.prepareStatement(withdraw);

                PreparedStatement ps2 =
                    con.prepareStatement(deposit)
            ) {

                // Employee 1 loses 5000
                ps1.setDouble(1, 5000);
                ps1.setInt(2, 5);

                ps1.executeUpdate();

                // Employee 2 receives 5000
                ps2.setDouble(1, 5000);
                ps2.setInt(2, 6);

                ps2.executeUpdate();

                throw new SQLException("Simulated error"); // Simulate an error

                // Everything successful
                // con.commit();

                // System.out.println(
                //     "Transaction completed successfully!"
                // );

            } catch (SQLException e) {

                // Something failed
                con.rollback();

                System.out.println(
                    "Transaction failed. Changes rolled back."
                );

                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
