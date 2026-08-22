package ConnectionsJDBC;

import java.sql.*;

public class TransactionIsolation {

    private static final String URL = "jdbc:postgresql://localhost:5432/Java";

    private static final String USER = "postgres";

    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        String updateSQL = "UPDATE employee SET salary = ? WHERE id = ?";

        String selectSQL = "SELECT salary FROM employee WHERE id = ?";

        try (
                Connection con1 = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD);

                Connection con2 = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD);

                PreparedStatement updatePS = con1.prepareStatement(updateSQL);

                PreparedStatement selectPS = con2.prepareStatement(selectSQL)) {

            // =====================================
            // TRANSACTION 1
            // =====================================

            con1.setAutoCommit(false);

            con1.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);

            // =====================================
            // TRANSACTION 2
            // =====================================

            con2.setAutoCommit(false);

            con2.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);

            // =====================================
            // TRANSACTION 1:
            // UPDATE salary
            // =====================================

            updatePS.setBigDecimal(
                    1,
                    new java.math.BigDecimal("100000"));

            updatePS.setInt(2, 1);

            updatePS.executeUpdate();

            System.out.println(
                    "Transaction 1: Salary updated to 100000");

            System.out.println(
                    "Transaction 1: NOT committed yet");

            // =====================================
            // TRANSACTION 2:
            // READ salary
            // =====================================

            selectPS.setInt(1, 1);

            ResultSet rs = selectPS.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "Transaction 2 sees salary: "
                                + rs.getBigDecimal("salary"));
            }

            // =====================================
            // TRANSACTION 1 COMMIT
            // =====================================

            con1.commit();

            System.out.println(
                    "Transaction 1 committed");

            // =====================================
            // TRANSACTION 2 READ AGAIN
            // =====================================

            rs.close();

            selectPS.setInt(1, 1);

            rs = selectPS.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "Transaction 2 now sees salary: "
                                + rs.getBigDecimal("salary"));
            }

            // Commit Transaction 2
            con2.commit();

            rs.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}