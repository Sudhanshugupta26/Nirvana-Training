package ConnectionsJDBC;

import java.math.BigDecimal;
import java.sql.*;

public class TransactionSavepoints {

        private static final String URL = "jdbc:postgresql://localhost:5432/Java";

        private static final String USER = "postgres";

        private static final String PASSWORD = "your_password";

        public static void main(String[] args) {

                String sql = "UPDATE employee SET salary = ? WHERE id = ?";

                try (Connection con = DriverManager.getConnection(
                                URL,
                                USER,
                                PASSWORD);

                                PreparedStatement ps = con.prepareStatement(sql)) {

                        // Start transaction
                        con.setAutoCommit(false);

                        Savepoint savepoint = null;

                        try {

                                // =================================
                                // STEP 1
                                // =================================

                                ps.setBigDecimal(
                                                1,
                                                new BigDecimal("55000"));

                                ps.setInt(2, 1);

                                ps.executeUpdate();

                                System.out.println(
                                                "Employee 1 updated");

                                // =================================
                                // STEP 2
                                // =================================

                                ps.setBigDecimal(
                                                1,
                                                new BigDecimal("65000"));

                                ps.setInt(2, 2);

                                ps.executeUpdate();

                                System.out.println(
                                                "Employee 2 updated");

                                // =================================
                                // SAVEPOINT
                                // =================================

                                savepoint = con.setSavepoint(
                                                "BeforeEmployee3");

                                System.out.println(
                                                "Savepoint created");

                                // =================================
                                // STEP 3
                                // =================================

                                ps.setBigDecimal(1, new BigDecimal("75000"));

                                ps.setInt(2, 3);

                                ps.executeUpdate();

                                System.out.println("Employee 3 updated");

                                // =================================
                                // SIMULATE ERROR
                                // =================================

                                throw new SQLException("Error while processing Employee 3");

                        } catch (SQLException e) {

                                System.out.println(
                                                "Error: " + e.getMessage());

                                // Rollback only after savepoint
                                con.rollback(savepoint);

                                System.out.println(
                                                "Rolled back to savepoint");

                                // Commit Employee 1 & 2
                                con.commit();

                                System.out.println(
                                                "Employee 1 and 2 changes committed");
                        }

                } catch (SQLException e) {

                        e.printStackTrace();
                }
        }
}
